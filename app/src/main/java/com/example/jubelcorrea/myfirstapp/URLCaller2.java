package com.example.jubelcorrea.myfirstapp;


import android.os.AsyncTask;
import android.widget.EditText;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by JubelCorrea on 24/09/16.
 */
public class URLCaller2  {





    public String postURL(String url_string) {

        BufferedReader reader = null;

        String nodo = new JSON_Creator().getNode();
        String resutl_messaga = "not executed";

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
            resutl_messaga = String.valueOf(respCode);







        }catch (Exception e)
        {
            e.printStackTrace();
            resutl_messaga = e.toString();


        }finally {



        }
        return resutl_messaga;

    }

}
