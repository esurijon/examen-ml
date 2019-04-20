package ml.examen.weather;

public class Period {

	private boolean wasActive;
	private boolean isActive;
	
	public Period() {
		this(false);
	}

	public Period(boolean isActive) {
		this.isActive = isActive;
		this.wasActive = isActive;
	}

	public void setActive(boolean isActive) {
		wasActive = this.isActive;
		this.isActive = isActive;
	}

	public boolean isActive() {
		return isActive;
	}

	public boolean justStarted() {
		return !wasActive && isActive;
	}

	public boolean justEnded() {
		return !isActive && wasActive;
	}
}
