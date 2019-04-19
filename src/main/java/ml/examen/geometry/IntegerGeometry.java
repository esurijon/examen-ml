package ml.examen.geometry;

public class IntegerGeometry implements Geometry<Integer> {
	
	@Override
	public boolean areAllCoordsAlignedWithOrigin(PolarCoord<Integer>... coords) {
		for (int i = 0; i < coords.length - 1; i++) {
			int diff = coords[i].getAngle() - coords[i + 1].getAngle();
			if (diff != 0 && diff != 180) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean areAllCoordsAligned(PolarCoord<Integer>... coords) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOriginSurroundedByPolygon(PolarCoord<Integer>... coords) {
		int total = 0;
		for (int i = 0; i < coords.length - 1; i++) {
			total += coords[i + 1].getAngle() - coords[i].getAngle();
		}
		total += coords[0].getAngle() - coords[coords.length - 1].getAngle();
		return total == 360;
	}

	@Override
	public boolean trianglePerimiterIsMaximun(PolarCoord<Integer> a, PolarCoord<Integer> b, PolarCoord<Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}


}
