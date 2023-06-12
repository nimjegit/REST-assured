package com.restassured.tests;

import org.testng.annotations.DataProvider;

public class DataForTests {
	
	
	
	@DataProvider(name="UsingDataProvider")
	public Object[][] dataForPost() {
//		Object[][] data = new Object[2][3]; //based on the excel sheet 2 rows and 3 columns
//		data[0][0]="Albert";
//		data[0][1]="Einstein";
//		data[0][2]= 2;
//		
//		data[1][0]="Thomas";
//		data[1][1]="Edison";
//		data[1][2]= 1;
		
		return new Object[][]{
		{"Graham","Bell",1},
		{"Henry","Ford",2}
		};
		
	}

	
	@DataProvider(name="UsingForDelete")
	public Object[] dataForDelete() {
		return new Object[] {
				5,6,7,8
		};
		
	}

}
