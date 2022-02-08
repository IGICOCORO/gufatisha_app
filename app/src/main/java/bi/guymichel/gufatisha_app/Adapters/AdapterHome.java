package bi.guymichel.gufatisha_app.Adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Models.Hotel;
import bi.guymichel.gufatisha_app.Models.Room;
import bi.guymichel.gufatisha_app.R;
import bi.guymichel.gufatisha_app.RoomActivity;


public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    private Context context;
    private final int layoutId;
    private ArrayList<Hotel> hotels ;



    public AdapterHome(int layoutId,Context context,ArrayList<Hotel> hotels) {
        this.context = context;
        this.layoutId = layoutId;
        this.hotels = hotels;
    }



    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_hotel_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       /* holder.nom_hotel.setText(hotels.get(position).getNom());
        Glide.with(this.context).load(hotels.get(position).getImage()).into(holder.card_image); */
        holder.card_image.setOnClickListener(v -> {
          Intent intent = new Intent(this.context, RoomActivity.class);
          this.context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
     ImageView card_image;
     TextView nom_hotel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card_image = itemView.findViewById(R.id.card_image);
            nom_hotel = itemView.findViewById(R.id.nom_hotel);
            view = itemView;
        }
    }
}