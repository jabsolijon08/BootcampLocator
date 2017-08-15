package com.example.james.bootcamplocator;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by James on 8/14/2017.
 */

public class LocationViewHolder extends RecyclerView.ViewHolder {
    private TextView loctitle;
    private TextView locsnippet;
    public LocationViewHolder(View itemView) {
        super(itemView);

        loctitle = (TextView)itemView.findViewById(R.id.tvlocationtitle);
        locsnippet = (TextView)itemView.findViewById(R.id.tvlocationadd);
    }

    public void updateMap (LocationModel location){
        loctitle.setText(location.getLocTitle());
        locsnippet.setText(location.getLocAddress());
    }
}
