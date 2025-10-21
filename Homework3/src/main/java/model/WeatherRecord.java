package model;

import java.util.List;

public class WeatherRecord {
	private String datasetDescription;
	private List<WeatherLocation> location;
	
	public String getDatasetDescription() {
		return datasetDescription;
	}
	
	public void setDatasetDescription(String datasetDescription) {
		this.datasetDescription = datasetDescription;
	}
	
	public List<WeatherLocation> getLocation() {
		return location;
	}
	
	public void setLocation(List<WeatherLocation> location) {
		this.location = location;
	}
}
