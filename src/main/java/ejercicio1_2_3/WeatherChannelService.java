package ejercicio1_2_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherChannelService  implements ClimaOnline{
	private String key; //e19c126b96f269f9f3df66434b872e15
	private String url; //https://api.openweathermap.org/data/2.5/weather

	public WeatherChannelService(String key, String url){
		this.key = key;
		this.url = url;
	}
	@Override
	public String temperatura() {
		try {
			String lat = "-40.8135";
			String lon = "-62.9967";
			String units = "metric"; // Para obtener la temperatura en Celsius
			String urlString = String.format("%s?lat=%s&lon=%s&units=%s&appid=%s", url, lat, lon, units, key);

			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			int responseCode = conn.getResponseCode();
			if (responseCode == 200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuilder content = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();
				conn.disconnect();

				JSONObject jsonResponse = new JSONObject(content.toString());
				double temp = jsonResponse.getJSONObject("main").getDouble("temp");
				return String.format("%.2f °C", temp);
			} else {
				return "Error: No se pudo obtener la temperatura";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error: No se pudo obtener la temperatura";
		}
	}
}

