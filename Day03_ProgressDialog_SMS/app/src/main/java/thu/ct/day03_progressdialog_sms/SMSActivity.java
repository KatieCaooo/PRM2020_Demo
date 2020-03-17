package thu.ct.day03_progressdialog_sms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {
    private EditText edtPhone, edtContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        edtContent = findViewById(R.id.edtContent);
        edtPhone = findViewById(R.id.edtPhone);
    }
    public void clickToSend (View view){
        String phoneNo = edtPhone.getText().toString();
        String content = edtContent.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        Intent intent = new Intent("Send_SMS_Hello");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg = "Send OK";
                if (result != Activity.RESULT_OK){
                    msg = "Send FAIL!";
                }
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

            }
        }, new IntentFilter("Send_SMS_Hello"));
        smsManager.sendTextMessage(phoneNo,null, content,pendingIntent,null);
        finish();
    }
}
