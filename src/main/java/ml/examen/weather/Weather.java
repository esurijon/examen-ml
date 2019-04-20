package ml.examen.weather;

public class Weather {

	private int day;
	private boolean isDroughtPeriod;
	private boolean isRainyPeriod;
	private double rainAmount;
	private boolean isOptimalPresureAndTemperature;

	public Weather(int day, boolean isDroughtPeriod, boolean isRainyPeriod, double rainAmount, boolean isOptimalPresureAndTemperature) {
		this.day = day;
		this.isDroughtPeriod = isDroughtPeriod;
		this.isRainyPeriod = isRainyPeriod;
		this.rainAmount = rainAmount;
		this.isOptimalPresureAndTemperature = isOptimalPresureAndTemperature;
	}

	public int getDay() {
		return day;
	}

	public boolean isDroughtPeriod() {
		return isDroughtPeriod;
	}

	public boolean isRainyPeriod() {
		return isRainyPeriod;
	}

	public double getRainAmount() {
		return rainAmount;
	}

	public boolean isOptimalPresureAndTemperature() {
		return isOptimalPresureAndTemperature;
	}

}
