package ml.examen.geometry;

public interface Geometry<T extends Number> {
	
	@SuppressWarnings("unchecked")
	boolean areAllCoordsAlignedIncludingOrigin(PolarCoord<T>... coords);

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
	boolean areAllCoordsAlignedExcludingOrigin(PolarCoord<T> a, PolarCoord<T> b, PolarCoord<T> c);

	boolean isOriginSurroundedByPolygon(@SuppressWarnings("unchecked") PolarCoord<T>... coords);
	
	T trianglePerimiter(PolarCoord<T> a, PolarCoord<T> b, PolarCoord<T> c);

}
