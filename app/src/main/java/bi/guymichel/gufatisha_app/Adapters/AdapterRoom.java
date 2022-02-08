package bi.guymichel.gufatisha_app.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import bi.guymichel.gufatisha_app.Models.Room;
import bi.guymichel.gufatisha_app.R;


public class AdapterRoom extends RecyclerView.Adapter<AdapterRoom.ViewHolder> {
    private Context context;
    private final int layoutId;
    private ArrayList<Room> rooms ;



    public AdapterRoom(int layoutId,Context context,ArrayList<Room> rooms) {
        this.context = context;
        this.layoutId = layoutId;
        this.rooms = rooms;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_room, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       /* holder.nom_hotel.setText(hotels.get(position).getNom());
        Glide.with(this.context).load(hotels.get(position).getImage()).into(holder.card_image); */

    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView image_item;
        TextView room_number,price_number,room_type_value,nbr_person_value;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_item = itemView.findViewById(R.id.image_item);
            room_number = itemView.findViewById(R.id.room_number);
            price_number = itemView.findViewById(R.id.price_number);
            room_type_value = itemView.findViewById(R.id.room_type_value);
            nbr_person_value = itemView.findViewById(R.id.nbr_person_value);
            view = itemView;
        }
    }
}