package com.kec.eb.entity;

public class Domestic extends Connection{
	public Domestic(int currentReading, int previousReading,float slabs[]) {
		super(currentReading,previousReading,slabs);
	}
	
	public float computeBill() {
		float bill;
		int currentReading = setCurrentReading();
		int previousReading = setPreviousReading();
		float slabs[] = setSlabRate();
		int reading = currentReading - previousReading;
		System.out.println("Current Reading: "+currentReading+"Previous Reading: "+previousReading+"Reading: "+reading);
		if(reading <= 50) {
			bill = (float)(reading * slabs[0]);
		}
		else if (reading > 50 && reading <= 100) {
			bill = (float) (reading * slabs[1]);
		}
		else {
			bill = (float) ((50*slabs[0])+(50*slabs[1])+((reading-100)* slabs[2]));
		}
		return bill;
	}
}