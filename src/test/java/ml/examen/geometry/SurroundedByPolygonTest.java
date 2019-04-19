package ml.examen.geometry;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class SurroundedByPolygonTest {

	private IntegerGeometry geometry = new IntegerGeometry();
	
	private Random rand = new Random();
	
	@Test
	public void regularPolygonSurroundsOrigin_Test() {
		PolarCoord<Integer> initCoord = new PolarCoord<Integer>(
			rand.nextInt(), 
			0 //rand.nextInt(360)
		);
	
		int n = 10;
		PolarCoord<Integer>[] coords = new PolarCoord[n];
		coords[0] = initCoord;
		for (int i = 1; i < coords.length; i++) {
			coords[i] = new PolarCoord<Integer>(
				rand.nextInt(), 
				(coords[i-1].getAngle() + 360/n) % 360 
			);
		}
		
		boolean isSurrounded = geometry.isOriginSurroundedByPolygon(coords);

		Assert.assertTrue(isSurrounded);
	}

	@Test
	public void triangleNotSurroundsOrigin_Test() {
		PolarCoord<Integer> initCoord = new PolarCoord<Integer>(
			rand.nextInt(), 
			0 //rand.nextInt(360)
		);
	
		int n = 3;
		PolarCoord<Integer>[] coords = new PolarCoord[n];
		coords[0] = initCoord;
		for (int i = 1; i < coords.length; i++) {
			coords[i] = new PolarCoord<Integer>(
				rand.nextInt(), 
				coords[i-1].getAngle() + 20
			);
		}
		
		boolean isSurrounded = geometry.isOriginSurroundedByPolygon(coords);

		Assert.assertFalse(isSurrounded);
	}
}
