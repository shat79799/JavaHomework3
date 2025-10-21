package model;

public class WeatherData {
	private boolean success;
	private WeatherResult result;
	private WeatherRecord records;
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public WeatherResult getResult() {
		return result;
	}

	public void setResult(WeatherResult result) {
		this.result = result;
	}

	public WeatherRecord getRecords() {
		return records;
	}

	public void setRecords(WeatherRecord record) {
		this.records = record;
	}
}
