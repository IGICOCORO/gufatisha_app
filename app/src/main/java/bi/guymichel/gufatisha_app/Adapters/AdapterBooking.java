package bi.guymichel.gufatisha_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import bi.guymichel.gufatisha_app.R;

public class AdapterBooking extends RecyclerView.Adapter<AdapterBooking.ViewHolder>  {
    private Context context;

    public AdapterBooking(Context context, int layoutId) {
        this.context = context;
    }

    @Override
    public AdapterBooking.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_booking, parent, false);
        return new AdapterBooking.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 10;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
