package com.skilldistillery.jets.entity;

public class Airliner extends Jet implements AirlineReady {
	
	// 747
	// 757
	// this is created to instantiate a version the abstract class

	public Airliner() {
	}

	public Airliner(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	@Override
	public void announcement() {
		System.out.println(this.getModel() + " \"Ladies and gentlemen, the Captain has turned on the fasten seatbelt sign."
				+ " Please return to your seats and prepare for departure.\"");
	}
	
	@Override
	public void loadPassengers() {
		System.out.println(this.getModel() + " [pulling up to the tarmack] \"Let's get these people onboard and seated.\"");
		
	}

	@Override
	public String toString() {
		return "AirlinerJet model: " + getModel() + ", speed(mph): " + getSpeed() + ", range(miles): " + getRange()
				+ ", price($): " + getPrice();
	}

}
