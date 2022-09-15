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
import bi.guymichel.gufatisha_app.RoomActivity;


public class AdapterRoom extends RecyclerView.Adapter<AdapterRoom.ViewHolder> {
    private RoomActivity context;
    private final int layoutId;
    private ArrayList<Room> rooms ;



    public AdapterRoom(int layoutId,RoomActivity context,ArrayList<Room> rooms) {
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
        Room room = rooms.get(position);
        holder.room_number.setText(room.numero);
        holder.price_number.setText(room.prix);
        holder.room_type.setText(room.type_chambre);
        holder.nbr_person.setText(room.nbres_personnes);
        Glide.with(this.context).load(room.pic1).into(holder.image_item);
        holder.view.setOnClickListener(v ->{
            context.setRoom(room);
        });
    }


    @Override
    public int getItemCount() {
        return rooms.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView image_item;
        TextView room_number,price_number,room_type,nbr_person;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_item = itemView.findViewById(R.id.image_item);
            room_number = itemView.findViewById(R.id.room_number);
            price_number = itemView.findViewById(R.id.price_number);
            room_type = itemView.findViewById(R.id.room_type);
            nbr_person = itemView.findViewById(R.id.nbr_person);
            view = itemView;
        }
    }
}