package com.bt.bipat.tmf.dao.impl;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bt.adli.transport.jdbc.exception.JDBCTransportException;
import com.bt.bipat.tmf.dao.BipatTmfDAO;
import com.bt.bipat.tmf.exception.handler.UKBMSDDatabaseException;
import com.bt.bipat.tmf.model.BipatAttributes;
import com.bt.bipat.tmf.model.BipatInputDetails;
import com.bt.bipat.tmf.model.BipatResponseAttributes;
import com.bt.bipat.tmf.model.BipatTmfAttributes;
import com.bt.bipat.tmf.model.OrderData;
import com.bt.bipat.tmf.service.BipatTmfProcess;
import com.bt.bipat.tmf.util.DBQueries;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

@Repository
public class BipatTmfDaoImpl implements BipatTmfDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
//             private JDBCTransportDAOImpl             jdbcTransportDAO;
	private DataSource dataSourceName;
	private ArrayList<Object> attributesRefList;
	private ArrayList<Object> attributesRefList1;

	private ArrayList<Object> homeGatewayList;

	private String parent1 = null;
	private String relatedParty = null;

	private List<String> attributeNameList = new ArrayList<>();
	private List<String> displayTypeList = new ArrayList<>();
	private List<String> jsonTypeList = new ArrayList<>();
	private List<BigDecimal> parentAttribList = new ArrayList<>();
	private List<BigDecimal> attribIdList = new ArrayList<>();

	private Map<BigDecimal, String> attribIdValue = new LinkedHashMap<>();

	private List<String> keys = new ArrayList<>();
	private List<Object> keyValues = new ArrayList<>();
	private List<Object> values = new ArrayList<>();
	private List<String> objectValues = new ArrayList<>();

	int i = 0;
	private static String messageId = null;
	private static String from = null;

	OrderData orderData = new OrderData();
	private String errorcode;
	private String errordesc;

	JSONObject obj = null;
	Map<String, Object> jsonElements = null;
	private BipatTmfProcess bipatTmfProcess;

	/*
	 * @Autowired private BipatTmfProcess bipattmfprocess;
	 */

	@Autowired
	public void setBipatTmfProcess(@Lazy BipatTmfProcess bipatTmfProcess) {
		this.bipatTmfProcess = bipatTmfProcess;
	}

	private static final Logger logger = LoggerFactory.getLogger(BipatTmfDaoImpl.class);

	public BipatTmfDaoImpl(DataSource dataSourceName) {
		super();
		this.dataSourceName = dataSourceName;
		this.jdbcTemplate = new JdbcTemplate(dataSourceName);
		this.jdbcTemplate.setSkipUndeclaredResults(true);
	}

	// SaveMessageDetails
	@Transactional
	public void saveMessageDetails(BigDecimal reqId, String jsonMessage, String corelationId, String upstream,
			OrderData orderData, String status) {
		logger.info("Calling saveMessageDetails in line 94");
		logger.info("Data in line 95: " + reqId + ":" + jsonMessage + ":" + corelationId + ":" + upstream + ":"
				+ orderData + ":" + "Q");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		logger.info("inside saveMessageDetails time: " + time);

		Map<String, Object> sqlResult = new HashMap<String, Object>();
		BigDecimal errorcode = null;
		String errormsg = null;
		try {
			logger.info("Inside try  saveMessageDetails");
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSourceName).withCatalogName("MSD_COMMON_UTILS")
					.withProcedureName("p_insert_json_message_details")
					.declareParameters(new SqlParameter("in_request_sysid", Types.NUMERIC),
							new SqlParameter("in_json_request", Types.CLOB),
							new SqlParameter("in_order_id", Types.VARCHAR),
							new SqlParameter("in_upstream", Types.VARCHAR),
							new SqlParameter("in_received_date", Types.DATE),
							new SqlParameter("in_status", Types.VARCHAR),
							new SqlOutParameter("out_error_code", Types.NUMERIC),
							new SqlOutParameter("out_error_message", Types.VARCHAR));

			sqlResult = new HashMap<String, Object>();

			SqlParameterSource sqlParameter = new MapSqlParameterSource().addValue("in_request_sysid", reqId)
					.addValue("in_json_request", jsonMessage).addValue("in_order_id", corelationId)
					.addValue("in_upstream", "Vlocity").addValue("in_received_date", time).addValue("in_status", "Q");

			logger.info("Query Execution start time" + java.time.LocalTime.now());
			sqlResult = jdbcCall.execute(sqlParameter);
			logger.info("After execution of saveMessageDetails");
			errorcode = BigDecimal.valueOf(((BigDecimal) sqlResult.get("out_error_code")).intValue());
			errormsg = sqlResult.get("out_error_message").toString();
			logger.info("Data in line 127: " + reqId + ":" + jsonMessage + ":" + corelationId + ":" + upstream + ":"
					+ orderData + ":" + "Q");
			logger.info("Errors on Message Details line 129 : " + errorcode + ":" + errormsg);

		} catch (Exception e) {
			logger.error("error in saveMessageDetails() method in BipatTmfDaoImpl @132 : " + e.getMessage()
					+ " trace at line 516 : " + e.getStackTrace());
			e.printStackTrace();

			orderData.setErrorCode("801");
			orderData.setErrorMsg("Internal Error Please contact with BIPAT ASG]");
			orderData.setFlag("F");
		}
	}

	// ==saveRequestDetails

	@Transactional
	public void saveRequestDetails(List<BipatInputDetails> bipatInputDetails, OrderData orderData) throws SQLException {
		logger.info("Calling saveRequestDetails at 146");
		Map<String, Object> sqlResult = new HashMap<String, Object>();
		BigDecimal errorcode = null;
		String errormsg = null;

		try {

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("MSD_COMMON_UTILS")
					.withProcedureName("p_insert_json_input_details")
					.declareParameters(new SqlParameter("in_json_input", oracle.jdbc.OracleTypes.ARRAY, "t_json_input"),
							new SqlOutParameter("out_error_code", Types.NUMERIC),
							new SqlOutParameter("out_error_message", Types.VARCHAR));

			sqlResult = new HashMap<String, Object>();
			Object[][] retArr = listTo2DArray(bipatInputDetails);

			ARRAY saveArrayAC = getArrayDescriptor("T_JSON_INPUT", retArr);

			SqlParameterSource sqlParameter = new MapSqlParameterSource().addValue("in_json_input", saveArrayAC);
			logger.info("Query Execution start time" + java.time.LocalTime.now());
			sqlResult = jdbcCall.execute(sqlParameter);
			logger.info("After execution of saveMessageDetails");
			errorcode = BigDecimal.valueOf(((BigDecimal) sqlResult.get("out_error_code")).intValue());
			errormsg = sqlResult.get("out_error_message").toString();
			logger.info("Query Execution end time" + sqlResult);

		} catch (Exception e) {
			logger.error("error in saveRequestDetails() method in BipatTmfDaoImpl @173 : " + e.getMessage()
					+ " trace at line 175: " + e.getStackTrace());

			e.printStackTrace();

			orderData.setErrorCode("801");
			orderData.setErrorMsg("Internal Error [ Stored  procedure call  failed please contact Bipat ASG]");
			orderData.setFlag("F");

		}

	}

	// validateTmfOrderData

	@Transactional
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Override
	public String validateTmfOrderData(String json, OrderData orderData) throws Exception {

		logger.info("Inside validateTmfOrderData");
		ObjectMapper mapper = new ObjectMapper();
		List<String> keys = new ArrayList<>();
		List<Object> keyValues = new ArrayList<>();
		List<String> actionValues = new ArrayList<>();
		Map<String, Object> jsonElements = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
		});

		JSONObject jsonObject = new JSONObject(json);
		actionValues = getValuesInObject(jsonObject, "action");
		String action = "POST";
		BigDecimal errorcode1 = null;
		String errormsg1 = null;
		String status = null;
		String upstream = null;
		String corelationId = orderData.getCorelationId();
		String capacityDemandAmount = jsonObject.getJSONArray("reservationItem").getJSONObject(0)
				.getJSONObject("appliedCapacityAmount").getJSONObject("resourceCapacityDemand")
				.getString("capacityDemandAmount");
		String reservationState = jsonObject.getString("reservationState");
		String serviceType = jsonObject.getJSONArray("reservationItem").getJSONObject(0)
				.getJSONObject("appliedCapacityAmount").getJSONArray("resource").getJSONObject(0).getString("name");

		for (String reqAction : actionValues) {
			action = reqAction;
		}

		List<BipatAttributes> bipatAttributesList = new ArrayList<BipatAttributes>();
		List<BipatInputDetails> bipatInputDetailsList = new ArrayList<BipatInputDetails>();

		Map<String, Object> sqlResult = new HashMap<String, Object>();
		Connection con = DataSourceUtils.getConnection(dataSourceName);
		try {
			logger.info("Inside try validateTmfOrderData line 223 ");
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSourceName).withCatalogName("MSD_COMMON_UTILS")
					.withProcedureName("p_request")
					.declareParameters(new SqlParameter("in_request_type", Types.VARCHAR),
							new SqlParameter("in_order_type", Types.VARCHAR),
							new SqlOutParameter("out_json_attributes", oracle.jdbc.OracleTypes.CURSOR),
							new SqlOutParameter("out_error_code", Types.NUMERIC),
							new SqlOutParameter("out_error_message", Types.VARCHAR));

			sqlResult = new HashMap<String, Object>();
			logger.info("action line 235: " + action);
			SqlParameterSource sqlParameter = new MapSqlParameterSource().addValue("in_request_type", "I")
					.addValue("in_order_type", "POST");
			logger.info("Query Execution start time in line 237" + java.time.LocalTime.now());
			sqlResult = jdbcCall.execute(sqlParameter);
			logger.info("Query Execution end time in line 239" + sqlResult);

			attributesRefList1 = (ArrayList<Object>) sqlResult.get("out_json_attributes");
			errorcode1 = BigDecimal.valueOf(((BigDecimal) sqlResult.get("out_error_code")).intValue());
			errormsg1 = sqlResult.get("out_error_message").toString();

			logger.info("Errors through metadata in line 244: " + errorcode1 + ":" + errormsg1);
			logger.info("attributesRefList1 338 in line 245: " + attributesRefList1);

			for (Object iterateList : attributesRefList1) {
				if (iterateList instanceof Map) {
					// Map<String, Object> iterateList;
					Map<String, Object> row = (Map<String, Object>) iterateList;
					BipatAttributes bipatAttributes = new BipatAttributes();

					bipatAttributes.setAttribName(
							row.get("ATTRIBUTE_NAME") != null ? ((String) row.get("ATTRIBUTE_NAME")) : ""); // action

					bipatAttributes.setJsonType(row.get("JSON_TYPE") != null ? ((String) row.get("JSON_TYPE")) : "");
					bipatAttributes
							.setDisplayType(row.get("DISPLAY_TYPE") != null ? ((String) row.get("DISPLAY_TYPE")) : "");
					bipatAttributes.setMandatory(row.get("MANDATORY") != null ? ((String) row.get("MANDATORY")) : "");
					bipatAttributes.setParentAttribName(
							row.get("PARENT_ATTRIBUTE_NAME") != null ? ((String) row.get("PARENT_ATTRIBUTE_NAME"))
									: "");
					bipatAttributes.setParentAttribId(Optional.ofNullable(row.get("PARENT_ATTRIBUTE_ID"))
							.map(value -> ((BigDecimal) value).intValue()).map(BigDecimal::valueOf).orElse(null));
					bipatAttributes.setAttributeid(Optional.ofNullable(row.get("ATTRIBUTE_ID"))
							.map(value -> ((BigDecimal) value).intValue()).map(BigDecimal::valueOf).orElse(null));
					bipatAttributesList.add(bipatAttributes); // metadata
				}
			}

			for (BipatAttributes bipatAttribute : bipatAttributesList) {
				logger.info("Attribute Name in line 268:" + bipatAttribute.getAttribName());
				logger.info("JSON Type :" + bipatAttribute.getJsonType());
				logger.info("Display Type :" + bipatAttribute.getDisplayType());
				logger.info("MAndatory :" + bipatAttribute.getMandatory());
				logger.info("Parent Attribute name :" + bipatAttribute.getParentAttribName());
				logger.info("Parent Attribute Id :" + bipatAttribute.getParentAttribId());
				logger.info("Attribute Id :" + bipatAttribute.getAttributeid());

			}

			BipatInputDetails bipatInputDetails; //
			logger.info("Inside BipatInputDetails line 283");

			for (BipatAttributes bipatAttribute : bipatAttributesList) {

				if (bipatAttribute.getAttribName().equals("ROOT")) {

					logger.info("validate ROOT");
					continue;
				}

				bipatInputDetails = new BipatInputDetails();

				bipatInputDetails.setReqSysId(orderData.getRequestSysid());
				bipatInputDetails.setAttribName(bipatAttribute.getAttribName());
				bipatInputDetails.setDateTime(new Timestamp(System.currentTimeMillis()));
				bipatInputDetails.setAction(action);
				bipatInputDetails.setAttributeid(bipatAttribute.getAttributeid());
				bipatInputDetails.setParentAttribId(bipatAttribute.getParentAttribId());
				bipatInputDetails.setParentAttribName(bipatAttribute.getParentAttribName());

				if (bipatAttribute.getJsonType().equals("List") || bipatAttribute.getJsonType().equals("Array")) {
					bipatInputDetails.setAttribValue(null);
					logger.info("getJsonType check line 301");
				}
				if (bipatAttribute.getDisplayType().equals("Object")
						|| bipatAttribute.getDisplayType().equals("Name")) {
					logger.info("getDisplayType check line 304");
					parent1 = bipatInputDetails.getParentAttribName();
					getAllKeys(jsonElements, keys, keyValues, parent1, bipatInputDetails);

				}
				if (bipatAttribute.getMandatory().equals("Y")) // mandatory
				{
					logger.info("getMandatory check line 310");

					if (bipatInputDetails.getAttribValue() == null || bipatInputDetails.getAttribValue() == "") {
						logger.info("Mandatory attribute not sent, Attribute Name and Parent Name : "
								+ bipatAttribute.getAttribName() + ":" + bipatAttribute.getParentAttribName());
						orderData.setErrorCode("1102");
						orderData.setFlag("F");
						orderData.setErrorMsg(bipatAttribute.getAttribName() + " Mandatory attribute not sent");

					}
				}
				bipatInputDetailsList.add(bipatInputDetails);// json parse data
			}
			for (BipatInputDetails bipatInputDetails1 : bipatInputDetailsList) {

				logger.info("Attribute Name Details: " + bipatInputDetails1.getAttribName() + ":"
						+ bipatInputDetails1.getAttribValue() + ":" + bipatInputDetails1.getAction() + ":"
						+ bipatInputDetails1.getDateTime() + ":" + bipatInputDetails1.getParentAttribName() + ":"
						+ bipatInputDetails1.getAttributeid());

			}

			// saveRequestMaster(orderData.getRequestSysid(), orderData.getFromValue() ,
			// null, "Q", "Q", null, null, orderData.getMessageId(), "I", action,
			// replyToAdrress, "GSIPT", "PROVIDE", orderData);
			logger.info("Error code @ 466: " + orderData.getErrorCode());
			if (orderData.getErrorCode() == "0") {

				// saveMessageDetails(orderData.getRequestSysid(), json, corelationId,
				// "Vlocity", orderData, "Q");

				// logger.info("In savemsgdetails line 340");

				saveRequestDetails(bipatInputDetailsList, orderData);

				logger.info("In savereqdetails line 342");
			}
			// commit all save operations

			// con.commit();

			if (orderData.getErrorCode() == "0" && action.equals("POST")) {
				logger.info("In process line 357");

				// bipatTmfProcess.getSubnetSize(json, orderData);
				// bipatTmfProcess.process(json, orderData, reservationState, serviceType);

			}
		} catch (Exception e) {
			logger.error("error in validateTmfOrderData() method in BipatTmfDaoImpl : " + e.getMessage(), e);

			e.printStackTrace();

			orderData.setErrorCode(errormsg1);
			orderData.setErrorMsg(e.getMessage());

		} /*
			 * finally { con.close(); }
			 */
		return action;
	}

	// getAllKeys
	@SuppressWarnings("unchecked")
	private void getAllKeys(Map<String, Object> jsonElements, List<String> keys, List<Object> keyValues, String parent,
			BipatInputDetails bipatInputDetails) {

		jsonElements.entrySet().forEach(entry -> { // {name=BTCIENABP-messageName,value=createInventoryReceived}
			keys.add(entry.getKey());
			keyValues.add(entry.getValue());

			if (bipatInputDetails.getParentAttribName().equals(parent) && !(entry.getValue() instanceof Map)
					&& !(entry.getValue() instanceof List)) {
				if (parent1.equals("relatedParty")) {
					System.out.println("relatedParty data: " + entry.getKey() + ":" + entry.getValue());
					if (entry.getKey().equals("role")) {
						relatedParty = entry.getValue().toString();
					}
					if (entry.getKey().equals("id")) {
						relatedParty = entry.getValue().toString();
					}
				}

				logger.info("Object: " + entry.getKey() + ":" + entry.getValue() + ":" + parent
						+ " bipatInputDetails.getParentAttribName()" + bipatInputDetails.getParentAttribName());
				if (bipatInputDetails.getAttribName().equals(entry.getKey())) {
					bipatInputDetails.setAttribValue(entry.getValue().toString());
				} else {
					if (entry.getKey().equals("name") && entry.getValue().equals(bipatInputDetails.getDefaultValue())) {

						bipatInputDetails.setAttribName(entry.getValue().toString());
						bipatInputDetails.setAttribValue(entry.getValue().toString());
						i = 1; // iterate one more time to get value
					} else if (i == 1 && entry.getKey().equals("id")
							&& entry.getValue().equals(bipatInputDetails.getDefaultValue())) {
						bipatInputDetails.setAttribName(entry.getValue().toString());
						bipatInputDetails.setAttribValue(entry.getValue().toString());
						i = 0; // reset
						return;
					}
				}

			}

			if (entry.getValue() instanceof Map) {
				parent1 = entry.getKey();
				Map<String, Object> map = (Map<String, Object>) entry.getValue();
				getAllKeys(map, keys, keyValues, parent1, bipatInputDetails);

			} else if (entry.getValue() instanceof List) {
				parent1 = entry.getKey();
				List<?> list = (List<?>) entry.getValue(); // [{name=,value=},{name =,value =}]
				list.forEach(listEntry -> {
					if (listEntry instanceof Map) {
						Map<String, Object> map = (Map<String, Object>) listEntry; // {name=,value=}
						getAllKeys(map, keys, keyValues, parent1, bipatInputDetails);
					}
				});
			}
		});
	}

	// RequestSysId

	public BigDecimal getRequestSysId() throws SQLException {
		logger.info("Inside getRequestSysId");

		String sql = null;
		String reqSysid = null;
		BigDecimal resSysid = null;
		try {

			sql = DBQueries.REQUEST_SYSID;

			reqSysid = jdbcTemplate.queryForObject(sql, new Object[] {}, String.class);
			resSysid = new BigDecimal(reqSysid);

		} catch (Exception e) {
			logger.error("Error in getRequestSysId() method: " + e.getMessage(), e);
			logger.info(e.getMessage());
			e.printStackTrace();
		}

		logger.info("return resSysid");
		return resSysid;

	}

	public List<String> getValuesInObject(JSONObject jsonObject, String key) {
		List<String> accumulatedValues = new ArrayList<>();
		for (String currentKey : jsonObject.keySet()) {
			Object value = jsonObject.get(currentKey);
			if (currentKey.equals(key)) {
				accumulatedValues.add(value.toString());
			}

			if (value instanceof JSONObject) {
				accumulatedValues.addAll(getValuesInObject((JSONObject) value, key));
			} else if (value instanceof JSONArray) {
				accumulatedValues.addAll(getValuesInArray((JSONArray) value, key));
			}
		}

		return accumulatedValues;
	}

	public List<String> getValuesInArray(JSONArray jsonArray, String key) {
		List<String> accumulatedValues = new ArrayList<>();
		for (Object obj : jsonArray) {
			if (obj instanceof JSONArray) {
				accumulatedValues.addAll(getValuesInArray((JSONArray) obj, key));
			} else if (obj instanceof JSONObject) {
				accumulatedValues.addAll(getValuesInObject((JSONObject) obj, key));
			}
		}

		return accumulatedValues;
	}

	private Object[][] listTo2DArray(List<BipatInputDetails> bipatInputDetails) {
		Object[][] retArr = new Object[bipatInputDetails.size()][8];
		for (int i = 0; i < bipatInputDetails.size(); i++) {
			BipatInputDetails obj = bipatInputDetails.get(i);
			retArr[i][0] = obj.getReqSysId();
			retArr[i][1] = obj.getParentAttribName();
			retArr[i][2] = obj.getAttribName();
			retArr[i][3] = obj.getAttribValue();
			retArr[i][4] = obj.getDateTime();
			retArr[i][5] = obj.getAction();
			retArr[i][6] = obj.getAttributeid();
			retArr[i][7] = obj.getParentAttribId();

		}
		return retArr;
	}

	public ARRAY getArrayDescriptor(String arrayDescriptorName, Object[][] strArray) throws Exception {
		ArrayDescriptor desc = null;
		ARRAY array = null;
		Connection con = DataSourceUtils.getConnection(dataSourceName);
		try {
			desc = ArrayDescriptor.createDescriptor(arrayDescriptorName, con);

			array = new ARRAY(desc, con, strArray);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} /*
			 * finally { con.close(); }
			 */
		return array;
	}

	public void incrementIPCount(String contextPath, int count) {
		try {
			int status = jdbcTemplate.update(CommonSQL.INCREMENT_IP_COUNT, count, contextPath);
			if (status == 1) {
				logger.info("Updated IP Count");
			} else {
				logger.error("Could not Update IP Count");
			}
		} catch (Exception e) {
			logger.error("Error in incrementIPCount() method: " + e.getMessage(), e);
			e.printStackTrace();
		}
	}

	public void decrementIPCount(String contextPath, int count) {
		try {
			int status = jdbcTemplate.update(CommonSQL.DECREMENT_IP_COUNT, count, contextPath);
			if (status == 1) {
				logger.info("Updated IP Count");
			} else {
				logger.error("Could not Update IP Count");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public void recordCeaseFailed(String IP_ADDRESS, String Container, String BlockType, String messageId,
			String Failure_Reason) {
		try {
			int status = jdbcTemplate.update(CommonSQL.RECORD_CEASE_FAILURE, IP_ADDRESS, Container, BlockType,
					messageId, Failure_Reason);
			if (status == 1) {
				logger.info("Recorded Cease Failure");
			} else {
				logger.error("Could not Recorded Cease Failure");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public void createService(OrderData orderData) throws UKBMSDDatabaseException, SQLException {
		logger.info("Inside createService");

		Map<String, Object> sqlResult = new HashMap<>();
		String errorMsg = null;

		try {
			logger.info("Preparing to call CREATE_SERVICE stored procedure");

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSourceName).withSchemaName("MSL_ADMIN")
					.withCatalogName("MSD_SERVICES_PKG").withProcedureName("CREATE_SERVICE")
					.declareParameters(new SqlParameter("I_SERVICE_TYPE_ID", Types.VARCHAR),
							new SqlParameter("I_BASE_ADDRESS", Types.VARCHAR),
							new SqlParameter("I_CLUSTER_ID", Types.INTEGER),
							new SqlParameter("I_HGW_ID", Types.INTEGER),
							new SqlParameter("I_CUSTOMER_ID", Types.VARCHAR),
							new SqlParameter("I_CLUSTER_DOMAIN_NAME", Types.VARCHAR),
							new SqlParameter("I_HGW_NAME", Types.VARCHAR),
							new SqlParameter("I_RADIUS_CONFIG", Types.VARCHAR),
							new SqlOutParameter("O_NETWORK_USER_ID", Types.VARCHAR),
							new SqlParameter("I_IPV6_Address", Types.VARCHAR),

							new SqlOutParameter("O_RESPONS_CODE", Types.INTEGER),
							new SqlOutParameter("O_RESPONSE_MSG", Types.VARCHAR));

			logger.info("Getting values: " + "ServiceTypeID: " + orderData.getServiceTypeID() + ", " + "BaseIpAddress: "
					+ orderData.getBaseIpAddress() + ", " + "ClusterID: " + orderData.getClusterID() + ", "
					+ "HomeGatewayID: " + orderData.getHomeGatewayID() + ", " + "CustomerID: "
					+ orderData.getCustomerID() + ", " + "DomainName: " + orderData.getDomainName() + ", " + "HgwName: "
					+ orderData.getHgwName() + ", " + "RadiusConfig: " + orderData.getRadiusConfig() + ", "
					+ "IPV6Address: " + orderData.getIPV6Address());

			SqlParameterSource sqlParameter = new MapSqlParameterSource()
					.addValue("I_SERVICE_TYPE_ID", orderData.getServiceTypeID())
					.addValue("I_BASE_ADDRESS", orderData.getBaseIpAddress())
					.addValue("I_CLUSTER_ID",
							orderData.getClusterID() != null ? orderData.getClusterID().intValue() : null)
					.addValue("I_HGW_ID",
							orderData.getHomeGatewayID() != null ? orderData.getHomeGatewayID().intValue() : null)
					.addValue("I_CUSTOMER_ID", orderData.getCustomerID())
					.addValue("I_CLUSTER_DOMAIN_NAME", orderData.getDomainName()).addValue("I_HGW_NAME", "")
					.addValue("I_RADIUS_CONFIG", orderData.getRadiusConfig())
					.addValue("I_IPV6_Address", orderData.getIPV6Address());

			logger.info("Executing stored procedure at " + java.time.LocalTime.now());
			sqlResult = jdbcCall.execute(sqlParameter);
			logger.info("Stored procedure execution completed");

			Integer responsCode = (Integer) sqlResult.get("O_RESPONS_CODE");
			String responseMsg = (String) sqlResult.get("O_RESPONSE_MSG");

			logger.info("IPv6 Address  in line 656 => " + orderData.getIPV6Address());

			String resourceID = (String) sqlResult.get("O_NETWORK_USER_ID");
			// Integer currentServiceCount = (Integer)
			// sqlResult.get("O_CURRENT_SERVICE_COUNT");
			Integer errorCode = (Integer) sqlResult.get("O_RESPONS_CODE");
			errorMsg = (String) sqlResult.get("O_RESPONSE_MSG");
			logger.info("error message is 653 :" + errorMsg);
			logger.info("error message is 653 :" + errorCode);

			if (errorCode != null && errorCode == 0) {
				orderData.setResourceID(resourceID);
				logger.info("NWID received is => " + orderData.getResourceID());
			} else {
				logger.error("Failed to create service. Error Code: " + errorCode + ", Error Message: " + errorMsg);
				throw new UKBMSDDatabaseException(704, "Request cannot be processed, please retry after some time");
			}

		} catch (Exception e) {
			logger.error("Error in createService() method: " + e.getMessage(), e);
			// e.printStackTrace();
			throw new UKBMSDDatabaseException(704, "Request cannot be processed, please retry after some time");
		}

	}

	// Context Path

	@Transactional
	public OrderData getContextPath(OrderData orderData) throws JDBCTransportException {
		logger.info("Inside getContextPath");

		Map<String, Object> sqlResult = new HashMap<>();
		BigDecimal errorCode = null;
		String errorMsg = null;

		try {
			logger.info("Preparing to call GET_NETWORK_DETAILS stored procedure");

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSourceName).withCatalogName("MSD_COMMON_UTILS")
					.withProcedureName("GET_NETWORK_DETAILS_UKBTMF")
					.declareParameters(new SqlParameter("I_CUSTOMER_ID", Types.VARCHAR),
							new SqlParameter("I_SERVICE_TYPE", Types.VARCHAR),
							new SqlParameter("I_SERVICE", Types.VARCHAR),
							new SqlOutParameter("O_CLUSTER_DETAILS", oracle.jdbc.OracleTypes.CURSOR),
							new SqlOutParameter("O_CURRENT_SERVICE_COUNT", Types.INTEGER),
							new SqlOutParameter("O_RESPONSE_CODE", Types.INTEGER),
							new SqlOutParameter("O_RESPONSE_MSG", Types.VARCHAR));

			orderData.setCustomerID("BTRetail Business Broadband");
			SqlParameterSource sqlParameter = new MapSqlParameterSource()
					.addValue("I_CUSTOMER_ID", orderData.getCustomerID())
					.addValue("I_SERVICE_TYPE", orderData.getServiceType()).addValue("I_SERVICE", "");

			logger.info("Executing stored procedure at " + java.time.LocalTime.now());
			sqlResult = jdbcCall.execute(sqlParameter);
			logger.info("Stored procedure execution completed");

			homeGatewayList = (ArrayList<Object>) sqlResult.get("O_CLUSTER_DETAILS");

			for (Object iterateList : homeGatewayList) {
				if (iterateList instanceof Map) {
					// Map<String, Object> iterateList;
					Map<String, Object> row = (Map<String, Object>) iterateList;
					// OrderData orderData = new OrderData();

					orderData.setContainer(row.get("CONTEXT_PATH") != null ? ((String) row.get("CONTEXT_PATH")) : ""); // action
					orderData.setIPNumber(row.get("NUMBER_OF_IPS") != null ? ((BigDecimal) row.get("NUMBER_OF_IPS"))
							: BigDecimal.valueOf(0));
					orderData.setClusterID(row.get("CLUSTER_ID") != null ? ((BigDecimal) row.get("CLUSTER_ID"))
							: BigDecimal.valueOf(0));
					orderData.setHomeGatewayID(
							row.get("HGW_ID") != null ? ((BigDecimal) row.get("HGW_ID")) : BigDecimal.valueOf(0));
					orderData.setDomainName(
							row.get("CLUSTER_DOMAIN_NAME") != null ? ((String) row.get("CLUSTER_DOMAIN_NAME")) : "");
					orderData.setHgwName(row.get("HGW_NAME") != null ? ((String) row.get("HGW_NAME")) : "");
					orderData.setMaxServiceCount(
							row.get("MAX_SERVICE_COUNT") != null ? ((BigDecimal) row.get("MAX_SERVICE_COUNT"))
									: BigDecimal.valueOf(0));
					orderData.setBlockType(row.get("BLOCK_TYPE") != null ? ((String) row.get("BLOCK_TYPE")) : "");

					// bipatAttributesList.add(bipatAttributes); // metadata

					logger.info("Context path in line 721:" + orderData.getContainer());
					logger.info("NUMBER_OF_IPS :" + orderData.getIPNumber());
					logger.info("CLUSTER_ID :" + orderData.getClusterID());
					logger.info("HGW_ID :" + orderData.getHomeGatewayID());
					logger.info("CLUSTER_DOMAIN_NAME :" + orderData.getDomainName());
					logger.info("HGW_NAME :" + orderData.getHgwName());
					logger.info("MAX_SERVICE_COUNT :" + orderData.getMaxServiceCount());
					logger.info("BLOCK_TYPE :" + orderData.getBlockType());
				}
			}

			errorCode = BigDecimal.valueOf(((Integer) sqlResult.get("O_RESPONSE_CODE")).intValue());
			errorMsg = (String) sqlResult.get("O_RESPONSE_MSG");
			String responseMsg = (String) sqlResult.get("O_RESPONSE_MSG");
			logger.info("Error message" + errorMsg + "Context Path is: " + orderData.getContainer());

			// logger.info("Output from DB: O_CLUSTER_DETAILS=" + errorCode + ", param5=" +
			// errorMsg , O_RESPONSE_MSG=" + responseMsg);

			logger.info("Response from stored procedure: networkDataObj=" + errorCode + ", param5=" + errorMsg
					+ ", O_RESPONSE_MSG=" + responseMsg);

		} catch (Exception e) {
			logger.error("Error in getContextPath() method: " + e.getMessage(), e);

			e.printStackTrace();
			orderData.setErrorCode("801");
			orderData.setErrorMsg("Internal Error Please contact with BIPAT ASG");
			orderData.setFlag("F");
		}

		return orderData;
	}

	@Transactional
	public BipatTmfAttributes generatePostResp(OrderData orderData) throws Exception {
		logger.info("Inside generatePostResp: ReqSysID" + orderData.getRequestSysid() + "  ResourceID is "
				+ orderData.getResourceID());
		// JSONObject parentJson = new JSONObject();

		BigDecimal errCode = null;
		String errormsg = null;
		BipatTmfAttributes bipatTMFAttributes = new BipatTmfAttributes();
		Map<String, Object> sqlResult = new HashMap<String, Object>();
		List<BipatResponseAttributes> bipatResponseAttributesList = new ArrayList<BipatResponseAttributes>();

		JSONObject parentJson = new JSONObject() {
			/**
			 * changes the value of JSONObject.map to a LinkedHashMap in order to maintain
			 * order of keys.
			 */
			@Override
			public JSONObject put(String key, Object value) throws JSONException {
				try {
					Field map = JSONObject.class.getDeclaredField("map");
					map.setAccessible(true);
					Object mapValue = map.get(this);
					if (!(mapValue instanceof LinkedHashMap)) {
						map.set(this, new LinkedHashMap<>());
					}
				} catch (NoSuchFieldException | IllegalAccessException e) {
					throw new RuntimeException(e);
				}
				return super.put(key, value);
			}
		};

		try {

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSourceName).withCatalogName("MSD_COMMON_UTILS")
					.withProcedureName("p_json_response_data")
					.declareParameters(new SqlParameter("in_request_sysid", Types.NUMERIC),
							new SqlParameter("in_resource_id", Types.VARCHAR),
							new SqlOutParameter("out_json_response_data", oracle.jdbc.OracleTypes.CURSOR),
							new SqlInOutParameter("out_error_code", Types.NUMERIC),
							new SqlInOutParameter("out_error_message", Types.VARCHAR));

			SqlParameterSource sqlParameter = new MapSqlParameterSource()
					.addValue("in_request_sysid", orderData.getRequestSysid())
					.addValue("in_resource_id", orderData.getResourceID())
					.addValue("out_error_code", orderData.getErrorCode())
					.addValue("out_error_message", orderData.getErrorMsg());

			sqlResult = jdbcCall.execute(sqlParameter);

			attributesRefList = new ArrayList<Object>();

			attributesRefList = (ArrayList<Object>) sqlResult.get("out_json_response_data");

			errCode = BigDecimal.valueOf(((BigDecimal) sqlResult.get("out_error_code")).intValue());
			errormsg = sqlResult.get("out_error_message").toString();
			logger.info("out_error_code: " + errCode + " out_error_message" + errormsg);
			logger.info("attributesRefList for Responnse generation: " + attributesRefList);

			for (Object iterateList : attributesRefList) {
				if (iterateList instanceof Map) {
					Map<String, Object> row = (Map<String, Object>) iterateList;
					BipatResponseAttributes bipatResponseAttributes = new BipatResponseAttributes();

					bipatResponseAttributes.setSysid(BigDecimal.valueOf(((BigDecimal) row.get("SYSID")).intValue()));
					bipatResponseAttributes
							.setParentSysid(BigDecimal.valueOf(((BigDecimal) row.get("PARENT_SYSID")).intValue()));
					bipatResponseAttributes.setAttributeName(
							row.get("ATTRIBUTE_NAME") != null ? ((String) row.get("ATTRIBUTE_NAME")) : "");
					bipatResponseAttributes.setParentDisplayOrder(
							BigDecimal.valueOf(((BigDecimal) row.get("PARENT_DISPLAY_ORDER")).intValue()));
					bipatResponseAttributes.setAttribtDisplayOrder(
							BigDecimal.valueOf(((BigDecimal) row.get("ATTRIB_DISPLAY_ORDER")).intValue()));
					bipatResponseAttributes.setParentFlag(
							row.get("PARENT_FLAG") != null && !((String) row.get("PARENT_FLAG")).isEmpty()
									? ((String) row.get("PARENT_FLAG")).charAt(0)
									: '\0');
					bipatResponseAttributes
							.setObjectType(row.get("OBJECT_TYPE") != null ? ((String) row.get("OBJECT_TYPE")) : null);
					bipatResponseAttributes.setModel(row.get("MODEL") != null ? ((String) row.get("MODEL")) : null);
					bipatResponseAttributes
							.setCapability(row.get("CAPABILITY") != null ? ((String) row.get("CAPABILITY")) : null);
					bipatResponseAttributes.setDisplaytype(
							row.get("DISPLAY_TYPE") != null ? ((String) row.get("DISPLAY_TYPE")) : null);
					bipatResponseAttributes
							.setJsonType(row.get("JSON_TYPE") != null ? ((String) row.get("JSON_TYPE")) : null);
					bipatResponseAttributes.setAttributeValue(
							row.get("ATTRIBUTE_VALUE") != null ? ((String) row.get("ATTRIBUTE_VALUE")) : "");
					bipatResponseAttributes
							.setGroupSequence(BigDecimal.valueOf(((BigDecimal) row.get("GROUP_SEQUENCE")) != null
									? ((BigDecimal) row.get("GROUP_SEQUENCE")).intValue()
									: -1));

					bipatResponseAttributesList.add(bipatResponseAttributes);

				}
			}

			// System.out.println("cbpResponseAttributesList: "+cbpResponseAttributesList);
			for (BipatResponseAttributes bipatResponseAttribute : bipatResponseAttributesList) {
				BigDecimal parentSysID = bipatResponseAttribute.getParentSysid();

				if (parentSysID.intValue() == 0)
//                                                             if (bipatResponseAttribute.getAttributeName().equals("reservationState"))
				{
					String displaytype = bipatResponseAttribute.getDisplaytype();

					if (displaytype != null) {
						parentJson.put(bipatResponseAttribute.getAttributeName(),
								bipatResponseAttribute.getAttributeValue());

					}

					else if (displaytype == null) {

						JSONObject childObject = generateBIPATJSONObject(bipatResponseAttribute.getAttributeName(),
								bipatResponseAttribute.getSysid().intValue(), bipatResponseAttributesList);

						parentJson.put(bipatResponseAttribute.getAttributeName(), childObject);

					}

				}

			}
		}

		catch (Exception e) {
			logger.error("error in generatePostResp() method at line 269 : " + e.getMessage() + " trace at line 269 : "
					+ e.getStackTrace());
			e.printStackTrace();
//                                             requestData.setErrorCode(BigDecimal.valueOf(10));
//                                             requestData.setErrorMsg("Response JSON is not Generated");
		}
		logger.info("JSON is " + getValuesInObject(parentJson, "payload").get(0));
//                             JSONParser parser   =  new JSONParser(getValuesInObject(parentJson, "payload").get(0));

		bipatTMFAttributes.setJsonobject(new JSONObject(getValuesInObject(parentJson, "payload").get(0)));
		bipatTMFAttributes.setErrorCode(errCode);
		bipatTMFAttributes.setErrorMsg(errormsg);

		logger.info("Generated JSON is :: " + bipatTMFAttributes.getJsonobject().toString(1));
		return bipatTMFAttributes;
	}

	private static JSONObject generateBIPATJSONObject(String attribName, int sysId,
			List<BipatResponseAttributes> bipatResponseAttributesList) {
		// JSONObject jsonObject = new JSONObject();
		JSONObject jsonObject = new JSONObject() {
			/**
			 * changes the value of JSONObject.map to a LinkedHashMap in order to maintain
			 * order of keys.
			 */
			@Override
			public JSONObject put(String key, Object value) throws JSONException {
				try {
					Field map = JSONObject.class.getDeclaredField("map");
					map.setAccessible(true);
					Object mapValue = map.get(this);
					if (!(mapValue instanceof LinkedHashMap)) {
						map.set(this, new LinkedHashMap<>());
					}
				} catch (NoSuchFieldException | IllegalAccessException e) {
					throw new RuntimeException(e);
				}
				return super.put(key, value);
			}
		};

		JSONArray jsArray = new JSONArray();
		for (BipatResponseAttributes bipatResponseAttribute : bipatResponseAttributesList) {

			if (sysId == bipatResponseAttribute.getParentSysid().intValue()) {

				if (bipatResponseAttribute.getParentFlag() != null && bipatResponseAttribute.getDisplaytype() == null
						&& bipatResponseAttribute.getJsonType().equals("List")) {
					JSONObject childJsonObject = generateBIPATJSONObject(bipatResponseAttribute.getAttributeName(),
							bipatResponseAttribute.getSysid().intValue(), bipatResponseAttributesList);

					jsonObject.put(bipatResponseAttribute.getAttributeName(), childJsonObject);

				} else if (bipatResponseAttribute.getParentFlag() != null
						&& bipatResponseAttribute.getDisplaytype() == null
						&& bipatResponseAttribute.getJsonType().equals("Array")) {

					JSONArray jsonArray = generateBipatJSONArray(bipatResponseAttribute.getAttributeName(),
							bipatResponseAttribute.getSysid().intValue(), bipatResponseAttributesList);

					jsonObject.put(bipatResponseAttribute.getAttributeName(), jsonArray);

				} else {

					jsonObject.put(bipatResponseAttribute.getAttributeName(),
							bipatResponseAttribute.getAttributeValue());
//                                                                             }
				}
			}
		}
		return jsonObject;
	}

	private static JSONArray generateBipatJSONArray(String attribName, int sysId,
			List<BipatResponseAttributes> bipatResponseAttributesList) throws JSONException {
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = null;
		int objcount = 0;
		int groupsequence = -2; // -2 initialise

		try {
			for (BipatResponseAttributes rpacsCBPAttribute : bipatResponseAttributesList) {
				if (sysId == rpacsCBPAttribute.getParentSysid().intValue()) {

					if (groupsequence != rpacsCBPAttribute.getGroupSequence().intValue()) {

						// obj = new JSONObject();
						obj = new JSONObject() {
							/**
							 * changes the value of JSONObject.map to a LinkedHashMap in order to maintain
							 * order of keys.
							 */
							@Override
							public JSONObject put(String key, Object value) throws JSONException {
								try {
									Field map = JSONObject.class.getDeclaredField("map");
									map.setAccessible(true);
									Object mapValue = map.get(this);
									if (!(mapValue instanceof LinkedHashMap)) {
										map.set(this, new LinkedHashMap<>());
									}
								} catch (NoSuchFieldException | IllegalAccessException e) {
									throw new RuntimeException(e);
								}
								return super.put(key, value);
							}
						};
//                                                                                                                             
					}

					if (rpacsCBPAttribute.getDisplaytype() != null) {
						if (rpacsCBPAttribute.getDisplaytype().equals("Name_Value")) {
							obj.put("name", rpacsCBPAttribute.getAttributeName());
							obj.put("value", rpacsCBPAttribute.getAttributeValue());

						} else if (rpacsCBPAttribute.getDisplaytype().equals("Type_Value")) {
							obj.put("type", rpacsCBPAttribute.getAttributeName());
							obj.put("value", rpacsCBPAttribute.getAttributeValue());
						}

						else if (rpacsCBPAttribute.getDisplaytype().equals("Object")) {
							obj.put(rpacsCBPAttribute.getAttributeName(), rpacsCBPAttribute.getAttributeValue());

						}
					} else if (rpacsCBPAttribute.getDisplaytype() == null
							&& rpacsCBPAttribute.getJsonType().equals("Array")) {
						// added for type value and name value
						if (rpacsCBPAttribute.getJsonType().equals("Array")) {

							JSONArray jsonArray1 = generateBipatJSONArray(rpacsCBPAttribute.getAttributeName(),
									rpacsCBPAttribute.getSysid().intValue(), bipatResponseAttributesList);
							System.out.println("jsonArray 129:" + jsonArray);
							obj.put(rpacsCBPAttribute.getAttributeName(), jsonArray1);
						} else if (rpacsCBPAttribute.getJsonType().equals("List")) {
							JSONObject childJsonObject = generateBIPATJSONObject(rpacsCBPAttribute.getAttributeName(),
									rpacsCBPAttribute.getSysid().intValue(), bipatResponseAttributesList);
							obj.put(rpacsCBPAttribute.getAttributeName(), childJsonObject);
						}

					} else if (rpacsCBPAttribute.getDisplaytype() == null
							&& rpacsCBPAttribute.getJsonType().equals("List")) {
						JSONObject childJsonObject = generateBIPATJSONObject(rpacsCBPAttribute.getAttributeName(),
								rpacsCBPAttribute.getSysid().intValue(), bipatResponseAttributesList);
						obj.put(rpacsCBPAttribute.getAttributeName(), childJsonObject);
					}

					if (groupsequence != rpacsCBPAttribute.getGroupSequence().intValue()) {
						if (rpacsCBPAttribute.getDisplaytype() != null) {
							if (rpacsCBPAttribute.getDisplaytype().equals("Name_Value")) {
								jsonArray.put(obj);
							} else if (rpacsCBPAttribute.getDisplaytype().equals("Type_Value")) {
								jsonArray.put(obj);

							} else if (rpacsCBPAttribute.getDisplaytype().equals("Object")) {
								jsonArray.put(obj);
								groupsequence = rpacsCBPAttribute.getGroupSequence().intValue();
							}
						}

						else {

							groupsequence = rpacsCBPAttribute.getGroupSequence().intValue();
							// added by Sharvari
							jsonArray.put(obj);
						}

					}

				}

			}
		}

		catch (Exception e) {
			logger.error("error in getRpacsDeviceTmfDetails() method at line 380 : " + e.getMessage()
					+ " trace at line 380 : " + e.getStackTrace());
			e.printStackTrace();
		}

		return jsonArray;
	}

	private void getAllKeys(Map<String, Object> jsonElements, List<String> keys, List<Object> keyValues, String parent,
			BipatInputDetails bipatInputDetails) {

		jsonElements.entrySet().forEach(entry -> { // {name=BTCIENABP-messageName,value=createInventoryReceived}
			keys.add(entry.getKey());
			keyValues.add(entry.getValue());

			if (bipatInputDetails.getParentAttribName().equals(parent) && !(entry.getValue() instanceof Map)
					&& !(entry.getValue() instanceof List)) {
				if (parent1.equals("relatedParty")) {
					System.out.println("relatedParty data: " + entry.getKey() + ":" + entry.getValue());
					if (entry.getKey().equals("role")) {
						relatedParty = entry.getValue().toString();
					}
					if (entry.getKey().equals("id")) {
						relatedParty = entry.getValue().toString();
					}
				}

				logger.info("Object: " + entry.getKey() + ":" + entry.getValue() + ":" + parent
						+ " bipatInputDetails.getParentAttribName()" + bipatInputDetails.getParentAttribName());
				if (bipatInputDetails.getAttribName().equals(entry.getKey())) {
					bipatInputDetails.setAttribValue(entry.getValue().toString());
				} else {
					if (entry.getKey().equals("name")) {

						bipatInputDetails.setAttribName(entry.getValue().toString());
						bipatInputDetails.setAttribValue(entry.getValue().toString());
						i = 1; // iterate one more time to get value
					} else if (i == 1 && entry.getKey().equals("id")) {
						bipatInputDetails.setAttribName(entry.getKey().toString());
						bipatInputDetails.setAttribValue(entry.getValue().toString());
						i = 2; // reset

					} else if (i == 2 && entry.getKey().equals("@referredType")) {
						bipatInputDetails.setAttribName(entry.getKey().toString());
						bipatInputDetails.setAttribValue(entry.getValue().toString());
						i = 0; // reset
						return;

					}
				}

			}

			if (entry.getValue() instanceof Map) {
				parent1 = entry.getKey();
				Map<String, Object> map = (Map<String, Object>) entry.getValue();
				getAllKeys(map, keys, keyValues, parent1, bipatInputDetails);

			} else if (entry.getValue() instanceof List) {
				parent1 = entry.getKey();
				List<?> list = (List<?>) entry.getValue(); // [{name=,value=},{name =,value =}]
				list.forEach(listEntry -> {
					if (listEntry instanceof Map) {
						Map<String, Object> map = (Map<String, Object>) listEntry; // {name=,value=}
						getAllKeys(map, keys, keyValues, parent1, bipatInputDetails);
					}
				});
			}
		});
	}

}
