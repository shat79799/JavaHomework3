package model;

import java.util.List;

public class WeatherElement {
	private String elementName;
	private List<WeatherTime> time;
	
	public String getElementName() {
		return elementName;
	}
	
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	
	public List<WeatherTime> getTime() {
		return time;
	}
	
	public void setTime(List<WeatherTime> time) {
		this.time = time;
	}
}
