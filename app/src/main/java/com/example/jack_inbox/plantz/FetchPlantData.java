package com.example.jack_inbox.plantz;

   //https://api.myjson.com/bins/jmad7?pretty=1

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

/**
 * Created by gregevans on 10/30/17.
 */

public class FetchPlantData extends AsyncTask<Void, Void, Void> {
    String data = "";
    String dataParsed = "";
    String singleParsed = "";

    //luxadded
    public static int fweather;
    public static int f2weather;
    public static int ddate1;
    public static int ddate2;
    public static int lux1;
    public static int lux2;

    public static String name = "";
    String temp1 = "";
    String temp2 = "";
    String sun = "";


    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/164xbb");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for(int i =0 ;i <JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);

                if(JO.get("name").equals(PlantTestActivity.plant)) {

                    singleParsed = "Name:" + JO.get("name") + "\n" +
                            "Temp1:" + JO.get("temperature1") + "\n" +
                            "Temp2:" + JO.get("temperature2") + "\n" +
                            "Lux1:" + JO.get("lux1") + "\n" +
                            "Lux2:" + JO.get("lux2") + "\n" +
                            "Date1:" + JO.get("date1") + "\n" +
                            "Date2:" + JO.get("date2") + "\n";


                    fweather = Utils.getInt("temperature1",JO);
                    f2weather = Utils.getInt("temperature2",JO);
                    ddate1 = Utils.getInt("date1", JO);
                    ddate2 = Utils.getInt("date2",JO);
                    lux1 = Utils.getInt("lux1",JO);
                    lux2 = Utils.getInt("lux2",JO);

                    dataParsed = dataParsed + singleParsed + "\n";


                }

               // System.out.println(dataParsed);

            }

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
        //APILookupActivity.data.setText(this.dataParsed);
        PlantTestActivity.data.setText(this.dataParsed);
        //PlantTestActivity.name = this.name;

    }
}
