package com.desafiouno.service;

import com.desafiouno.domain.RptServicio;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class DesafioService {

    private final Logger log = LoggerFactory.getLogger(DesafioService.class);


    public JsonObject getDatos() throws IOException {

        String uri ="http://localhost:8080/periodos/api";

        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        connection.setConnectTimeout(10000);
        connection.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String responseString = response.toString();
        JsonParser jsonParser = new JsonParser();
        JsonObject object = (JsonObject)jsonParser.parse(responseString);

        return  object;
    }
}
