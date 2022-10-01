package bi.guymichel.gufatisha_app.Adapters;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Models.Hotel;
import bi.guymichel.gufatisha_app.R;
import bi.guymichel.gufatisha_app.RoomActivity;


public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    private Context context;
    private ArrayList<Hotel> hotels ;
    private final int layoutId;

    public AdapterHome(int layoutId, Context context, ArrayList<Hotel> hotels) {
        this.context = context;
        this.hotels = hotels;
        this.layoutId = layoutId;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_hotel_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { Hotel hotel = hotels.get(position);
       holder.nom_hotel.setText(hotel.nom_hotel);
        Glide.with(this.context).load(hotel.image).into(holder.card_image);
        holder.card_image.setOnClickListener(v -> {
            String values = "";
            for (String value:hotel.valeur) {
                values += value +", ";
            }
            if(values.length() > 3){
                values = values.substring(0, values.length()-2);
            }
            Intent intent = new Intent(this.context, RoomActivity.class);
            intent.putExtra("hotel", hotel.id);
            intent.putExtra("values", values);
            this.context.startActivity(intent);
        });
        if(hotel.valeur.contains("wifi")){
            holder.ic_wifi.setVisibility(View.VISIBLE);
        }if(hotel.valeur.contains("Restaurant")){
            holder.ic_resto.setVisibility(View.VISIBLE);
        }if(hotel.valeur.contains("Climatiseur")){
            holder.ic_climat.setVisibility(View.VISIBLE);
        }if(hotel.valeur.contains("Heure")){
            holder.ic_hour.setVisibility(View.VISIBLE);
        }if(hotel.valeur.contains("Salle de Réunion")){
            holder.ic_meeting.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
     ImageView card_image;
     LinearLayout ic_wifi,ic_resto,ic_climat,ic_hour,ic_meeting;
     TextView nom_hotel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card_image = itemView.findViewById(R.id.card_image);
            nom_hotel = itemView.findViewById(R.id.nom_hotel);
            ic_wifi= itemView.findViewById(R.id.ic_wifi);
            ic_resto= itemView.findViewById(R.id.ic_resto);
            ic_climat= itemView.findViewById(R.id.ic_climat);
            ic_hour= itemView.findViewById(R.id.ic_hour);
            ic_meeting= itemView.findViewById(R.id.ic_meeting);
            view = itemView;
        }
    }
}