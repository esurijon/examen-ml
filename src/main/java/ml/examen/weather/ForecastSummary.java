package ml.examen.weather;

import java.util.ArrayList;
import java.util.List;

public class ForecastSummary {

	private int droughtsQty = 0;
	private int optimalsQty = 0;
	private List<Integer> maximunRainyDays = new ArrayList<>();
	private int totalDays;

	public ForecastSummary(int totalDays) {
		this.totalDays = totalDays;
	}

	public void addDroughtPeriod() {
		droughtsQty++;
	}

	public void addOptimalsPeriod() {
		optimalsQty++;
	}

	public void addRainsPeriodWithMaximun(int day) {
		maximunRainyDays.add(day);
	}
	
	@Override
	public String toString() {
		return String.format(
			"ForecastSummary [\n\ttotalDays=%s, \n\tdroughtsQty=%s, \n\toptimalsQty=%s, \n\trainsQty=%s, \n\tmaximunRainyDays=%s\n]",
			totalDays, 
			droughtsQty, 
			optimalsQty, 
			maximunRainyDays.size(), 
			maximunRainyDays
		);
	}
	

}
