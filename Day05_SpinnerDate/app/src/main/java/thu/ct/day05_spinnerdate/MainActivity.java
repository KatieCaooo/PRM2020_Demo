package thu.ct.day05_spinnerdate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Spinner spNationality;
    private TextView txtBirthday;
    private String selectedNationality;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBirthday = findViewById(R.id.txtBirthday);
        spNationality = findViewById(R.id.spNationality);
        List<String> dataSource = new ArrayList<>();
        dataSource.add("A");
        dataSource.add("B");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, dataSource);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNationality.setAdapter(dataAdapter);
        spNationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedNationality = parent.getItemAtPosition(position).toString();
//                selectedNationality = spNationality.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void clickToRegister(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("birthday", txtBirthday.getText().toString());
        bundle.putString("nationality", selectedNationality);
        Intent intent = new Intent(this, ShowActivity.class);
        intent.putExtra("INFO", bundle);
        startActivity(intent);
    }

    public void clickToGetDate(View view) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getFragmentManager(), "Date Picker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String result = dayOfMonth + "/" + (month + 1) + "/" + year;
        txtBirthday.setText(result);

    }
}
