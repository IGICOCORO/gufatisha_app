package bi.guymichel.gufatisha_app.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Adapters.AdapterBooking;
import bi.guymichel.gufatisha_app.Models.Reservation;
import bi.guymichel.gufatisha_app.R;


public class ReservationFragment extends Fragment {
    RecyclerView orderlist;
    private ArrayList<Reservation> reservations;
    AdapterBooking adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        orderlist = view.findViewById(R.id.orderlist);
        adapter = new AdapterBooking(getActivity(), R.layout.card_booking);
        orderlist.setAdapter(adapter);
        return view;
    }
}