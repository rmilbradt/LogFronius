<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Guilherme
  Date: 25/08/2015
  Time: 10:22
  To change this template use File | Settings | File Templates.
  
  mapa.jsp
  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <style type="text/css">
        html {
            height: 100%
        }

        body {
            height: 100%;
            margin: 0;
            padding: 0
        }

        #map {
            height: 100%
        }
    </style>

    <script type="text/javascript"
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD2-_UjcPzLiEwN7QBchB5FTly3zhRLZbA&sensor=false&libraries=geometry"></script>
    <script type=" text/javascript">
        function initialize() {

            var myLatLng = {lat: -29.721856, lng: -53.718129};

            var local1 = new google.maps.LatLng(-29.721856, -53.718129);
            var local2 = new google.maps.LatLng(-29.713386, -53.715470);

            console.log("local1: " + local1);
            console.log("local2: " + local2);
            console.log("distancia: " + google.maps.geometry.spherical.computeDistanceBetween(local1, local2));


            /*var pontos = {
             poli: {
             center: {lat: -29.721856, lng: -53.718129},
             rad: 50
             },
             husm: {
             center: {lat: -29.713386, lng: -53.715470},
             rad: 100
             }
             };*/

            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 15,
                center: myLatLng
            });

            //var pontos = new google.maps.LatLng(${pontos});

            //console.log(pontos);

            var coor = document.getElementById('teste').value;
            console.log(coor);
            coor = coor.replace("[", "").replace("]", "");
            var pontos = coor.split(",");


            var i;
            var temp = "";
            var coords = new Array();
            for (i = 0; i < pontos.length; i++) {
                if (i % 2 != 0) {
                    console.log(temp, pontos[i], i);
                    var local = new google.maps.LatLng(temp, pontos[i]);
                    var circle = new google.maps.Circle({
                        strokeColor: '#FF0000',
                        strokeOpacity: 0.8,
                        strokeWeight: 2,
                        fillColor: '#FF0000',
                        fillOpacity: 0.35,
                        map: map,
                        center: local,
                        radius: Math.sqrt(50) * 100
                    });
                    coords.push(local);
                    console.log(local);
                } else {
                    temp = pontos[i];
                }
            }

            /*var temp1 = new google.maps.LatLng();
            var distancias = [];
            for (i = 0; i < coords.length; i++) {
                if (i == 0) {
                    temp1 = coords[i];
                } else {
                    distancias.push(google.maps.geometry.spherical.computeDistanceBetween(temp1, coords[i]));
                    temp1 = coords[i];
                }
            }

            console.log("distancias: " + distancias);*/

        }
    </script>
</head>
<body onload="initialize()">
<input id="teste" value="${pontos}" type="hidden">

<div id="map" style="width:100%; height:100%">

</div>
</body>
</html>


