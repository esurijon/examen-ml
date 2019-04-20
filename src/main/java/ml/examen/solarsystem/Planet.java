package ml.examen.solarsystem;

import ml.examen.geometry.PolarCoord;

public class Planet {

	private String name;
	private double angularSpeed;
	private PolarCoord<Double> initialPosition;

	public Planet(String name, double angularSpeed, PolarCoord<Double> initialPosition) {
		this.name = name;
		this.angularSpeed = angularSpeed;
		this.initialPosition = initialPosition;
	}

	public PolarCoord<Double> getPositionAt(int day) {
		double angle = initialPosition.getAngle() + (angularSpeed * day) % 360 ;
		return new PolarCoord<>(
			initialPosition.getMod(), 
			angle 
		);
	}

	public String getName() {
		return name;
	}
}
