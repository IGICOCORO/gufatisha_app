package bi.guymichel.gufatisha_app.Dialogs;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Calendar;

import bi.guymichel.gufatisha_app.Models.Room;
import bi.guymichel.gufatisha_app.R;
import bi.guymichel.gufatisha_app.RoomActivity;

public class BookingDialog extends AppCompatDialogFragment {
    private final Room room;
    TextView txt_value_date_debut ;
    TextView txt_value_date_fin;
    EditText field_firstname, field_lastname, field_email, field_phone, field_provenance;
    Context context;
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
