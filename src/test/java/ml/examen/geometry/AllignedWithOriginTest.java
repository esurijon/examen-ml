package ml.examen.geometry;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class AllignedWithOriginTest {

	private Geometry<Double> geometry = new DoublePrecisonGeometry(0);
	private Random rand = new Random();
	
	@Test
	public void oneCoord_IsAlwayAllingnedWithOrigin_Test() {
		PolarCoord<Double> anyCoord = new PolarCoord<>((double)rand.nextInt(), (double)rand.nextInt(360));
		@SuppressWarnings("unchecked")
		boolean isAligned = geometry.areAllCoordsAlignedIncludingOrigin(anyCoord);
		Assert.assertTrue("Una sola coordenada siempre esta alineada con el origen", isAligned);
	}

	@Test
	public void allCoordsAlignedWithOrigin_Test() {
		PolarCoord<Double> anyCoord = new PolarCoord<>(
			(double) rand.nextInt(), 
			(double) rand.nextInt(360)
		);
	
		PolarCoord<Double> otherCoord = new PolarCoord<>(
			(double) rand.nextInt(),
			(double) anyCoord.getAngle()
		);
		
		PolarCoord<Double> anotherCoord = new PolarCoord<>(
			(double) rand.nextInt(),
			(double) (anyCoord.getAngle() + 180) % 360
		);

		@SuppressWarnings("unchecked")
		boolean areAllAligned = geometry.areAllCoordsAlignedIncludingOrigin(anyCoord, otherCoord, anotherCoord);

		Assert.assertTrue("Lass coordenadas estan alineadas", areAllAligned);
	}

	@Test
	public void allCoordsNotAlignedWithOrigin_Test() {
		PolarCoord<Double> anyCoord = new PolarCoord<>(
			(double) rand.nextInt(), 
			(double) rand.nextInt(360)
		);
	
		PolarCoord<Double> otherCoord = new PolarCoord<>(
			(double) rand.nextInt(),
			(double) anyCoord.getAngle()
		);
		
		PolarCoord<Double> anotherCoord = new PolarCoord<>(
			(double) rand.nextInt(),
			(double) (anyCoord.getAngle() + 10) % 360 
		);

		@SuppressWarnings("unchecked")
		boolean areAllAligned = geometry.areAllCoordsAlignedIncludingOrigin(anyCoord, otherCoord, anotherCoord);

		Assert.assertFalse("Lass coordenadas NO estan alineadas", areAllAligned);
	}

}
