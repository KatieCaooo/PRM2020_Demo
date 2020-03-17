package thu.ct.da02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtResult;
    private static int INPUT_REQUEST = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);
//        Intent intent = this.getIntent();
//        String username = intent.getStringExtra("username");
//        int age = intent.getIntExtra("age",0);
//        txtResult.setText("Username: " + username +" - Age: "+age);
    }

    public void clickToInputData(View view){
        Intent intent = new Intent(this, InputActivity.class);
//        startActivity(intent);
        startActivityForResult(intent, INPUT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == INPUT_REQUEST){
            if (resultCode == RESULT_OK){
                String username = data.getStringExtra("username");
                int age = data.getIntExtra("age", 0);
                txtResult.setText("Username: "+username+" - Age: "+age);
            }
        }
    }
}
