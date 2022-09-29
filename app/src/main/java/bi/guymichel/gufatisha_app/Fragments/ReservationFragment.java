package bi.guymichel.gufatisha_app.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Adapters.AdapterBooking;
import bi.guymichel.gufatisha_app.Dialogs.BookingDialog;
import bi.guymichel.gufatisha_app.Host;
import bi.guymichel.gufatisha_app.Models.Reservation;
import bi.guymichel.gufatisha_app.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ReservationFragment extends Fragment {
    private static ArrayList<Reservation> reservations =  new ArrayList<>();;
    private static AdapterBooking adapter;
    RecyclerView orderlist;
    private Reservation reservation;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        orderlist = view.findViewById(R.id.orderlist);
        adapter = new AdapterBooking(R.layout.card_booking, this ,reservations);
        orderlist.setAdapter(adapter);
       getOrders();
        return view;
    }



    private void getOrders() {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlbuilder;
        urlbuilder = HttpUrl.parse(Host.URL + "/Reservation/").newBuilder();
        String url = urlbuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                getActivity().runOnUiThread(() -> {
                    Toast.makeText(getActivity(), "Erreur de connexion", Toast.LENGTH_SHORT).show();
                });
                Log.i("=====RESERVATIONS=====",e.getMessage());
            }

            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String json = response.body().string();
                try {
                    JSONArray json_array = new JSONObject(json).getJSONArray("results");
                    for (int i=0; i<json_array.length(); i++){
                        JSONObject json_obj = json_array.getJSONObject(i);
                        JSONObject json_obj_client = json_obj.getJSONObject("client");
                        JSONObject json_object_chambre = json_obj.getJSONObject("chambre");
                        Reservation reservation = new Reservation(
                                json_object_chambre.getString("id"),
                                json_object_chambre.getString("numero"),
                                json_obj_client.getString("nom") + json_obj_client.getString("prenom") ,
                                json_obj.getString("date_arrivee"),
                                json_obj.getString("date_depart"),
                                json_object_chambre.getString("prix")
                        );
                        reservations.add(reservation);
                    }
                    getActivity().runOnUiThread(() -> {
                       adapter.setReservations(reservations);
                       adapter.notifyDataSetChanged();
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(),"Une exception de chargement",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public static void pushReservation(Reservation res) {
        reservations.add(res);
        adapter.setReservations(reservations);
    }

    public void delete(int position) {
        reservation = reservations.get(position);
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Host.URL + "/Reservation/"+reservation.id+"/").newBuilder();

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                //.header("Authorization", "Token "+context.token)
                .delete()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                if (!json.trim().isEmpty()){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "Suppression échouée", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return;
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        reservations.remove(position);
                        adapter.notifyItemRemoved(position);
                    }
                });
            }
        });
    }
}