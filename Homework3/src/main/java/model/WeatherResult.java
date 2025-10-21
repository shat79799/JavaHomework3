package model;

import java.util.List;

public class WeatherResult {
	private String resource_id;
	private List<WeatherField> fields;
	
	public String getResource_id() {
		return resource_id;
	}
	
	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}
	
	public List<WeatherField> getFields() {
		return fields;
	}
	
	public void setFields(List<WeatherField> fields) {
		this.fields = fields;
	}
}
