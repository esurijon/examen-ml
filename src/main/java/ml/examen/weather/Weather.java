package ml.examen.weather;

public class Weather {

	private int day;
	private boolean isDroughtPeriod;
	private boolean isRainyPeriod;
	private boolean isMaximunRainyDay;
	private boolean isOptimalPresureAndTemperature;

	public Weather(int day, boolean isDroughtPeriod, boolean isRainyPeriod, boolean isMaximunRainyDay, boolean isOptimalPresureAndTemperature) {
		this.day = day;
		this.isDroughtPeriod = isDroughtPeriod;
		this.isRainyPeriod = isRainyPeriod;
		this.isMaximunRainyDay = isMaximunRainyDay;
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

	public boolean isMaximunRainyDay() {
		return isMaximunRainyDay;
	}

	public boolean isOptimalPresureAndTemperature() {
		return isOptimalPresureAndTemperature;
	}

}
