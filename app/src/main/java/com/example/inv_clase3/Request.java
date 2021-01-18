package com.example.inv_clase3;

import android.os.Handler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Request extends Thread{

    private String url;
    private Handler handler;

    public Request(String url, Handler handler){
        this.url = url;
        this.handler=handler;
    }

    // sobreescribir un método importante
    // el que corre con el thread

    public void run(){
        try {
            URL direccion = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) direccion.openConnection();
            int code = connection.getResponseCode();

            if(code == HttpURLConnection.HTTP_OK){

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
