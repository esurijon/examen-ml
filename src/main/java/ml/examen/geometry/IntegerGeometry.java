package ml.examen.geometry;

import java.util.Arrays;
import java.util.List;

public class IntegerGeometry {
	
	@SafeVarargs
	static public boolean areAllCoordsAlignedIncludingOrigin(PolarCoord<Integer>... coords) {
		for (int i = 0; i < coords.length - 1; i++) {
			int diff = coords[i].getAngle() - coords[i + 1].getAngle();
			if (diff != 0 && diff != 180 && diff != -180) {
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
	static public boolean areAllCoordsAlignedExcludingOrigin(PolarCoord<Integer> a, PolarCoord<Integer> b, PolarCoord<Integer> c) {
		List<PolarCoord<Integer>> sortedCoords = Arrays.asList(a,b,c);
		sortedCoords.sort( (s,w) -> s.getAngle() - w.getAngle() );
		a = sortedCoords.get(0);
		b = sortedCoords.get(1);
		c = sortedCoords.get(2);
		
		double ab = sizeOfTriangleSide_a(
			phaseDiff(b, a),
			b.getMod(), 
			a.getMod()
		);
		
		double ba = sizeOfTriangleSide_a(
			phaseDiff(c, b),
			c.getMod(), 
			b.getMod()
		);

		double ac = sizeOfTriangleSide_a(
			phaseDiff(c, a),
			c.getMod(), 
			a.getMod()
		);

		return ab + ba == ac;
	}

	@SafeVarargs
	static public boolean isOriginSurroundedByPolygon(PolarCoord<Integer>... coords) {
		int total = 0;
		for (int i = 0; i < coords.length - 1; i++) {
			total += phaseDiff(coords[i+1], coords[i]);
		}
		total += phaseDiff(coords[0], coords[coords.length - 1]);
		return total == 360;
	}

	static public double trianglePerimiter(PolarCoord<Integer> a, PolarCoord<Integer> b, PolarCoord<Integer> c) {
		double perimeter = 
			sizeOfTriangleSide_a(phaseDiff(b, a), b.getMod(), a.getMod()) +
			sizeOfTriangleSide_a(phaseDiff(c, b), c.getMod(), b.getMod()) +
			sizeOfTriangleSide_a(phaseDiff(a, c), a.getMod(), c.getMod());
		return perimeter;
	}

	static private double sizeOfTriangleSide_a(int A, int b, int c) {
		// https://www.universoformulas.com/matematicas/trigonometria/teorema-coseno/
		// a^2 = b^2 + c^2 - 2bc * cos(A)   
		return Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2) - 2*b*c * Math.cos(A));
	}

	static public int phaseDiff(PolarCoord<Integer> a, PolarCoord<Integer> b) {
		int diff = a.getAngle() - b.getAngle();
		if(diff <= -180) diff+=360;
		if(diff > 180) diff-=180;
		return diff;
	}

}
