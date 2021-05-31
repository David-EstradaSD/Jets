package com.skilldistillery.jets.app;

import java.util.Scanner;
import com.skilldistillery.jets.entity.Airfield;

public class JetsApplication {
	private Airfield airfield; // (1a) use this to call the constructor
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		JetsApplication jets = new JetsApplication();
		jets.launch(sc);
	}

	public void launch(Scanner sc) {
		airfield = new Airfield(); // (1b) ( (2b) populate the airfield)
		System.out.println("Welcome to our Virtual Airfield Application!\n");
		userOption(sc);
	}

	public void userOption(Scanner sc) { // While loop with nested switch for the userInput

		boolean keepGoing = true;

		while (keepGoing) {
			printMenu();
			int option = sc.nextInt();

			switch (option) {
			case 1:
				airfield.listFleet();
				break;
			case 2:
				airfield.flyAllJets();
				break;
			case 3:
				airfield.fastestJet();
				break;
			case 4:
				airfield.longestRange();
				break;
			case 5:
				airfield.loadAirlinerJets();
				break;
			case 6:
				airfield.dogFight();
				break;
			case 7: //
				System.out.println("Which type of jet would you like to create?");
				System.out.println("1) FighterJet");
				System.out.println("2) StealthJet");
				System.out.println("3) Airliner");
				int choiceOfJet = sc.nextInt();
				System.out.print("Please enter the jet's model: ");
				String model = sc.next();
				System.out.print("Please enter the jet's speed(mph): ");
				double speed = sc.nextDouble();
				sc.nextLine();
				System.out.print("Please enter the jet's range(miles): ");
				int range = sc.nextInt();
				System.out.print("Please enter the jet's price(US$): ");
				long price = sc.nextLong();
				airfield.addJetToFleet(choiceOfJet, model, speed, range, price);
				break;
			case 8:
				airfield.removeJetFromFleet(sc);
				break;
			case 9:
				keepGoing = false;
				System.out.println("Thanks for visiting our Virtual Airfield! Goodbye.");
				break;
			default:
				System.err.println("Invalid entry! Select option 1 - 9");
			}
		}
	}

	public void printMenu() {
		System.out.println("---------------Menu---------------");
		System.out.println("1) List all jets in the fleet");
		System.out.println("2) Fly all jets");
		System.out.println("3) Display the fastest jet");
		System.out.println("4) Display jet with longest range");
		System.out.println("5) Load all AirlinerJets");
		System.out.println("6) Dogfight!");
		System.out.println("7) Add a jet to the fleet");
		System.out.println("8) Remove a jet from the fleet");
		System.out.println("9) Quit the application");
		System.out.println("----------------------------------\n");
		System.out.print("Please select a Menu option: ");
	}

}
