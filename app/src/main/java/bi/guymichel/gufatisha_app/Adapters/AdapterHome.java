package bi.guymichel.gufatisha_app.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Fragments.HotelListFragment;
import bi.guymichel.gufatisha_app.Host;
import bi.guymichel.gufatisha_app.Models.Hotel;
import bi.guymichel.gufatisha_app.R;


public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    HotelListFragment activity;
    private final ArrayList<Hotel> hotels;

    public AdapterHome(HotelListFragment activity, ArrayList<Hotel>hotels) {
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
        //Picasso.get().load(Host.URL +"/"+(hotel.image)+".jpg").into(holder.card_image);
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
     ImageView card_image;
     TextView nom_hotel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card_image = itemView.findViewById(R.id.card_image);
            nom_hotel = itemView.findViewById(R.id.nom_hotel);


        }
    }
}