package com.safyd.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author HP
 */
public class Solicitudes {

    public JSONObject sendPostResponse(String sUrl) {
        JSONObject response = null;
        InputStream in = null;
        try {
            URL url = new URL(sUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Content-Type", "application/json; charset=ISO-8859-1");
            urlConnection.setConnectTimeout(500);
            urlConnection.setReadTimeout(0);
            in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "ISO-8859-1"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                //reponsBuilder checa los errores
                responseStrBuilder.append(inputStr);
                System.out.println(responseStrBuilder);
            }
            return new JSONObject(responseStrBuilder.toString());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
            try {
                response = new JSONObject();
                response.put("success", Boolean.FALSE);
                response.put("message", "Error, No se ha podido establecer conexión con el servidor.");
            } catch (JSONException ex1) {

            }
        } catch (IOException | JSONException e) {
            try {
                response = new JSONObject();
                response.put("success", Boolean.FALSE);
                response.put("message", e.getMessage());

            } catch (JSONException ex2) {
                Logger.getLogger(Solicitudes.class.getName()).log(Level.SEVERE, null, ex2);
            }

        } finally {
            try {
                if (in != null) {
                    in.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;

    }

    public JSONObject sendPostRequest(String sUrl, JSONObject jsonRequest) {

        InputStream in = null;
        JSONObject response = null;
        try {
            URL url = new URL(sUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Content-Type", "application/json; charset=ISO-8859-1");
            urlConnection.setConnectTimeout(500);
            urlConnection.setReadTimeout(0);
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jsonRequest.toString());
            out.close();
            in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "ISO-8859-1"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
                System.out.println(responseStrBuilder);
            }
            response = new JSONObject(responseStrBuilder.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
            try {
                response = new JSONObject();
                response.put("success", Boolean.FALSE);
                response.put("message", "Error, No se ha podido establecer conexión con el servidor.");
            } catch (JSONException ex1) {

            }
        } catch (IOException | JSONException e) {
            try {
                response = new JSONObject();
                response.put("success", Boolean.FALSE);
                response.put("message", e.getMessage());

            } catch (JSONException ex2) {
                Logger.getLogger(Solicitudes.class.getName()).log(Level.SEVERE, null, ex2);
            }

        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;

    }

    protected JSONArray getJsonArrayRecursive(Object param) throws JSONException {
        List<Object> list = (List<Object>) param;
        JSONArray jsonArray = new JSONArray();
        for (Object object : list) {
            HashMap<String, Object> jsonMap = (HashMap<String, Object>) object;
            Set<String> keyset = jsonMap.keySet();
            for (String key : keyset) {
                Object jsonElement = jsonMap.get(key);
                if (jsonElement instanceof List) {
                    jsonArray.put(getJsonArrayRecursive(object));
                } else {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put(key, jsonElement);
                    jsonArray.put(jsonObject);
                }
            }
        }
        return jsonArray;
    }
}
