package bi.guymichel.gufatisha_app.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Models.Reservation;
import bi.guymichel.gufatisha_app.R;


public class AdapterBooking extends RecyclerView.Adapter<AdapterBooking.ViewHolder> {
    private Context context;
    private final int layoutId;
    private ArrayList<Reservation> reservations ;



    public AdapterBooking(int layoutId,Context context,ArrayList<Reservation> reservations) {
        this.context = context;
        this.layoutId = layoutId;
        this.reservations = reservations;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_booking, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Reservation reservation = reservations.get(position);
        holder.chambre_number.setText(reservation.numero_chambre);
        holder.nom_client.setText(reservation.client);
        holder.date_checkin.setText(reservation.date_arrivee);
        holder.date_checkout.setText(reservation.date_depart);
        holder.price_chambre.setText(reservation.prix_chambre);

    }


    @Override
    public int getItemCount() {
        return reservations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView chambre_number,nom_client,date_checkin,date_checkout,price_chambre;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chambre_number = itemView.findViewById(R.id.chambre_number);
            nom_client = itemView.findViewById(R.id.nom_client);
            date_checkin = itemView.findViewById(R.id.date_checkin);
            date_checkout = itemView.findViewById(R.id.date_checkout);
            price_chambre = itemView.findViewById(R.id.price_chambre);
            view = itemView;
        }
    }
}