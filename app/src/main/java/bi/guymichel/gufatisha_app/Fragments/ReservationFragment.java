package bi.guymichel.gufatisha_app.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Adapters.AdapterBooking;
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
    RecyclerView orderlist;
    private ArrayList<Reservation> reservations = new ArrayList<>();
    AdapterBooking adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        orderlist = view.findViewById(R.id.orderlist);
        adapter = new AdapterBooking(R.layout.card_booking,getContext() ,reservations);
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
                Log.i("====JSONReservation=======", json);
                try {
                    JSONArray json_array = new JSONObject(json).getJSONArray("results");
                    for (int i=0; i<json_array.length(); i++){
                        JSONObject json_obj = json_array.getJSONObject(i);
                        JSONObject json_obj_client = json_obj.getJSONObject("client");
                        JSONObject json_object_chambre = json_obj.getJSONObject("chambre");
                        Reservation reservation = new Reservation(
                                json_object_chambre.getString("numero"),
                                json_obj_client.getString("nom") + json_obj_client.getString("prenom") ,
                                json_obj.getString("date_arrivee"),
                                json_obj.getString("date_depart"),
                                json_object_chambre.getString("prix")
                        );

                        Log.i("====JSON=======", String.valueOf(json_obj));
                        reservations.add(reservation);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    //Toast.makeText(getActivity(),"Une exception de chargement",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}