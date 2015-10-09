package br.ufsm.csi.controller;

import br.ufsm.csi.beans.InversorDAO;
import br.ufsm.csi.model.Inversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.me.jstott.jcoord.LatLng;

import java.util.*;

/**
 * Created by Guilherme on 25/08/2015.
 *
 */
@Controller
public class MapaController {

    @Autowired
    InversorDAO dao;

    @RequestMapping(value = "mapa.html")
    public String viewMapa(Model model){

        List<Inversor> inversors = dao.findInversores();

       // ArrayList<LatLng> pontos = new ArrayList<>();
        ArrayList<String> pontos = new ArrayList<>();

        Map<Long, LatLng> distancias = new HashMap<>();
        Map<Long, Double> raio = new HashMap<>();


        // pontos.add(inv.getCoordenadas());
        String[] latlng;
        Double lat, lng;
        for (Inversor inv : inversors){
            if(inv.getCoordenadas() != null) {
                String ponto = inv.getCoordenadas().replaceAll("[()]", "");
                pontos.add(ponto);

                latlng = ponto.split(",");
                lat = Double.parseDouble(latlng[0]);
                lng = Double.parseDouble(latlng[1]);

                distancias.put(inv.getId(), new LatLng(lat, lng));
                //pontos.add(new LatLng(lat, lng));
            }
        }

        LatLng ponto1;
        Double temp;
        for(Long id : distancias.keySet()){
            ponto1 = distancias.get(id);
            for (Long id2 : distancias.keySet()){
                if (!Objects.equals(id2, id)){
                    temp = ponto1.distance(distancias.get(id2));

                    if(!raio.containsKey(id)){
                        raio.put(id, temp);
                    }

                    if (temp < raio.get(id)){
                        raio.put(id, temp);
                    }
                }
            }
        }


        model.addAttribute("pontos", pontos);
        model.addAttribute("raio", raio);

        return "mapa";
    }

}
