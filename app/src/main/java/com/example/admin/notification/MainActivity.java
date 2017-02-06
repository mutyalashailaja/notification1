package com.example.admin.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button InboxstyleNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InboxstyleNotification=(Button)findViewById(R.id.button);
        InboxstyleNotification.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent resultIntent = new Intent(this, ResultActivity.class);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent piResult = PendingIntent.getActivity(this, 0, resultIntent, 0);
        Notification.Builder builder=new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("contentTitle")
                .setContentText("contentText")
                .setContentIntent(piResult);
        Notification notification = new Notification.InboxStyle(builder)
                .addLine("hi")
                .addLine("hello")
                .addLine("how r u?")
                .addLine("howz life?")
                .setBigContentTitle("Here Your Messages")
                .setSummaryText("+3 more")
                .build();
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(121,notification);
    }
}
