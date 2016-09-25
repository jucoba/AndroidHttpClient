package com.example.jubelcorrea.myfirstapp;


import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by JubelCorrea on 24/09/16.
 */
public class URLCaller extends AsyncTask {




    @Override
    protected Object doInBackground(Object[] params) {
        String url_string = "https://heyiamhere.herokuapp.com/messages";
        BufferedReader reader = null;

        String nodo = new JSON_Creator().getNode();

        try {


            URL url = new URL(url_string);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type","application/json");
            OutputStreamWriter doStream = new OutputStreamWriter(conn.getOutputStream());
            doStream.write(nodo);
            doStream.flush();
            doStream.close();
            int respCode = conn.getResponseCode();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            reader.close();







        }catch (Exception e)
        {
            e.printStackTrace();


        }finally {



        }
        return null;

    }
}
