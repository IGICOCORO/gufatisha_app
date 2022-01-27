package bi.guymichel.gufatisha_app.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Adapters.AdapterHome;
import bi.guymichel.gufatisha_app.Models.Hotel;
import bi.guymichel.gufatisha_app.R;

public class HotelListFragment extends Fragment {
    RecyclerView hotellist;
    private ArrayList<Hotel> hotels;
    AdapterHome adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotel_list, container, false);
        hotellist = view.findViewById(R.id.hotellist);
        adapter = new AdapterHome(R.layout.card_hotel_view, getActivity());
        hotellist.setAdapter(adapter);
        return view;
    }

}