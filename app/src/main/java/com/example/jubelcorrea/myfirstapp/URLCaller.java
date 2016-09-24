package com.example.jubelcorrea.myfirstapp;


import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by JubelCorrea on 24/09/16.
 */
public class URLCaller extends AsyncTask {




    @Override
    protected Object doInBackground(Object[] params) {
        String url_string = "http://10.0.1.70:8888/";
        BufferedReader reader = null;
        try {
            URL url = new URL(url_string);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            DataOutputStream doStream = new DataOutputStream(conn.getOutputStream());
            doStream.writeBytes("hola=mundo");
            doStream.flush();
            doStream.close();
            int respCode = conn.getResponseCode();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));







        }catch (Exception e)
        {
            e.printStackTrace();


        }finally {

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();e.printStackTrace();
            }


        }
        return null;

    }
}
