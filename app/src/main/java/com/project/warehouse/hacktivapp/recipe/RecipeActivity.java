package com.project.warehouse.hacktivapp.recipe;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.model.Recipe;
import com.project.warehouse.hacktivapp.version.SecondActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeActivity extends AppCompatActivity {

    private RecipeAdapter adapter;
//    RecyclerView recyclerView;

    AppCompatButton sendNotif;

    private String channelId = "important_mail_channel";
    private int notifId = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        sendNotif = findViewById(R.id.ui_view_send_notif);
        sendNotif.setOnClickListener(v -> sendNotification());

        createNotificationChannel();

//        recyclerView = findViewById(R.id.ui_view_recyclerview);
//        adapter = new RecipeAdapter();
//        recyclerView.setAdapter(adapter);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);

//        showRecipes();


    }

    private void sendNotification() {
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://c1ctech.com/"));
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification notification = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_email)
                .setContentTitle("Hey, you!")
                .setContentText("Long time no see you")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notifId, notification);

        notifId++;
    }

    private void showRecipes() {
        Recipe croisant = new Recipe("https://blue.kumparan.com/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1531733399/ho7neioln8p6aotiukpz.jpg", "Crunch croisant",
                                     "Butterfly, flaky pastry named for its crescent shape");

        Recipe grilled = new Recipe("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/190411-grilled-eggplant-horizontal-1555703432.png", "Grilled eggplant",
                                     "Butterfly, flaky pastry named for its crescent shape");

        Recipe tangerine = new Recipe("https://static.onecms.io/wp-content/uploads/sites/44/2016/06/03/8527499.jpg", "Tangerine salad",
                                    "Butterfly, flaky pastry named for its crescent shape");

        List<Recipe> list = new ArrayList<>();
        list.add(croisant);
        list.add(grilled);
        list.add(tangerine);

        adapter.setItems(list);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelName = "important_mail_channel";
            String channelDesc = "This channel will show notif";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
            channel.setDescription(channelDesc);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
    }
}