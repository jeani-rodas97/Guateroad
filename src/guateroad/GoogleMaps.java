/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guateroad;

import com.teamdev.jxmaps.*;
import grafo.DatosGrafo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
/**
 *
 * @author Jeany
 */
public class GoogleMaps {
    
    public void VerMapa(double LatInicio, double LatFinal, double LongInicio, double LongFinal, double LatConduct, double LongConduct)
    {
        double latIn, latF, lonIn, lonF;
        MapViewOptions OP = new MapViewOptions();
        OP.importPlaces();
        OP.setApiKey("AIzaSyBt6nr041UEqylMLuuTp2rvztR0oSteZnc");
        Mapa mapita = new Mapa(OP);
        
        LatLng PosConduct = new LatLng(LatConduct, LongConduct);
        
        for (int i = 0; i<Guateroad.grafos.grafo.size(); i++) {
            latIn = Guateroad.HashT.LatLugar(Guateroad.grafos.grafo.get(i).getInicio());
            //System.out.println("latI "+latIn);
            lonIn = Guateroad.HashT.LongLugar(Guateroad.grafos.grafo.get(i).getInicio());
            //System.out.println("lonI "+lonIn);
            LatLng LugarInicial = new LatLng(latIn, lonIn);
            
            latF = Guateroad.HashT.LatLugar(Guateroad.grafos.grafo.get(i).getFin());
            //System.out.println("latF "+latF);
            lonF = Guateroad.HashT.LongLugar(Guateroad.grafos.grafo.get(i).getFin());
            //System.out.println("lonF "+lonF);
            LatLng LugarFinal = new LatLng(latF, lonF);
            
            mapita.DibujarGrafo(LugarInicial, LugarFinal);
        }
        
        LatLng PInicio = new LatLng(LatInicio, LongInicio);
        LatLng PFinal = new LatLng(LatFinal, LongFinal);
        mapita.Posicion(PosConduct, "#2732DA");
        mapita.Posicion(PInicio, "#B736A9");
        mapita.DibujarLinea(PInicio, PFinal, true);
        
        JFrame VMap = new JFrame("Mapa Google");
        VMap.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        VMap.setLocationRelativeTo(null);
        VMap.setSize(1000,800);
        VMap.add(mapita, BorderLayout.CENTER);
        VMap.setVisible(true);
    }
    
}
