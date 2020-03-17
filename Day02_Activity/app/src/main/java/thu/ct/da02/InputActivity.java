package thu.ct.da02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
private EditText edtUsername, edtAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        edtUsername = findViewById(R.id.edtUsername);
        edtAge = findViewById(R.id.edtAge);
    }
    public void clickToDone(View view){
//        Intent intent = new Intent(this, MainActivity.class);
        Intent intent = this.getIntent();
        String username = edtUsername.getText().toString();
        int age = Integer.parseInt(edtAge.getText().toString());
        intent.putExtra("username", username);
        intent.putExtra("age", age);
//        startActivity(intent);
        this.setResult(RESULT_OK, intent);
        finish();

    }
}
