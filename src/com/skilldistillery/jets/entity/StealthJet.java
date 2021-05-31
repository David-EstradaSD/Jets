package com.skilldistillery.jets.entity;

public class StealthJet extends Jet implements CombatReady {

	@Override
	public void dogFight() {
		
	}

	@Override
	public void reconnaissanceMission() {
		
	}

	@Override
	public void combatTraining() {
		
	}

	@Override
	public void reloadAndRefuel() {
		
	}

	public StealthJet() {
	}
	
	// F22 RAPTOR
	// B2 SPIRIT

	public StealthJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	@Override
	public String toString() {
		return "StealthJet model: " + getModel() + ", speed(mph): " + getSpeed() + ", range(miles): " + getRange()
				+ ", price($): " + getPrice();
	}

}
