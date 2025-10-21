package controller;

import java.util.concurrent.CompletableFuture;

import model.MyMember;
import model.WeatherData;
import model.WeatherElement;
import model.WeatherLocation;
import model.WeatherParameter;
import model.WeatherTime;
import util.HttpConnection;
import util.Tool;

public class MenuController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public MyMember getCurrentMember() {
		 return Tool.readMyMember();
	}
	
	public String getCurrentWeather() {
		String weather = null;
		CompletableFuture<WeatherData> get = HttpConnection.httpGet();
		try {
			WeatherData data = get.get();
			if (data.isSuccess()) {
				WeatherLocation location = data.getRecords().getLocation().getFirst();
				WeatherElement element_pop = location.getWeatherElement().stream().filter(element -> element.getElementName().equalsIgnoreCase("PoP")).toList().getFirst();
				WeatherTime time_pop = element_pop.getTime().getFirst();
				WeatherParameter parameter_pop = time_pop.getParameter();
				String result_pop = location.getLocationName() + " 在 " + time_pop.getStartTime() + " ~ " + time_pop.getEndTime() + " 的下雨機率為: " + parameter_pop.getParameterName() + "%";
				
				weather = result_pop;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return weather;
	}

}
