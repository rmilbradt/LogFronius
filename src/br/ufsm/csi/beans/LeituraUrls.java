package br.ufsm.csi.beans;

import br.ufsm.csi.model.LeituraInversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Map;

/**
 * Created by 201420240 on 01/06/2015.
 */
@Repository
public class LeituraUrls {

    private LeituraInversor ultimaLeitura;

    @Autowired
    private LeituraInversorDAO dao;

    public LeituraUrls() {
        new Thread(new ThreadLeituras()).start();
    }

    public LeituraInversor getUltimaLeitura() { return ultimaLeitura; }

    public LeituraInversor executaLeitura() throws IOException {

        LeituraInversor leitura = new LeituraInversor();

        URL url1 = new URL("http://200.132.36.179/solar_api/v1/GetSensorRealtimeData.cgi?Scope=Device&DeviceId=0&DataCollection=NowSensorData");
        InputStream is = url1.openStream();
        JsonReader rdr = Json.createReader(is);
        JsonObject obj = rdr.readObject();
        JsonObject body = obj.getJsonObject("Body");
        JsonObject data = body.getJsonObject("Data");

        for (Map.Entry<String, JsonValue> result : data.entrySet()) {
            JsonObject value = (JsonObject) result.getValue();

            if (result.getKey().equals("0")) {
                leitura.setTempModulos(value.getJsonNumber("Value").intValue());
                //System.out.println("Temperatura Modulos: " + leitura.getTempModulos() + " " + value.getString("Unit"));
            } else if (result.getKey().equals("1")) {
                leitura.setTempAmbiente(value.getJsonNumber("Value").intValue());
                //System.out.println("Temperatura Ambiente: " + leitura.getTempAmbiente() + " " + value.getString("Unit"));
            } else if (result.getKey().equals("2")) {
                leitura.setIrradiancia(value.getJsonNumber("Value").intValue());
                //System.out.println("Irradiancia: " + leitura.getIrradiancia() + " " + value.getString("Unit"));
            } else if (result.getKey().equals("4")) {
                leitura.setVento(value.getJsonNumber("Value").intValue());
                //System.out.println("Vento: " + leitura.getVento() + " " + value.getString("Unit"));
            }
        }



        URL url2 = new URL("http://200.132.36.179/solar_api/v1/GetInverterRealtimeData.cgi?Scope=Device&DeviceId=1&DataCollection=CommonInverterData");
        is = url2.openStream();
        rdr = Json.createReader(is);
        obj = rdr.readObject();
        body = obj.getJsonObject("Body");
        data = body.getJsonObject("Data");

        for (Map.Entry<String, JsonValue> result : data.entrySet()) {
            JsonObject value = (JsonObject) result.getValue();

            if (result.getKey().equals("DAY_ENERGY")) {
                leitura.setEnergiaDia(value.getJsonNumber("Value").doubleValue());
                //System.out.println("Energia Diaria: " + leitura.getEnergiaDia() + " " + value.getString("Unit"));
            } else if (result.getKey().equals("FAC")) {
                leitura.setAcFrequency(value.getJsonNumber("Value").doubleValue());
                //System.out.println("AC Frequency: " + leitura.getAcFrequency() + " " + value.getString("Unit"));
            } else if (result.getKey().equals("IAC")) {
                leitura.setAcCurrent(value.getJsonNumber("Value").doubleValue());
                //System.out.println("AC Current: " + leitura.getAcCurrent() + " " + value.getString("Unit"));
            } else if (result.getKey().equals("IDC")) {
                leitura.setDcCurrent(value.getJsonNumber("Value").doubleValue());
                //System.out.println("DC Current: " + leitura.getDcCurrent() + " " + value.getString("Unit"));
            } else if (result.getKey().equals("PAC")) {
                leitura.setPotencia(value.getJsonNumber("Value").doubleValue());
                //System.out.println("Potência: " + leitura.getPotencia() + " " + value.getString("Unit"));
            } else if (result.getKey().equals("TOTAL_ENERGY")) {
                leitura.setEnergiaTotal(value.getJsonNumber("Value").doubleValue());
                //System.out.println("Energia Total: " + leitura.getEnergiaTotal() + " " + value.getString("Unit"));
            } else if (result.getKey().equals("UAC")) {
                leitura.setAcVoltage(value.getJsonNumber("Value").doubleValue());
                //System.out.println("AC Voltage: " + leitura.getAcVoltage() + " " + value.getString("Unit"));
            } else if (result.getKey().equals("UDC")) {
                leitura.setDcVoltage(value.getJsonNumber("Value").doubleValue());
                //System.out.println("DC Voltage: " + leitura.getDcVoltage() + " " + value.getString("Unit"));
            } else if (result.getKey().equals("YEAR_ENERGY")) {
                leitura.setEnergiaAnual(value.getJsonNumber("Value").doubleValue());
                //System.out.println("Energia Anual: " + leitura.getEnergiaAnual() + " " + value.getString("Unit"));
            }
        }
        leitura.setDataHoraLeitura(new Date());
        return leitura;
    }

    public class ThreadLeituras implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    long milis = System.currentTimeMillis();
                    ultimaLeitura = executaLeitura();
                    dao.gravaLeitura(ultimaLeitura);
                    milis = System.currentTimeMillis() - milis;
                    Thread.sleep(milis > 10000 ? 0 : 10000 - milis);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
