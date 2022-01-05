package bi.guymichel.gufatisha_app.Adapters;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bi.guymichel.gufatisha_app.MainActivity;
import bi.guymichel.gufatisha_app.Models.Hotel;
import bi.guymichel.gufatisha_app.R;


public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    Activity activity;
    private ArrayList<Hotel> hotels;

    public AdapterHome(Activity activity,ArrayList<Hotel>hotels) {
        this.hotels =  hotels;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_hotel_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    final Hotel hotel = hotels.get(position);
    holder.nom_hotel.setText(hotel.nom);
        holder.wifi.setText(hotel.nom);
        holder.nom_hotel.setText(hotel.nom);
        holder.nom_hotel.setText(hotel.nom);
        holder.nom_hotel.setText(hotel.nom);
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
     ImageView card_image;
     TextView nom_hotel,wifi,resto,hour_work,climat,room_meet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card_image = itemView.findViewById(R.id.card_image);
            nom_hotel = itemView.findViewById(R.id.nom_hotel);
            wifi = itemView.findViewById(R.id.wifi);
            resto = itemView.findViewById(R.id.resto);
            hour_work = itemView.findViewById(R.id.hour_work);
            climat = itemView.findViewById(R.id.climat);
            room_meet = itemView.findViewById(R.id.room_meet);

        }
    }
}