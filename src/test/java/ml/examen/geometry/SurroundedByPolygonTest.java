package ml.examen.geometry;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class SurroundedByPolygonTest {

	private Geometry<Double> geometry = new DoublePrecisonGeometry(0);
	private Random rand = new Random();
	
	@Test
	public void regularPolygonSurroundsOrigin_Test() {
		PolarCoord<Double> initCoord = new PolarCoord<>(
			(double) rand.nextInt(), 
			(double) rand.nextInt(360)
		);
	
		int n = 10;
		@SuppressWarnings("unchecked")
		PolarCoord<Double>[] coords = new PolarCoord[n];
		coords[0] = initCoord;
		for (int i = 1; i < coords.length; i++) {
			coords[i] = new PolarCoord<>(
				(double) rand.nextInt(), 
				(coords[i-1].getAngle() + 360/n) % 360 
			);
		}
		
		boolean isSurrounded = geometry.isOriginSurroundedByPolygon(coords);

		Assert.assertTrue(isSurrounded);
	}

	@Test
	public void triangleNotSurroundsOrigin_Test() {
		PolarCoord<Double> initCoord = new PolarCoord<>(
			(double) rand.nextInt(), 
			(double) rand.nextInt(360)
		);
	
		int n = 3;
		@SuppressWarnings("unchecked")
		PolarCoord<Double>[] coords = new PolarCoord[n];
		coords[0] = initCoord;
		for (int i = 1; i < coords.length; i++) {
			coords[i] = new PolarCoord<>(
				(double) rand.nextInt(), 
				coords[i-1].getAngle() + 20
			);
		}
		
		boolean isSurrounded = geometry.isOriginSurroundedByPolygon(coords);

		Assert.assertFalse(isSurrounded);
	}
}
