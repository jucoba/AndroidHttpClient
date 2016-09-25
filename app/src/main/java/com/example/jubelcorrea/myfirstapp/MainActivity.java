package com.example.jubelcorrea.myfirstapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {

        /*Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);*/

        AsyncTask resp = new URLViewCaller().execute();
        System.out.print(resp);



    }

    public class URLViewCaller extends AsyncTask<String, Void, String> {




        @Override
        protected String doInBackground(String... params) {

            String url = "http://192.168.1.109:8080/test";
            return new URLCaller2().postURL(url);

        }



        @Override
        protected void onPostExecute(String result) {
            EditText editText = (EditText) findViewById(R.id.editText);
            editText.setText(result);
        }
    }
}
