package bi.guymichel.gufatisha_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import bi.guymichel.gufatisha_app.Adapters.AdapterHome;
import bi.guymichel.gufatisha_app.Adapters.AdapterRoom;
import bi.guymichel.gufatisha_app.Models.Room;

public class RoomActivity extends AppCompatActivity {
    RecyclerView roomlist;
    AdapterRoom adapter;
    Button btn_booking;
    private ArrayList<Room> rooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        roomlist = findViewById(R.id.roomlist);
        adapter = new AdapterRoom(R.layout.card_room, this, rooms);
        roomlist.setAdapter(adapter);
        btn_booking = findViewById(R.id.btn_booking);
        btn_booking.setOnClickListener(v -> openDialog());
        extractrooms();

    }

    private void openDialog() {
        BookingDialog bookingDialog = new BookingDialog();
        bookingDialog.show(getSupportFragmentManager(),"booking");


    }

    private void extractrooms() {
    }
}