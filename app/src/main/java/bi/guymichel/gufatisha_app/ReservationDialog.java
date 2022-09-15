package bi.guymichel.gufatisha_app;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Calendar;

public class ReservationDialog extends AppCompatDialogFragment {
    TextView txt_value_date_debut ;
    TextView txt_value_date_fin;
    final Calendar myCalendar= Calendar.getInstance();
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState,Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_register,null);
        txt_value_date_debut = view.findViewById(R.id.txt_value_date_debut);
        txt_value_date_fin = view.findViewById(R.id.txt_value_date_fin);

        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }

            private void updateLabel() {
            }
        };
        txt_value_date_debut.setOnClickListener(v -> {
            new DatePickerDialog(context,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            Log.i("===DEBUT TAPPED====", "onCreateDialog: ");
        });
        txt_value_date_fin.setOnClickListener(v ->{
            new DatePickerDialog(context,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            Log.i("===FIN TAPPED====", "onCreateDialog: ");
        });
        builder.setView(view);
        return builder.create();
    }

}
