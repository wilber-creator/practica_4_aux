package com.example.practican4_aux;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import javax.crypto.spec.GCMParameterSpec;


/**
 * A simple {@link Fragment} subclass.
 */
public class tab1 extends Fragment implements OnMapReadyCallback {


    GoogleMap aGoogleMap;
    MapView aMapView;
    View aView;


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        aView = inflater.inflate(R.layout.fragment_tab1, container, false);
        return aView;
    }


    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        aMapView = (MapView) aView.findViewById(R.id.map);
        if(aMapView != null){
            aMapView.onCreate(null);
            aMapView.onResume();
            aMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        aGoogleMap = googleMap;

        aGoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title(latLng.latitude+" : "+latLng.longitude);
                aGoogleMap.clear();
                aGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                aGoogleMap.addMarker(markerOptions);
            }
        });

        MapsInitializer.initialize(getContext());

        aGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-19.5841035,-65.7566753)));
        CameraPosition.Builder Liberty = CameraPosition.builder().target(new LatLng(-19.5841035,-65.7566753));

    }
}
