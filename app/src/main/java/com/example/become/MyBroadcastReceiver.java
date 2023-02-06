package com.example.become;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Context.NOTIFICATION_SERVICE;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Calendar;

public class MyBroadcastReceiver extends BroadcastReceiver {
    int currentWorkout;
    int workoutPlan;
    boolean canCompleteTask;
    int weeklyWorkout;
    static public String TAG="Broadcast Receiver";
    @Override
    public void onReceive(Context context, Intent intent){
        Log.d(TAG, "It working!");


        Calendar firstNotification = Calendar.getInstance();
        firstNotification.set(Calendar.HOUR, 11);
        firstNotification.set(Calendar.MINUTE, 0);
        firstNotification.set(Calendar.SECOND, 0);

        Calendar secondNotification = Calendar.getInstance();
        secondNotification.set(Calendar.HOUR, 11);
        secondNotification.set(Calendar.MINUTE, 0);
        secondNotification.set(Calendar.SECOND, 25);

        Calendar timeRightNow = Calendar.getInstance();
        timeRightNow.getTimeInMillis();
        String[] plan = null;

        SharedPreferences sh = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sh.edit();
        workoutPlan = sh.getInt("workoutPlan", 0);
        currentWorkout = sh.getInt("currentWorkout", 1);
        canCompleteTask = sh.getBoolean("canCompleteTask", true);

        if(timeRightNow.after(firstNotification)  && timeRightNow.before(secondNotification)){
            editor.putInt("currentWorkout", 1);
        }
        else if(canCompleteTask){
            currentWorkout = currentWorkout + 1;
            editor.putInt("currentWorkout", currentWorkout);
        }
        editor.putBoolean("canCompleteTask", true);
        editor.commit();
        switch (workoutPlan){
            case 1:
                plan = WorkoutPlanManager.pushupPlan;
                break;
            case 2:
                plan = WorkoutPlanManager.plankPlan;
                break;
            case 3:
                plan = WorkoutPlanManager.snankCutPlan;
                break;
            case 4:
                plan = WorkoutPlanManager.productivePlan;
                break;
            case 5:
                plan = WorkoutPlanManager.happyPlan;
                break;
            case 6:
                plan = WorkoutPlanManager.lowIntensityWorkout;
                break;
        }





        String currentTask = (plan[currentWorkout-1]+"");
        Intent completeTask = new Intent(context, CompletedTask.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 2, completeTask, PendingIntent.FLAG_IMMUTABLE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Alarm Notification", "Alarm Notification", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Alarm Notification");
        builder.setContentTitle("Workout Time!");
        builder.setContentText(currentTask);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setSmallIcon(R.drawable.sigma_logo_notifcation_edition);
        builder.setAutoCancel(true);
        builder.addAction(R.drawable.sigma_logo_notifcation_edition, "Mark Completed", pendingIntent);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(1, builder.build());

        Intent intent2 = new Intent();
        intent2.setAction("com.example.become.ACTION");
        intent2.putExtra("change", true);
        context.sendBroadcast(intent2);
    }
}