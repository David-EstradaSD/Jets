package com.skilldistillery.jets.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airfield {

	private List<Jet> jetsList;		// organize our airfield's jets in a List of the object Jet

	public Airfield() {
		super();
		this.jetsList = readJetsFromFile("jets.txt"); // (2a) populate the airfield from the text file
	}

	public void listFleet() {
		System.out.println("\tOur Fleet List: ");
		for (Jet jetType : jetsList) {
			System.out.println(jetType);
		}
	}

	public void flyAllJets() {
		System.out.println("\t[engine noises] \"WHOOO! WE'RE FLYING!\"");
		for (Jet jetType : jetsList) {
			jetType.fly();
		}
	}

	public void fastestJet() {
		Jet fastest = jetsList.get(0);
		for (int i = 0; i < jetsList.size(); i++) {
			if (jetsList != null) {
				if (fastest.getSpeed() < jetsList.get(i).getSpeed()) {
					fastest = jetsList.get(i);
				}
			} 
		}
		System.out.println("The fastest jet in the fleet is:\n" + fastest);
	}

	public void longestRange() {
		Jet longestRange = jetsList.get(0);
		for (int i = 0; i < jetsList.size(); i++) {
			if (jetsList != null) {
				if (longestRange.getRange() < jetsList.get(i).getRange()) {
					longestRange = jetsList.get(i);
				}
			}
		}
		System.out.println("The jet with the longest range in the fleet is:\n" + longestRange);
	}
	
	public void loadAirlinerJets() {
		for (Jet jetType : jetsList) {
			if(jetType instanceof Airliner) {
				((Airliner) jetType).loadPassengers();
				((Airliner) jetType).announcement();
			}
		}
		System.out.println("All Airliner Jets are loaded to capacity and all passengers are seated. Ready for takeoff.");
		
	}
	
	public void dogFight() {
		for (Jet jetType : jetsList) {
			if(jetType instanceof FighterJet) {
				((FighterJet) jetType).dogFight();
			}
		}
		System.out.println("\"I feel the NEED, the NEED for SPEED\" -- TopGun :)");
		
	}
	
	public void addJetToFleet(int choiceOfJet, String model, double speed, int range, long price) {
	
			Jet userJet = null;
			switch(choiceOfJet) {
			case 1: 
				userJet = new FighterJet(model, speed, range, price);
				break;
			case 2:
				userJet = new StealthJet(model, speed, range, price);
				break;
			case 3:
				userJet = new Airliner(model, speed, range, price);
				break;
			default:
				System.err.println("Invalid entry! Select option 1 - 3 for JET TYPE");
			}
			jetsList.add(userJet);
	}
		
	public void removeJetFromFleet(Scanner sc) {
		int userChoice = 0;
		System.out.println("Which jet do you want to remove from the fleet? ");
		for (int i = 0; i < jetsList.size(); i++) {
			System.out.println(i + 1 + ") " + jetsList.get(i).getModel());		// we just added one to our iterator to make our 
		}																		// list begin at index 1 instead of 0 (for menu selection purposes)
		userChoice = sc.nextInt();
		jetsList.remove(userChoice - 1); 		// had to subtract one to reconcile for our adding 1 above^
		
	}

	public List<Jet> readJetsFromFile(String fileName) {
		List<Jet> jetData = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				Jet type;
				String[] jetFields = line.split(","); 		// splitting the individual data types of the file's lines into
				if (jetFields[4].equals("Fighter")) {		// 		 individual fields (organized in their own indexes)
					type = new FighterJet(jetFields[0], Double.parseDouble(jetFields[1]), Integer.parseInt(jetFields[2]),
							Long.parseLong(jetFields[3]));
				} else if (jetFields[4].equals("Stealth")) {
					type = new StealthJet(jetFields[0], Double.parseDouble(jetFields[1]), Integer.parseInt(jetFields[2]),
							Long.parseLong(jetFields[3]));
				} else {
					type = new Airliner(jetFields[0], Double.parseDouble(jetFields[1]), Integer.parseInt(jetFields[2]),
							Long.parseLong(jetFields[3]));
				}
				jetData.add(type);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jetData;
	}

}
