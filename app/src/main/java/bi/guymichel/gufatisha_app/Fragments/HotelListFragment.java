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

import bi.guymichel.gufatisha_app.Adapters.AdapterHome;
import bi.guymichel.gufatisha_app.Host;
import bi.guymichel.gufatisha_app.Models.Hotel;
import bi.guymichel.gufatisha_app.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HotelListFragment extends Fragment {
    RecyclerView hotellist;
    private ArrayList<Hotel> hotels = new ArrayList<>();
    AdapterHome adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotel_list, container, false);
        hotellist = view.findViewById(R.id.hotellist);
        adapter = new AdapterHome(R.layout.card_hotel_view,getContext() ,hotels);
        hotellist.setAdapter(adapter);
        getHotels();
        return view;
    }

    private void getHotels() {
            OkHttpClient client = new OkHttpClient();
            HttpUrl.Builder urlbuilder;
            urlbuilder = HttpUrl.parse(Host.URL + "/hotel/").newBuilder();
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
                }

                @SuppressLint("LongLogTag")
                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    String json = response.body().string();
                    try {
                      JSONArray json_array = new JSONObject(json).getJSONArray("results");
                        for (int i=0; i<json_array.length(); i++){
                            JSONObject json_obj = json_array.getJSONObject(i);
                            Hotel hotel = new Hotel(
                                    json_obj.getInt("id"),
                                    json_obj.getString("nom"),
                                    json_obj.getString("photo_couverture")
                            );
                            for (int j = 0;j<json_obj.getJSONArray("valeurs").length(); j++){
                                JSONObject jn_obj = json_obj.getJSONArray("valeurs").getJSONObject(j);
                               hotel.valeur.add(jn_obj.getString("nom_valeur"));
                            }
                            hotels.add(hotel);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        //Toast.makeText(getActivity(),"Une exception de chargement",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }