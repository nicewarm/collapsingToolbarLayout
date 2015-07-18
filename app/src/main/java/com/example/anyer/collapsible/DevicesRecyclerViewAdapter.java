package com.example.anyer.collapsible;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anyer on 6/26/15.
 */
public class DevicesRecyclerViewAdapter extends
        RecyclerView.Adapter<DevicesRecyclerViewAdapter.BboxRecyclerViewHolder> {

    private List<String> devices;

    public DevicesRecyclerViewAdapter(List<String> devices) {
        this.devices = devices;
    }

    @Override
    public BboxRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view, viewGroup, false);

        return new BboxRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BboxRecyclerViewHolder bboxRecyclerViewHolder, int i) {
        final String device = devices.get(i);
        bboxRecyclerViewHolder.textViewDevice.setText(device);
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public List<String> getDevices() {
        return devices;
    }

    public static class BboxRecyclerViewHolder extends RecyclerView.ViewHolder {
        protected TextView textViewDevice;

        public BboxRecyclerViewHolder(View v) {
            super(v);

            textViewDevice =  (TextView) v.findViewById(R.id.card_view_textview_card);
        }
    }
}
