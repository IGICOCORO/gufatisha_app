package bi.guymichel.gufatisha_app.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Fragments.ReservationFragment;
import bi.guymichel.gufatisha_app.Host;
import bi.guymichel.gufatisha_app.Models.Reservation;
import bi.guymichel.gufatisha_app.R;


public class AdapterBooking extends RecyclerView.Adapter<AdapterBooking.ViewHolder> {
    private ReservationFragment fragment;
    private final int layoutId;
    private ArrayList<Reservation> reservations ;



    public AdapterBooking(int layoutId, ReservationFragment fragment,ArrayList<Reservation> reservations) {
        this.fragment = fragment;
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
        holder.view.setOnClickListener(view -> {
            fragment.delete(position);
        });
    }


    @Override
    public int getItemCount() {
        return reservations.size();
    }
    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
        notifyDataSetChanged();
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