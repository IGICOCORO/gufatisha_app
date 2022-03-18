package bi.guymichel.gufatisha_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Models.Hotel;
import bi.guymichel.gufatisha_app.Models.Reservation;
import bi.guymichel.gufatisha_app.R;

public class AdapterBooking extends RecyclerView.Adapter<AdapterBooking.ViewHolder>  {
    private Context context;
    private ArrayList<Reservation> reservations ;

    private final int layoutId;
    public AdapterBooking(int layoutId, Context context, ArrayList<Reservation> reservations) {
        this.context = context;
        this.reservations = reservations;
        this.layoutId = layoutId;
    }

    @Override
    public AdapterBooking.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_booking, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Reservation reservation = reservations.get(position);
        holder.ch_number.setText(reservation.chambre);
        holder.nom_client.setText(reservation.client);
        holder.date_checkin.setText(reservation.date_arrivee);
        holder.date_checkout.setText(reservation.date_depart);
        holder.price_chambre.setText(reservation.prix);
        holder.btn_order_cancel.setOnClickListener(v -> {

        });
    }



    @Override
    public int getItemCount() {

        return reservations.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView ch_number,nom_client,date_checkin,date_checkout,price_chambre;
        Button btn_order_cancel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ch_number = view.findViewById(R.id.ch_number);
            nom_client = view.findViewById(R.id.nom_client);
            date_checkin = view.findViewById(R.id.date_checkin);
            date_checkout = view.findViewById(R.id.date_checkout);
            price_chambre = view.findViewById(R.id.price_chambre);
            btn_order_cancel = view.findViewById(R.id.btn_order_cancel);
            view = itemView;
        }
    }
}
