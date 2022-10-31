package com.kec.eb.service;
import com.kec.eb.exception.*;
import com.kec.eb.entity.*;
public class ConnectionService {
	public float drate[] ={(float)2.3,(float)4.2,(float)5.5};
	public float crate[] = {(float)5.2,(float)6.8,(float)8.3};
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException{
		if (currentReading < previousReading) {
			throw new InvalidReadingException();
		}
		else if (!type.equals("Domestic") && !type.equals("Commercial")) {
			throw new InvalidConnectionException();
		}
		return true;
	}
	public float calculateBillAmt(int currentReading, int previousReading, String type) {
		float bill;
		try {
			validate(currentReading, previousReading, type);
		}
		catch(InvalidReadingException e) {
			return -1;
		}
		catch(InvalidConnectionException e) {
			return -2;
		}
		if(type.equals("Domestic")) {
			Domestic d = new Domestic(currentReading, previousReading,drate);
			bill = d.computeBill();
		}
		else {
			Commercial c = new Commercial(currentReading, previousReading, crate);
			bill = c.computeBill();
		}
		return bill;
	}
	
	public String generateBill(int currentReading, int previousReading, String type) {
		float a = calculateBillAmt(currentReading, previousReading, type);
		if(a==-1) {
			return "Incorrect Reading";
		}
		else if(a==-2) {
			return "Incorrect Connection";
		}
		else {
			return "Amount to be paid : "+a;
		}
	}
}