package com.example.micka.playgroundprojectv2.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.micka.playgroundprojectv2.Adapters.BeaconAdapter;
import com.example.micka.playgroundprojectv2.Models.Beacon;
import com.example.micka.playgroundprojectv2.R;

import java.util.ArrayList;

/**
 * Created by micka on 1/15/2018.
 */

public class BeaconFragment extends Fragment {

    private TextView textView;
    private RecyclerView recyclerView;
    private BeaconAdapter beaconAdapter;
    public ArrayList<Beacon> beaconArrayList = new ArrayList<>();
    private Context context;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getBeaconsArrayList();
        View view = inflater.inflate(R.layout.fragment_beacon,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycleview_beacon_fragment);
        beaconAdapter = new BeaconAdapter(getContext(),beaconArrayList);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(linearLayoutManager);
        for(Beacon beacon:beaconArrayList){
            System.out.println(beacon.getName());
        }

        recyclerView.setAdapter(beaconAdapter);

        return view;
    }

    private void getBeaconsArrayList(){
        for(int i=0 ; i<4;i++) {
            String string = "Nick Cage #" + i;
            beaconArrayList.add(new Beacon(string));
            string = "";
        }
    }
}
