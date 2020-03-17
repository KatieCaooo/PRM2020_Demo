package thu.ct.day08_notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDetailNotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail_notification);
        TextView txtResult = findViewById(R.id.txtResult);
        Intent intent = this.getIntent();
        String result = intent.getStringExtra("username");
        txtResult.setText("Username: " + result);
    }
}
