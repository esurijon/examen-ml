package ml.examen.geometry;

public interface Geometry<T extends Number> {

	boolean areAllCoordsAlignedWithOrigin(PolarCoord<T>... coords);

	boolean areAllCoordsAligned(PolarCoord<T>... coords);

	boolean isOriginSurroundedByPolygon(PolarCoord<T>... coords);

	boolean trianglePerimiterIsMaximun(PolarCoord<T> a, PolarCoord<T> b, PolarCoord<T> c);

}