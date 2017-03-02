package com.mycompany.mavenproject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.lang.reflect.Type;

public class WebManager
{
	public static void main(String[] args) throws MalformedURLException, IOException
	{
		
		GsonBuilder gsonBuilder = new GsonBuilder();

		try {

                    URL w3schools_url = new URL("https://www.w3schools.com/angular/customers.php");
                    HttpURLConnection w3schools_url_conn = (HttpURLConnection) w3schools_url.openConnection();
                    w3schools_url_conn.setRequestMethod("GET");
                    w3schools_url_conn.setRequestProperty("Accept", "application/json");

		if (w3schools_url_conn.getResponseCode() != 200)
		{
                    throw new RuntimeException("Failed : HTTP error code :" + w3schools_url_conn.getResponseCode());
		}

		BufferedReader buffReader = new BufferedReader(new InputStreamReader((w3schools_url_conn.getInputStream())));
		gsonBuilder.registerTypeAdapter(Demographics.class, new DemoInstanceCreator());
		Gson gson = gsonBuilder.create();
                Demographics demo = gson.fromJson(buffReader, Demographics.class);
                
                System.out.println(demo);
                        
		w3schools_url_conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

class DemoInstanceCreator implements InstanceCreator<Demographics> {
   @Override
   public Demographics createInstance(Type type)
   {
      return new Demographics();
   }
}
