package ml.examen.geometry;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class AllignedWithOriginTest {

	private IntegerGeometry geometry = new IntegerGeometry();
	
	private Random rand = new Random();
	
	@Test
	public void oneCoord_IsAlwayAllingnedWithOrigin_Test() {
		PolarCoord<Integer> anyCoord = new PolarCoord<Integer>(rand.nextInt(), rand.nextInt(360));
		boolean isAligned = geometry.areAllCoordsAlignedWithOrigin(anyCoord);
		Assert.assertTrue("Una sola coordenada siempre esta alineada con el origen", isAligned);
	}

	@Test
	public void allCoordsAlignedWithOrigin_Test() {
		PolarCoord<Integer> anyCoord = new PolarCoord<Integer>(
			rand.nextInt(), 
			rand.nextInt(360)
		);
	
		PolarCoord<Integer> otherCoord = new PolarCoord<Integer>(
			rand.nextInt(),
			anyCoord.getAngle()
		);
		
		PolarCoord<Integer> anotherCoord = new PolarCoord<Integer>(
			rand.nextInt(),
			(anyCoord.getAngle() + 180) % 360
		);

		boolean areAllAligned = geometry.areAllCoordsAlignedWithOrigin(anyCoord, otherCoord, anotherCoord);

		Assert.assertTrue("Lass coordenadas estan alineadas", areAllAligned);
	}

	@Test
	public void allCoordsNotAlignedWithOrigin_Test() {
		PolarCoord<Integer> anyCoord = new PolarCoord<Integer>(
			rand.nextInt(), 
			rand.nextInt(360)
		);
	
		PolarCoord<Integer> otherCoord = new PolarCoord<Integer>(
			rand.nextInt(),
			anyCoord.getAngle()
		);
		
		PolarCoord<Integer> anotherCoord = new PolarCoord<Integer>(
			rand.nextInt(),
			(anyCoord.getAngle() + 10) % 360 
		);

		boolean areAllAligned = geometry.areAllCoordsAlignedWithOrigin(anyCoord, otherCoord, anotherCoord);

		Assert.assertFalse("Lass coordenadas NO estan alineadas", areAllAligned);
	}

}
