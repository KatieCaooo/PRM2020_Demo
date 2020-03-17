package thu.ct.day04_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToSub(View view) {
        EditText edtNumber1 = findViewById(R.id.edtNumber1);
        EditText edtNumber2 = findViewById(R.id.edtNumber2);
        int result = Integer.parseInt(edtNumber1.getText().toString()) - Integer.parseInt(edtNumber2.getText().toString());
        TextView txtResult = findViewById(R.id.txtResult);
        txtResult.setText("Result = "+result);
    }
}
