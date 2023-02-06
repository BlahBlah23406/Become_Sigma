package com.example.become;

import static android.content.Context.MODE_PRIVATE;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class CompletedTask extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Log.d("Button Receiver", "Why are you so stupid");
        SharedPreferences sh = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sh.edit();
        int currentWorkout = sh.getInt("currentWorkout", 1);
        int weeklyWorkout = sh.getInt("weeklyWorkout", 0);
        boolean canCompleteTask = sh.getBoolean("canCompleteTask", true);
        editor.putBoolean("canCompleteTask", false);
        if(currentWorkout ==7){
            editor.putInt("currentWorkout", 1);
        }
        else{
            editor.putInt("currentWorkout", currentWorkout+1);
            editor.putInt("weeklyWorkout", weeklyWorkout + 1);

        }
        editor.apply();

        Intent intent2 = new Intent();
        intent2.setAction("com.example.become.ACTION");
        intent2.putExtra("change", true);
        context.sendBroadcast(intent2);
    }
}
