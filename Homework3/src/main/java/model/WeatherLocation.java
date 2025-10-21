package model;

import java.util.List;

public class WeatherLocation {
	private String locationName;
	private List<WeatherElement> weatherElement;
	
	public String getLocationName() {
		return locationName;
	}
	
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public List<WeatherElement> getWeatherElement() {
		return weatherElement;
	}
	
	public void setWeatherElement(List<WeatherElement> weatherElement) {
		this.weatherElement = weatherElement;
	}
}
