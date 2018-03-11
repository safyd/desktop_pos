package com.safyd.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class RespuestaServicio extends Solicitudes {

    public JSONObject obtenFormaDePagos(String url, JSONObject json) {
        try {
            Solicitudes response = new Solicitudes();
            JSONObject jsonRequest = new JSONObject();
            jsonRequest.put("datos", json);
            JSONObject jsonRes = response.sendPostRequest(url, jsonRequest);
            System.out.println(response.sendPostRequest(url, jsonRequest));
            return jsonRes;
        } catch (JSONException ex) {
            Logger.getLogger(RespuestaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new JSONObject();
    }
}
