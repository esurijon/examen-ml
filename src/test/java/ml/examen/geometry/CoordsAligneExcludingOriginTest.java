package ml.examen.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordsAligneExcludingOriginTest {

	private Geometry<Double> geometry = new DoublePrecisonGeometry(0.0001);
	
	@Test
	public void ninetyAngleSpan_Test() {
		PolarCoord<Double> a = new PolarCoord<>(1d, 0d);
		PolarCoord<Double> b = new PolarCoord<>(Math.sqrt(2)/2, 45d);
		PolarCoord<Double> c = new PolarCoord<>(1d, 90d);
		
		boolean areAllined = geometry.areAllCoordsAlignedExcludingOrigin(a, b, c);
		Assert.assertTrue(areAllined);
	}

}
