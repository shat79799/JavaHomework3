package util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.WeatherData;
import model.WeatherElement;
import model.WeatherLocation;
import model.WeatherParameter;
import model.WeatherTime;

public class HttpConnection {

	private static int timeout = 10;
	private static String domain = "https://opendata.cwa.gov.tw/api";
	private static String path = "/v1/rest/datastore/F-C0032-001";
	private static String authorization = "CWA-F789313B-CFBB-4B07-A88F-C8EF35EE1711";
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompletableFuture<WeatherData> get = HttpConnection.httpGet();
		try {
			WeatherData data = get.get();
			if (data.isSuccess()) {
				WeatherLocation location = data.getRecords().getLocation().getFirst();
				WeatherElement element_pop = location.getWeatherElement().stream().filter(element -> element.getElementName().equalsIgnoreCase("PoP")).toList().getFirst();
				WeatherTime time_pop = element_pop.getTime().getFirst();
				WeatherParameter parameter_pop = time_pop.getParameter();
				String result_pop = location.getLocationName() + " 在 " + time_pop.getStartTime() + " ~ " + time_pop.getEndTime() + " 的下雨機率為: " + parameter_pop.getParameterName() + "%";
				System.out.println(result_pop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static CompletableFuture<WeatherData> httpGet() {
		String url = domain + path + "?Authorization=" + authorization + "&format=JSON" + "&locationName=%E8%87%BA%E5%8C%97%E5%B8%82";
		
		HttpClient client = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(timeout))
				.build();
		HttpRequest getRequest = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("Accept", "application/json")
				.GET()
				.build();
		
		return client.sendAsync(getRequest, BodyHandlers.ofString())
				.thenComposeAsync(response -> {
					int statusCode = response.statusCode();
					
					if (statusCode == 200) {
						String body = response.body();
						
						try {
							WeatherData data = mapper.readValue(body, WeatherData.class);
							return CompletableFuture.completedFuture(data);
						} catch (Exception e) {
							CompletableFuture<WeatherData> failed = new CompletableFuture<>();
							failed.completeExceptionally(new RuntimeException("json parsing failed: " + e.getMessage()));
							return failed;
						}
					} else {
						CompletableFuture<WeatherData> failed = new CompletableFuture<>();
						failed.completeExceptionally(new RuntimeException("http status: " + statusCode));
						return failed;
					}
				});
	}
}
	