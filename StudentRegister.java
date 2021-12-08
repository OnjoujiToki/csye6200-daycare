package edu.neu.csye6200;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentRegister implements FileOpsAPI{
	private String[] studentCSVData = {
			"Jimmy,7",
			"Sally,23",
			"Lizzy,62",
			"Markie,32",
			"Johnny,12",
			"Bobby,48",
			"Billy,26",
			"Evie,40",
			"Becky,29",
			"Jessie,14",
			"Jackie,12",
			"Laurie,27",
			"Cathey,12",
			"Millie,63",
			"Ruthie,34",
			"Stanley,53",
			"Mary,41",
			"Annie,30"
	};

	public String fileName2 = "/home/jeff/Desktop/DayCareStudents.csv" ;
	

	@Override
	public void writeToCSV() {
		try {			
			FileWriter fw = new FileWriter(fileName2);
			BufferedWriter out= new BufferedWriter(fw);
			
			for (String name : studentCSVData) {
				out.write(name);
				out.newLine();	
			}
			System.out.println("\nObjects have been successfully written to DayCareStudents.csv file!");
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println("Objects have NOT been successfully written to file!");
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void readFromCSV() {
		// TODO Auto-generated method stub
		
	}

}
