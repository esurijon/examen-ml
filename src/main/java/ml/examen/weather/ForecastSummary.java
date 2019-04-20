package ml.examen.weather;

import java.util.ArrayList;
import java.util.List;

public class ForecastSummary {

	private int droughtsQty = 0;
	private int rainsQty = 0;
	private int optimalsQty = 0;
	private List<Integer> maximunRainyDays = new ArrayList<>();

	public int getDroughtsQty() {
		return droughtsQty;
	}

	public void setDroughtsQty(int droughtsQty) {
		this.droughtsQty = droughtsQty;
	}

	public int getRainsQty() {
		return rainsQty;
	}

	public void setRainsQty(int rainsQty) {
		this.rainsQty = rainsQty;
	}

	public int getOptimalsQty() {
		return optimalsQty;
	}

	public void setOptimalsQty(int optimalsQty) {
		this.optimalsQty = optimalsQty;
	}

	public List<Integer> getMaximunRainyDays() {
		return maximunRainyDays;
	}

	public void setMaximunRainyDays(List<Integer> maximunRainyDays) {
		this.maximunRainyDays = maximunRainyDays;
	}

	@Override
	public String toString() {
		return String.format(
			"ForecastSummary [droughtsQty=%s, rainsQty=%s, optimalsQty=%s, maximunRainyDays=%s]",
			droughtsQty, 
			rainsQty, 
			optimalsQty, 
			maximunRainyDays
		);
	}
	
	

}
