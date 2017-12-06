package com.example.jack_inbox.plantz;

/**
 * Created by Manuel on 12/3/2017.
 */
import android.os.AsyncTask;

import com.example.jack_inbox.plantz.Util.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Manuel on 11/7/2017.
 */

public class weatherData extends AsyncTask<Void,Void,Void>{
    String data = "";
    String dataParsed = "";

    String TheWeather = "";

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat="+MapsActivity.latitude+"&long="+MapsActivity.longitude+"&appid=a5ffc5200836e47d043620b2babae736&units=imperial");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject jsonObject = new JSONObject(data);

            JSONObject sysObj = Utils.getObject("sys", jsonObject);
            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            JSONObject jsonWeather = jsonArray.getJSONObject(0);
            JSONObject windObj = Utils.getObject("wind", jsonObject);
            JSONObject mainObj = Utils.getObject("main",jsonObject);

            DateFormat df = DateFormat.getTimeInstance();

            String sunrisedate = df.format(new Date(Utils.getInt("sunrise",sysObj)));
            String sunsetdate = df.format(new Date(Utils.getInt("sunset",sysObj)));
            String lastupdate = df.format(new Date(Utils.getInt("dt",jsonObject)));

            TheWeather =
                    "City: " + Utils.getString("name",jsonObject) + "\n" +
                            //"ZIP = "+WeatherActivity.city + "\n" +
                            "Country: " + Utils.getString("country",sysObj) + "\n" + "\n" +
                            "Temp: " + Utils.getInt("temp",mainObj) + "℉" +"\n" +
                            "Description: " + Utils.getString("description",jsonWeather) + "\n" + "\n" +
                            "Pressure: " + Utils.getInt("pressure",mainObj) + "\n" +
                            "Humidity: " + Utils.getInt("humidity",mainObj) + "\n" +
                            "Wind Speed: " + Utils.getInt("speed",windObj) + "\n" +
                            "Wind Deg: " + Utils.getInt("deg",windObj) + "\n" +
                            "Sunrise: " + sunrisedate + "\n" +
                            "Sunset: " + sunsetdate + "\n" + "\n" +
                            "Last Update: " + lastupdate;







            dataParsed = dataParsed + TheWeather;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        WeatherActivity.data.setText(this.dataParsed);
    }
}