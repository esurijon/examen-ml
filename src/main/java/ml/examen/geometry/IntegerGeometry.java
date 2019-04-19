package ml.examen.geometry;

public class IntegerGeometry {
	
	@SafeVarargs
	static public boolean areAllCoordsAlignedWithOrigin(PolarCoord<Integer>... coords) {
		for (int i = 0; i < coords.length - 1; i++) {
			int diff = coords[i].getAngle() - coords[i + 1].getAngle();
			if (diff != 0 && diff != 180 && diff != -180) {
				return false;
			}
		}
		return true;
	}

	@SafeVarargs
	static public boolean areAllCoordsAligned(PolarCoord<Integer>... coords) {
		// TODO Auto-generated method stub
		return false;
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

	static public boolean trianglePerimiterIsMaximun(PolarCoord<Integer> a, PolarCoord<Integer> b, PolarCoord<Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	static public double trianglePerimiter(PolarCoord<Integer> a, PolarCoord<Integer> b, PolarCoord<Integer> c) {
		return sizeOfSide(a, b, c) + sizeOfSide(c, b, a) + sizeOfSide(b, a, c);
	}

	static private double sizeOfSide(PolarCoord<Integer> a, PolarCoord<Integer> b, PolarCoord<Integer> c) {
		// https://www.universoformulas.com/matematicas/trigonometria/teorema-coseno/
		// a^2=b^2+c^2 - 2bc * cos(a)   
		return Math.sqrt(Math.pow(b.getMod(), 2) - Math.pow(c.getMod(), 2) - 2*b.getMod()*c.getMod() * Math.cos(a.getAngle()));
	}
	
	static public int phaseDiff(PolarCoord<Integer> a, PolarCoord<Integer> b) {
		int diff = a.getAngle() - b.getAngle();
		if(diff <= -180) diff+=360;
		if(diff > 180) diff-=180;
		return diff;
	}

}
