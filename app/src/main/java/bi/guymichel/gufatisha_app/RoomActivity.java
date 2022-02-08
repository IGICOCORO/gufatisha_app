package bi.guymichel.gufatisha_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Adapters.AdapterHome;
import bi.guymichel.gufatisha_app.Adapters.AdapterRoom;
import bi.guymichel.gufatisha_app.Models.Room;

public class RoomActivity extends AppCompatActivity {
    RecyclerView roomlist;
    AdapterRoom adapter;
    private ArrayList<Room> rooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        roomlist = findViewById(R.id.roomlist);
        adapter = new AdapterRoom(R.layout.card_room, this, rooms);
        roomlist.setAdapter(adapter);
        extractrooms();

    }

    private void extractrooms() {
    }
}