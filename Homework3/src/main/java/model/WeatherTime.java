package model;

public class WeatherTime {
	private String startTime;
	private String endTime;
	private WeatherParameter parameter;
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public WeatherParameter getParameter() {
		return parameter;
	}
	
	public void setParameter(WeatherParameter parameter) {
		this.parameter = parameter;
	}
}
