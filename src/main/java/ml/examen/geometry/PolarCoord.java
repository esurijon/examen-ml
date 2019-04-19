package ml.examen.geometry;

public class PolarCoord<T extends Number> {
	private T mod;
	private T angle;

	public PolarCoord(T mod, T angle) {
		this.mod = mod;
		this.angle = angle;
	}
	public T getMod() {
		return mod;
	}
	public T getAngle() {
		return angle;
	}
	
}
