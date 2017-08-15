package com.example.james.bootcamplocator;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by James on 8/14/2017.
 */


public class MainFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    private MarkerOptions userMarker;
    private String zip;
    private LocationFragment locationsListFragments;


    public MainFragment() {
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationsListFragments =  (LocationFragment) getActivity()
                .getSupportFragmentManager()
                .findFragmentById(R.id.location_container);
        if(locationsListFragments == null){
            locationsListFragments = LocationFragment.newInstance();
            getActivity().
                    getSupportFragmentManager().
                    beginTransaction().
                    add(R.id.location_container, locationsListFragments).
                    commit();
        }

        final EditText zipText = (EditText) view.findViewById(R.id.etSearch);
        zipText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    zip = zipText.getText().toString();
                    InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(zipText.getWindowToken(), 0);
                    updateMapForZip(zip);
                    showLoc();
                    return true;
                }
                return false;
            }
        });
        hideLoc();
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

    }

    public void setLocationMarkers(LatLng latLng) {
        if (userMarker == null) {
            userMarker = new MarkerOptions().position(latLng).title("Current Location");
            mGoogleMap.addMarker(userMarker);
        }
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        mGoogleMap.setTrafficEnabled(true);
    }

    private void updateMapForZip(String zipcode){

        Toast.makeText(getContext(), zipcode, Toast.LENGTH_SHORT).show();
        ArrayList<LocationModel> locations = DataService.getInstance().getNearBootCampLocations(Integer.parseInt(zipcode));

        for (int x = 0; x < locations.size(); x++){
            LocationModel loc = locations.get(x);
            MarkerOptions marker = new MarkerOptions().position(new LatLng(loc.getLati(), loc.getLongi()));
            marker.title(loc.getLocTitle());
            marker.snippet(loc.getLocAddress());
            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin));
            mGoogleMap.addMarker(marker);
        }
    }

    public void hideLoc(){
        getActivity().getSupportFragmentManager().beginTransaction().hide(locationsListFragments).commit();
    }

    public void showLoc(){
        getActivity().getSupportFragmentManager().beginTransaction().show(locationsListFragments).commit();
    }

}