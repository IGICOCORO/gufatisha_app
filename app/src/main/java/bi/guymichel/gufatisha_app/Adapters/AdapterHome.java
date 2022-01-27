package bi.guymichel.gufatisha_app.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Models.Hotel;
import bi.guymichel.gufatisha_app.R;


public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    private Context context;
    private final int layoutId;



    public AdapterHome(int layoutId,Context context) {
        this.context = context;
        this.layoutId = layoutId;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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