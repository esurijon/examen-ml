package ml.examen.solarsystem;

import ml.examen.geometry.PolarCoord;

public class Planet {

	private String name;
	private int angularSpeed;
	private PolarCoord<Integer> initialPosition;

	public Planet(String name, int angularSpeed, PolarCoord<Integer> initialPosition) {
		this.name = name;
		this.angularSpeed = angularSpeed;
		this.initialPosition = initialPosition;
	}

	public PolarCoord<Integer> getPositionAt(int day) {
		int angle = initialPosition.getAngle() + (angularSpeed * day) % 360 ;
		return new PolarCoord<>(
			initialPosition.getMod(), 
			angle 
		);
	}

	public String getName() {
		return name;
	}
}
