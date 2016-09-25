package com.example.jubelcorrea.myfirstapp;

import android.support.v4.util.TimeUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by JubelCorrea on 24/09/16.
 */
public class JSON_Creator {

    JSONObject nodo1 = new JSONObject();
    JSONObject mensaje = new JSONObject();
    JSONArray nodos = new JSONArray();

    public JSON_Creator() {

        try {
            nodo1.put("article_id",1);
            nodo1.put("motion",true);
            nodo1.put("latitud",6.265297);
            nodo1.put("longitud",-75.567032);
            nodo1.put("radius",0);
            nodo1.put("message_time", new Date().getTime());

            nodos.put(nodo1);
            mensaje.put("messages",nodos);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getNode() {
        return mensaje.toString();

    }
}
