package ml.examen.geometry;

import java.util.Arrays;
import java.util.List;

public class DoublePrecisonGeometry implements Geometry<Double> {
	
	private double tolerance;

	public DoublePrecisonGeometry(double tolerance) {
		this.tolerance = tolerance;
	}
	
	@SafeVarargs
	@Override
	final public boolean areAllCoordsAlignedIncludingOrigin(PolarCoord<Double>... coords) {
		for (int i = 0; i < coords.length - 1; i++) {
			double diff =  phaseDiff(coords[i], coords[i+1]);
			if (diff != 0 && diff != 180) {
				return false;
			}
		}
		return true;
	}

	/**
	 *        o
	 * 
	 * 
	 * 
	 *  --a-------------b-----------------c--

	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	@Override
	final public boolean areAllCoordsAlignedExcludingOrigin(PolarCoord<Double> a, PolarCoord<Double> b, PolarCoord<Double> c) {
		List<PolarCoord<Double>> sortedCoords = Arrays.asList(a,b,c);
		sortedCoords.sort( (x, y) -> (int)( x.getAngle() - y.getAngle()) );
		a = sortedCoords.get(0);
		b = sortedCoords.get(1);
		c = sortedCoords.get(2);
		
		double ab = sizeOfTriangleSide(
			phaseDiff(b, a),
			b.getMod(), 
			a.getMod()
		);
		
		double bc = sizeOfTriangleSide(
			phaseDiff(c, b),
			c.getMod(), 
			b.getMod()
		);

		double ac = sizeOfTriangleSide(
			phaseDiff(c, a),
			c.getMod(), 
			a.getMod()
		);

		double diff = ab + bc - ac;
		return -1*tolerance < diff && diff < tolerance;
	}

	@SafeVarargs
	@Override
	final public boolean isOriginSurroundedByPolygon(PolarCoord<Double>... coords) {
		int total = 0;
		for (int i = 0; i < coords.length - 1; i++) {
			total += phaseDiff(coords[i+1], coords[i]);
		}
		total += phaseDiff(coords[0], coords[coords.length - 1]);
		return total == 360;
	}

	final public Double trianglePerimiter(PolarCoord<Double> a, PolarCoord<Double> b, PolarCoord<Double> c) {
		double perimeter = 
			sizeOfTriangleSide(phaseDiff(b, a), b.getMod(), a.getMod()) +
			sizeOfTriangleSide(phaseDiff(c, b), c.getMod(), b.getMod()) +
			sizeOfTriangleSide(phaseDiff(a, c), a.getMod(), c.getMod());
		return perimeter;
	}

	static private double sizeOfTriangleSide(double angle, double sideA, double sideB) {
		// https://www.universoformulas.com/matematicas/trigonometria/teorema-coseno/
		// a^2 = b^2 + c^2 - 2bc * cos(A)   
		return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) - 2*sideA*sideB * Math.cos(angle*2*Math.PI/360));
	}

	static private double phaseDiff(PolarCoord<Double> a, PolarCoord<Double> b) {
		double diff = a.getAngle() - b.getAngle();
		if(diff <= -180) diff+=360;
		if(diff > 180) diff-=180;
		return diff;
	}
	
}
