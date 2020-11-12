/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guateroad;

import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.*;
//import com.teamdev.jxmaps.Map;
//import java.awt.BorderLayout;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author Jeany
 */
public class Mapa extends MapView{
    
    private Map map;
    
    public Mapa(MapViewOptions Cambios)
    {
        super(Cambios);
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus ms) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(ms == MapStatus.MAP_STATUS_OK)
                {
                    map = getMap();
                    MapOptions opciones = new MapOptions();
                    MapTypeControlOptions Control = new MapTypeControlOptions();
                    Control.setPosition(ControlPosition.BOTTOM_LEFT);
                    opciones.setMapTypeControlOptions(Control);
                    map.setOptions(opciones);
                    map.setCenter(new LatLng(14.642449, -90513563));  //Voy a tomar estos puntos que asignaré segun donde quiera iniciar 
                    map.setZoom(11);
                }
            }
        });
        System.out.println("Esperando el mapa");
        try{
            for(int i = 0; i < 3; i++)
            {
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
            }
        } catch(Exception e) {
            System.out.println("Tardo mucho ERROR");
        }
        System.out.println("Mapa generado ");
    }
    
    private Marker Punto(LatLng coordenada) 
    {
        Marker marcador = new Marker(map);
        marcador.setPosition(coordenada);
        map.setCenter(coordenada);
        return marcador;
    }
    
    public void DibujarLinea(LatLng inicio, LatLng fin, boolean ConMarcador)
    {
        LatLng[] graficar = {inicio, fin};
        Polyline PLine = new Polyline(map);
        PLine.setPath(graficar);
        if (ConMarcador)
        {
            Punto(inicio);
            Punto(fin);
            System.out.println("Dibujando linea en " + inicio + ", " + fin);
        }
    }
    
    public void Posicion(LatLng coor, String Color)
    {
        Circle circulo = new Circle(map);
        circulo.setCenter(coor);
        circulo.setRadius(25);
        CircleOptions Op = new CircleOptions();
        Op.setFillColor(Color);
        Op.setFillOpacity(0.5);
        circulo.setOptions(Op);
    }
    
    public void DibujarGrafo(LatLng inicio, LatLng fin)
    {
        LatLng[] coordenadas = {inicio, fin};
        Polyline PLine = new Polyline(map);
                
        PolylineOptions PL = new PolylineOptions();
        PL.setStrokeColor("#DA2789");
        //PL.setStrokeWeight(2.0);
        PLine.setOptions(PL);
        
        PLine.setPath(coordenadas);
        /*for (LatLng coordenada : coordenadas) {
            Circle nodo = new Circle(map);
            nodo.setCenter(map.getCenter());
            nodo.setRadius(5);
            CircleOptions opC = new CircleOptions();
            opC.setFillColor("#79BEF7");
            opC.setFillOpacity(0.35);
            nodo.setOptions(opC);
        }*/
    }
    
}
