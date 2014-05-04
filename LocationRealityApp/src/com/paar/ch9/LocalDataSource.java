package com.paar.ch9;

import java.util.ArrayList;
import java.util.List;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.dynastymasra.lbs.R;


public class LocalDataSource extends DataSource{
    private List<Marker> cachedMarkers = new ArrayList<Marker>();
    private static Bitmap icon = null;
    
    public LocalDataSource(Resources res) {
        if (res==null) throw new NullPointerException();
        
        createIcon(res);
    }
    
    protected void createIcon(Resources res) {
        if (res==null) throw new NullPointerException();
        
        icon=BitmapFactory.decodeResource(res, R.drawable.ic_hotel_marker);
    }

//    map.addMarker(new MarkerOptions().position(new LatLng(-7.781868, 110.402147)).title("Royal Ambarrukmo").snippet("Jl. Laksda Adisucipto No.81, Yogyakarta, Indonesia").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_hotel_marker)));
//    map.addMarker(new MarkerOptions().position(new LatLng(-7.783521, 110.391349)).title("Saphir").snippet("Jalan Laksda Adisucipto No.38, Yogyakarta, Daerah Istimewa Yogyakarta 55001, Indonesia").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_hotel_marker)));
//    map.addMarker(new MarkerOptions().position(new LatLng(-7.739325, 110.373405)).title("Hyatt Regency Yogyakarta").snippet("Jalan Palagan Tentara Pelajar, Yogyakarta, Daerah Istimewa
    
    public List<Marker> getMarkers() {
        Marker atl = new IconMarker("Royal Ambarrukmo", -7.781868, 110.402147, 0, Color.TRANSPARENT, icon);
        cachedMarkers.add(atl);

        Marker home = new IconMarker("Saphir", -7.783521, 110.391349, 0, Color.TRANSPARENT, icon);
        cachedMarkers.add(home);

        Marker hyatt = new IconMarker("Hyatt Regency Yogyakarta", -7.739325, 110.373405, 0, Color.TRANSPARENT, icon);
        cachedMarkers.add(hyatt);

        return cachedMarkers;
    }
}