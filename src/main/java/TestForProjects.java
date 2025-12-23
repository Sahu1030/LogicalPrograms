import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestForProjects {
void carddata() {
	
		Thread t = Thread.currentThread();
	

	List<Map<String, Object>> cardid2 = snowIMSService.getImsCardIDDetails(imsDay0Device.get(i),
			imsSchemas.get(k), imsDay0Field); //issue here

	Map<Object, Object> cardID2Map = new HashMap<Object, Object>();
	Map<Object, Object> cardIDMap = new HashMap<Object, Object>();

	final List<String> cardId2List = new ArrayList<>();
	final List<String> cardIdList = new ArrayList<>();

	try {

		
		cardid2.stream()
        .forEach(CardID2Data -> {
            if (!CardID2Data.isEmpty()) {
    				cardId2List.add(CardID2Data.get("Card_ID2") != null
    						? ((String) CardID2Data.get("Card_ID2"))
    						: "");
    				cardIdList.add(CardID2Data.get("Card_ID") != null
    						? ((String) CardID2Data.get("Card_ID"))
    						: "");

    		}
        });


	

		cardId2List = new ArrayList<>();
		cardIdList = new ArrayList<>();
		Message cardmessage = new Message();
		String cardIMSTopic = snowIMSDaoImpl.getIMSCardTopic();
		// CardId2
		if (!cardID2Map.isEmpty()) {
			logger.info("Inside if restclient @342");
			for (Map.Entry<Object, Object> m1 : cardID2Map.entrySet()) {
				logger.info("Card: " + (String) m1.getKey() + " for Device: "+ imsDay0Device.get(i));
				cardJson = snowIMSService.getIMSCardTmfDetails((String) m1.getKey(),imsSchemas.get(k), imsDay0Field);

				cardmessage = objectMapper.readValue(cardJson, Message.class);

				if (cardJson != null && !cardJson.equals("{}")) {
					logger.info("cardIMSTopic @ 352: >>>>" + cardIMSTopic);
					snowIMSService.saveJsonMessageDetails(
							Integer.parseInt((String) m1.getKey()), "P", cardJson, "Processing","IMS_CARD_" + imsSchemas.get(k));

					logger.info("Before Kafka Producer at line 356");
					snowIMSDaoImpl.updateKafkasendStatus(Integer.parseInt((String) m1.getKey()));
					// Compress the deviceDay0Cardmessage using GZIP
					/*
					 * ByteArrayOutputStream bos = new ByteArrayOutputStream(); GZIPOutputStream
					 * gos = new GZIPOutputStream(bos); ObjectOutputStream oos = new
					 * ObjectOutputStream(gos); oos.writeObject(cardmessage); oos.close();
					 * gos.close(); byte[] compressedCardJson = bos.toByteArray();
					 */

					// kafkaIMSProducer.sendMessage(cardIMSTopic, cardmessage,
					// Integer.parseInt((String) m1.getKey()));
					Message cardMessage1 = compress(cardmessage);

					logger.info("compressedJson BYTE size : " + cardMessage1.toString());

					logger.info("compressedJson value : " + cardMessage1);

					kafkaIMSProducer.sendMessage(cardIMSTopic, cardMessage1,Integer.parseInt((String) m1.getKey()));

					logger.info("After Kafka Producer at line 359");

				} else {
					logger.info("Inside else myJSONObjectsCard 364: " + cardJson);
					snowIMSService.saveJsonMessageDetails(Integer.parseInt((String) m1.getKey()), "F","Card data is not populating correctly. Please check with GS rPACS Team!!", "Failed", "IMS_CARD");
				}
			}
		}
		// CardId
		if (!cardIDMap.isEmpty()) {
			for (Map.Entry<Object, Object> m2 : cardIDMap.entrySet()) {

				cardJson = snowIMSService.getIMSCardIDTmfDetails((String) m2.getKey(), imsSchemas.get(k), imsDay0Field);

				cardmessage = objectMapper.readValue(cardJson, Message.class);

				if (cardJson != null && !cardJson.equals("{}")) {

					snowIMSService.saveJsonMessageDetails(
							Integer.parseInt((String) m2.getKey()), "P", cardJson, "Processing","IMS_CARD_" + imsSchemas.get(k));

					logger.info("Before Kafka Producer at line 386");
					snowIMSDaoImpl.updateKafkasendStatus(Integer.parseInt((String) m2.getKey()));
					// kafkaIMSProducer.sendMessage(cardIMSTopic, cardmessage,
					// Integer.parseInt((String) m2.getKey()));
					// Compress the SubCardDay0message using GZIP
					/*
					 * ByteArrayOutputStream bos = new ByteArrayOutputStream(); GZIPOutputStream
					 * gos = new GZIPOutputStream(bos); ObjectOutputStream oos = new
					 * ObjectOutputStream(gos); oos.writeObject(cardmessage); oos.close();
					 * gos.close(); byte[] compressedCardJson = bos.toByteArray();
					 */

					Message cardMessage1 = compress(cardmessage);

					logger.info("compressedJson BYTE size : " + cardMessage1.toString());

					logger.info("compressedJson value : " + cardMessage1);
					
					kafkaIMSProducer.sendMessage(cardIMSTopic, cardMessage1,Integer.parseInt((String) m2.getKey()));
					logger.info("After Kafka Producer at line 389");

				} else {
					logger.info("Inside else myJSONObjectsCard 395: " + cardJson);
					snowIMSService.saveJsonMessageDetails(Integer.parseInt((String) m2.getKey()), "F","Card data is not populating correctly. Please check with GS rPACS Team!!","Failed", "IMS_CARD");
				}
			}
		}

	} catch (Exception e) {

		StringWriter sw = new StringWriter();
		// sw.append(" Exception occured @ 209:: ");
		e.printStackTrace(new PrintWriter(sw));
		logger.error("Exception occured in postTmfIMSDeviceDay0data() @ 409 >>>>" + sw.toString());

	}
	}

}
