package com.dynastymasra.lbs.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dynastymasra.lbs.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class MapsFragment extends Fragment {
    private GoogleMap map;
    private final static LatLng YOGYAKARTA = new LatLng(-7.797069, 110.37053);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        if(map == null) {
            map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        }

        map.clear();

        map.addMarker(new MarkerOptions().position(YOGYAKARTA).title("Yogyakarta").snippet("Yogyakarta Province, Indonesia"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(YOGYAKARTA, 15));
        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

        return view;
    }
}
