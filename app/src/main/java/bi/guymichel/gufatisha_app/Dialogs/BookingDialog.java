package bi.guymichel.gufatisha_app.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Calendar;

import bi.guymichel.gufatisha_app.Fragments.ReservationFragment;
import bi.guymichel.gufatisha_app.Host;
import bi.guymichel.gufatisha_app.Models.Reservation;
import bi.guymichel.gufatisha_app.Models.Room;
import bi.guymichel.gufatisha_app.R;
import bi.guymichel.gufatisha_app.RoomActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class BookingDialog extends AppCompatDialogFragment {
    private final Room room;
    TextView txt_value_date_debut ;
    TextView txt_value_date_fin;
    EditText field_firstname, field_lastname, field_email, field_phone, field_provenance;
    RoomActivity context;
    Button btn_register_submit;
    Button btn_register_cancel;
    final Calendar calendar_debut= Calendar.getInstance();
    final Calendar calendar_fin= Calendar.getInstance();

    public BookingDialog(RoomActivity roomActivity, Room room) {
        this.context = roomActivity;
        this.room = room;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_register,null);
        txt_value_date_debut = view.findViewById(R.id.txt_value_date_debut);
        txt_value_date_fin = view.findViewById(R.id.txt_value_date_fin);

        field_firstname = view.findViewById(R.id.field_firstname);
        field_lastname = view.findViewById(R.id.field_lastname);
        field_email = view.findViewById(R.id.field_email);
        field_phone = view.findViewById(R.id.field_phone);
        field_provenance = view.findViewById(R.id.field_provenance);

        btn_register_submit = view.findViewById(R.id.btn_register_submit);
        btn_register_submit.setOnClickListener(button -> {
            this.registerReservation();
        });
        btn_register_cancel = view.findViewById(R.id.btn_register_cancel);
        btn_register_cancel.setOnClickListener(button -> {
            BookingDialog.this.dismiss();
        });


        DatePickerDialog.OnDateSetListener date_debut =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar_debut.set(Calendar.YEAR, year);
                calendar_debut.set(Calendar.MONTH,month);
                calendar_debut.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };

        DatePickerDialog.OnDateSetListener date_fin =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar_fin.set(Calendar.YEAR, year);
                calendar_fin.set(Calendar.MONTH,month);
                calendar_fin.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        txt_value_date_debut.setOnClickListener(v -> {
            new DatePickerDialog(
                    context,
                    date_debut,
                    calendar_debut.get(Calendar.YEAR),
                    calendar_debut.get(Calendar.MONTH),
                    calendar_debut.get(Calendar.DAY_OF_MONTH)
            ).show();
            Log.i("===DEBUT TAPPED====", "onCreateDialog: ");
        });
        txt_value_date_fin.setOnClickListener(v ->{
            new DatePickerDialog(
                    context,
                    date_fin,
                    calendar_fin.get(Calendar.YEAR),
                    calendar_fin.get(Calendar.MONTH),
                    calendar_fin.get(Calendar.DAY_OF_MONTH)
            ).show();
            Log.i("===FIN TAPPED====", "onCreateDialog: ");
        });
        builder.setView(view);
        return builder.create();
    }

    private void registerReservation() {
        String date_debut = calendar_debut.get(Calendar.YEAR)+"-"
                + calendar_debut.get(Calendar.MONTH)+"-"
                + calendar_debut.get(Calendar.DAY_OF_MONTH);
        String date_fin = calendar_fin.get(Calendar.YEAR)+"-"
                + calendar_fin.get(Calendar.MONTH)+"-"
                + calendar_fin.get(Calendar.DAY_OF_MONTH);
        String firstname = field_firstname.getText().toString();
        String lastname = field_lastname.getText().toString();
        String email = field_email.getText().toString();
        String phone = field_phone.getText().toString();
        String provenance = field_provenance.getText().toString();

        String json_reservation = "\"{"+
            "\"client\": {"+
                    "\"nom\": \""+firstname+"\","
                    + "\"prenom\": \""+lastname+"\","
                    + "\"provenance\": \""+provenance+"\","
                    + "\"phone\": \""+"\""+phone+"\","
                    + "\"email\": \""+email+"\","
            +"},"
            +"\"date_arrivee\": \""+date_debut+"\","
            +"\"date_depart\": \""+date_fin+"\","
            +"\"chambre\": \""+room.numero.toString()+"\""
        +"}";
        RequestBody body = RequestBody.create(json_reservation, MediaType.parse("application/json; charset=utf-8"));

        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Host.URL + "/Reservation/").newBuilder();

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
//                .header("Authorization", "Token "+context.token)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                try {
                    JSONObject json_obj = new JSONObject(json);
                    final Reservation res = new Reservation(
                            json_obj.getString("id"),
                            json_obj.getString("date_arrivee"),
                            json_obj.getString("date_depart"),
                            json_obj.getString("client"),
                            json_obj.getString("prix_chambre"),
                            json_obj.getString("numero_chambre")
                    );
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ReservationFragment.pushReservation(res);
                        }
                    });
                    BookingDialog.this.dismiss();
                } catch (JSONException e) {
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "Ajout échouée", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private void updateLabel() {
        String date_debut = calendar_debut.get(Calendar.DAY_OF_MONTH)+"/"
                +calendar_debut.get(Calendar.MONTH)+"/"+
                calendar_debut.get(Calendar.YEAR);

        String date_fin = calendar_fin.get(Calendar.DAY_OF_MONTH)+"/"
                +calendar_fin.get(Calendar.MONTH)+"/"+
                calendar_fin.get(Calendar.YEAR);

        this.txt_value_date_debut.setText(date_debut);
        this.txt_value_date_fin.setText(date_fin);
    }
}
