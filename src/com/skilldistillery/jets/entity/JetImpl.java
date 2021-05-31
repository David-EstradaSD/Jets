package com.skilldistillery.jets.entity;

public class JetImpl extends Jet {

	public JetImpl() {
		
	}

	public JetImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	@Override
	public String toString() {
		return "Generic model: " + getModel() + ", speed(mph): " + getSpeed() + ", range(miles): " + getRange()
				+ ", price($): " + getPrice();
	}
	
	

}
