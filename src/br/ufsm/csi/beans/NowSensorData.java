package br.ufsm.csi.beans;

import javax.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

/**
 * Created by 201420240 on 01/06/2015.
 */
public class NowSensorData {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://200.132.36.179/solar_api/v1/GetSensorRealtimeData.cgi?Scope=Device&DeviceId=0&DataCollection=br.ufsm.csi.beans.NowSensorData");
        InputStream is = url.openStream();
        JsonReader rdr = Json.createReader(is);
        JsonObject obj = rdr.readObject();
        JsonObject body = obj.getJsonObject("Body");
        JsonObject data = body.getJsonObject("Data");

        for (Map.Entry<String, JsonValue> result : data.entrySet()) {
            JsonObject value = (JsonObject) result.getValue();

            if(value.getJsonNumber("Value") != null){


                JsonNumber valor = value.getJsonNumber("Value");
                String unidade = value.getString("Unit");
                System.out.println(result.getKey() + ": " + valor + " " + unidade);
            }
        }
    }
}
