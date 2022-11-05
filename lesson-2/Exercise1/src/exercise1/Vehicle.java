package exercise1;

import java.awt.Color;

public class Vehicle {

	private String type;
	private String make;
	private String model;
	private Color color;

	public Vehicle(String type, String make, String model, Color color) {
		this.type = type;
		this.make = make;
		this.model = model;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", make=" + make + ", model=" + model + ", color=" + color + "]";
	}
}
