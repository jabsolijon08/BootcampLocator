package com.example.james.bootcamplocator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by James on 8/14/2017.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationViewHolder>{

    private ArrayList<LocationModel> locations;
    public LocationAdapter(ArrayList<LocationModel> locations) {
        this.locations = locations;
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        final LocationModel location = locations.get(position);
        holder.updateMap(location);
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new LocationViewHolder(card);
    }

}