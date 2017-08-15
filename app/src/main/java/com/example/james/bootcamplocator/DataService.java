package com.example.james.bootcamplocator;

import java.util.ArrayList;

/**
 * Created by James on 8/14/2017.
 */

public class DataService {

    private static final DataService INSTANCE = new DataService();

    public static DataService getInstance() {
        return INSTANCE;
    }

    public DataService() {
    }

    public ArrayList<LocationModel> getNearBootCampLocations(int zipcode){
        ArrayList<LocationModel> locations =new ArrayList<>();
        locations.add(new LocationModel( 10.2908704,123.8614377, "USJ-R Coliseum", "Cebu City, Cebu"));
        locations.add(new LocationModel( 10.288778, 123.862847, "Empoy's Karaoke and Cafe", "Antuwanga, Cebu City, Cebu"));
        locations.add(new LocationModel( 10.288398, 123.864579, "La Nueva Pharmacy", "Cebu South Rd, Cebu S Rd, Cebu City, 6000 Cebu"));
        return locations;
    }


}