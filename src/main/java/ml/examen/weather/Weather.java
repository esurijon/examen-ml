package ml.examen.weather;

public class Weather {

	private int day;
	private boolean isDrought;
	private boolean isRainy;
	private double rainAmount;
	private boolean isOptimalPresureAndTemperature;

	public Weather(int day, boolean isDrought, boolean isRainy, double rainAmount, boolean isOptimalPresureAndTemperature) {
		this.day = day;
		this.isDrought = isDrought;
		this.isRainy = isRainy;
		this.rainAmount = rainAmount;
		this.isOptimalPresureAndTemperature = isOptimalPresureAndTemperature;
	}

	public int getDay() {
		return day;
	}

	public boolean isDrought() {
		return isDrought;
	}

	public boolean isRainy() {
		return isRainy;
	}

	public double getRainAmount() {
		return rainAmount;
	}

	public boolean isOptimalPresureAndTemperature() {
		return isOptimalPresureAndTemperature;
	}

}
