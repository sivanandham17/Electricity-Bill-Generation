package com.kec.eb.entity;

public class Commercial extends Connection{
	public Commercial(int currentReading, int previousReading,float slabs[]) {
		super(currentReading,previousReading,slabs);
	}
	
	public float computeBill() {
		float bill, amount, service;
		int currentReading = setCurrentReading();
		int previousReading = setPreviousReading();
		int reading = currentReading - previousReading;
		float slabs[] = setSlabRate();
		if(reading <= 50) {
			bill = (float)(reading * slabs[0]);
		}
		else if (reading > 50 && reading <= 100) {
			bill = (float) (reading * slabs[1]);
		}
		else {
			bill = (float) ((50*slabs[0])+(50*slabs[1])+((reading-100)* slabs[2]));
		}
		if(bill < 5000) {
			service =(float) (bill * 0.02);
			amount = (float) (bill+service);
		}
		else if(bill>=5000 && bill<10000) {
			service =(float) (bill * 0.06);
			amount = (float) (bill+service);
		}
		else {
			service =(float) (bill * 0.09);
			amount = (float) (bill+service);
		}
		return amount;
	}
}
