package com.example.become;

import static android.content.Context.MODE_PRIVATE;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class CompletedTask extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        SharedPreferences sh = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sh.edit();
        int currentWorkout = sh.getInt("currentWorkout", 1);
        boolean canCompleteTask = sh.getBoolean("canCompleteTask", true);
        editor.putBoolean("canCompleteTask", false);
        if(currentWorkout ==7){
            editor.putInt("currentWorkout", 1);
        }
        else{
            editor.putInt("currentWorkout", currentWorkout+1);
        }
        editor.apply();
    }
}
