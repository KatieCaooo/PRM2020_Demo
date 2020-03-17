package thu.ct.day09_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView txtResult = findViewById(R.id.txtResult);
        Intent intent = this.getIntent();
        String id = intent.getStringExtra("id");
        txtResult.setText(id);
    }
}
