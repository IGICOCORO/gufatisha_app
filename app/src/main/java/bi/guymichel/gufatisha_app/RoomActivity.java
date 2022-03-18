package bi.guymichel.gufatisha_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Adapters.AdapterRoom;
import bi.guymichel.gufatisha_app.Dialogs.BookingDialog;
import bi.guymichel.gufatisha_app.Models.Room;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RoomActivity extends AppCompatActivity {
    RecyclerView roomlist;
    AdapterRoom adapter;
    Button btn_booking;
    private ArrayList<Room> rooms = new ArrayList<>();
    private  int hotel_id ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        roomlist = findViewById(R.id.roomlist);
        adapter = new AdapterRoom(R.layout.card_room, this, rooms);
        roomlist.setAdapter(adapter);
        btn_booking = findViewById(R.id.btn_booking);
        btn_booking.setOnClickListener(v -> openDialog());
        hotel_id = getIntent().getIntExtra("hotel",-1);
        extractrooms();

    }

    private void openDialog() {
        BookingDialog bookingDialog = new BookingDialog();
        bookingDialog.show(getSupportFragmentManager(),"booking");


    }

    private void extractrooms() {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlbuilder;
        urlbuilder = HttpUrl.parse(Host.URL + "/chambre/?hotel__id="+hotel_id).newBuilder();
        String url = urlbuilder.build().toString();
        Log.i("====HOTELID=====", url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                RoomActivity.this.runOnUiThread(() -> {
                    Toast.makeText(RoomActivity.this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
                    Log.i("=====CHAMBRE=====",e.getMessage());
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String json = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray results = jsonObject.getJSONArray("results");
                    Room room;
                    for (int i=0; i<results.length(); i++) {
                        JSONObject item = results.getJSONObject(i);
                        room = new Room(
                                item.getString("numero"),
                                item.getString("nbre_personnes"),
                                item.getString("prix"),
                                item.getString("pic_chambr1"),
                                item.getString("pic_chambr2"),
                                item.getString("pic_chambr3"),
                                item.getString("hotel"),
                                item.getString("type_chambre")

                        );
                        Log.i("======CHAMBRE========", "RESPONSE CHAMBRE");
                            rooms.add(room);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}