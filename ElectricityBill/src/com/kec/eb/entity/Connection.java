package com.kec.eb.entity;

public abstract class Connection {
	public int previousReading;
	public int currentReading;
	public float[] slabs;
	public Connection(int currentReading, int previousReading,float slabs[]) {
		this.currentReading = currentReading;
		this.previousReading = previousReading;
		this.slabs = slabs;
	}
	public abstract float computeBill();
	public void getPreviousReading(int previousReading) {
		this.previousReading = previousReading;
	}
	public int setPreviousReading() {
		return previousReading;
	}
	public void getCurrentReading(int currentReading) {
		this.currentReading = currentReading;
	}
	public int setCurrentReading() {
		return currentReading;
	}
	public void getSlabRate(float slabs[]) {
		this.slabs = slabs;
	}
	public float[] setSlabRate() {
		return slabs;
	}
}