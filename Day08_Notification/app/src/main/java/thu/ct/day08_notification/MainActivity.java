package thu.ct.day08_notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private NotificationManager notificationManager;
    private int notiID = 909;
    private int numMsg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToSendNotification(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("New Message");
        builder.setContentText("Message has received");
        builder.setTicker("Message Alert");
        builder.setSmallIcon(R.drawable.ic_action_unread);
        builder.setNumber(++numMsg);

        Intent intent = new Intent(this, ShowDetailNotificationActivity.class);
        intent.putExtra("username", "hahaha");

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent =
                taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notiID,builder.build());
    }

    public void clickToCancel(View view) {
        notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(notiID);
    }

    public void clickToSendMultiple(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("New Message");
        builder.setContentText("Message has received");
        builder.setTicker("Message Alert");
        builder.setSmallIcon(R.drawable.ic_action_unread);
        builder.setNumber(++numMsg);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] event={"hahaha", "abc", "llala"};
        for(int i=0; i<event.length; i++){
            inboxStyle.addLine(event[i]);
        }
        builder.setStyle(inboxStyle);

        Intent intent = new Intent(this, ShowDetailNotificationActivity.class);
        intent.putExtra("username", "hahaha");

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent =
                taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notiID,builder.build());
    }
}
