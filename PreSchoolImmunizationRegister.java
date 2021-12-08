package edu.neu.csye6200;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * This class is creates and reads a database for the immunization rules of 
 * children less than 24 months of age according to the ACIP recommended 
 * immunization schedule
 * @author jeff
 *
 */
public class PreSchoolImmunizationRegister implements FileOpsAPI{
	/*
	 * preschool immunization csv to be sorted according to drug, Dose Number 
	 * and Age in months to take dose
	 */

	private String[] earlyImmunizationCSVData = {
			"HepB,1,0",
			"HepB,2,1",
			"HepB,3,6",
			"Rotavirus,1,2",
			"Rotavirus,2,4",
			"DTap,1,2",
			"DTap,2,4",
			"DTap,3,6",
			"DTap,4,15",
			"HiB,1,2",
			"HiB,2,4",
			"HiB,3,6",
			"HiB,4,12",
			"PCV13,1,2,",
			"PCV13,2,4",
			"PCV13,3,6",
			"PCV13,4,12",
			"IPV,1,2",
			"IPV,2,4",
			"IPV,3,6",
			"IIV,1,6",
			"MMR,1,12",
			"MMR,2,13",
			"VAR,1,12",
			"HepA,1,12",
			"HepA,2,18"
			
	};
			
	public String fileName3 = "/home/jeff/Desktop/PreSchoolImmunizationRegister.csv" ;		
			
			
	@Override
	public void writeToCSV() {
		try {			
			FileWriter fw = new FileWriter(fileName3);
			BufferedWriter out= new BufferedWriter(fw);
			
			for (String name : earlyImmunizationCSVData) {
				out.write(name);
				out.newLine();	
			}
			System.out.println("\nObjects have been successfully written to PreSchoolImmunizationRegister.csv file!");
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
