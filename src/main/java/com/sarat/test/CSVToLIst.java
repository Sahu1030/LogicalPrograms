package com.Practice.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVToLIst {
	static String file = "E:\\Java Program\\sample1.csv";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		try {
//			BufferedReader bffuerReader = new BufferedReader(new FileReader(file));
//			String line;
//			while ((line = bffuerReader.readLine()) != null) {
//				String[] values = line.split(",");
//				System.out.println(Arrays.toString(values));
//				CsvUser dailyValues = new CsvUser();
//
//				dailyValues.setFname(values[0]);
//				dailyValues.setLname(values[1]);
//				dailyValues.setAge(values[2]);
//				value.add(dailyValues);
//
//			}
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		List<CsvUser> xmlLines = new BufferedReader(new FileReader(file))
			    .lines()
			    .skip(1) //Skips the first n lines, in this case 1      
			    .map(s -> CsvUser.FromCsv(s)).collect(Collectors.toList());
			        //csv line parsing and xml logic here
			        //...
		System.out.println(xmlLines);

	}
	
}

class CsvUser {
	
	 String fname;
    String lname;
    String age;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "CsvUser [fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}
    
	 public static  CsvUser FromCsv(String csvLine)
    {
        String[] values = csvLine.split(",");
        CsvUser dailyValues = new CsvUser();

        dailyValues.setFname(values[0]);
        dailyValues.setLname(values[1]);
        dailyValues.setAge( values[2]);

        return dailyValues;
    }
	

}