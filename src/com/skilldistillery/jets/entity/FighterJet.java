package com.skilldistillery.jets.entity;

public class FighterJet extends Jet implements CombatReady {
	
	// F14
	// F15
	// F16

	public FighterJet() {
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
		// System.out.println("[Vrroooooosh] Green light, blue skies.");
	
	@Override
	public void reloadAndRefuel() {
		System.out.println("These missiles are so heavy! But this gas is much appreciated");
		
	}

	@Override
	public void reconnaissanceMission() {
		System.out.println("Commencing reconnaissance flights. Over.");
		
	}

	@Override
	public void combatTraining() {
		System.out.println("Let's get to work, wheels up, masks on. Over");
		
	}

	@Override
	public void dogFight() {
		System.out.println(this.getModel() + " \"Break, break. Enemy aircraft inbound: Guns are hot! "
				+ "Commence evasive maneuvers!\"");
		
	}

	@Override
	public String toString() {
		return "FighterJet model: " + getModel() + ", speed(mph): " + getSpeed() + ", range(miles): " + getRange()
				+ ", price($): " + getPrice();
	}

}
