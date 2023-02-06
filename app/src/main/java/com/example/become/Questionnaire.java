package com.example.become;

import static android.app.PendingIntent.FLAG_IMMUTABLE;
import static android.app.PendingIntent.FLAG_MUTABLE;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class Questionnaire extends AppCompatActivity {

    int click = 0;
    TextView question;
    Button submit;
    RadioButton option1;
    RadioButton option2;
    RadioButton option3;
    static ArrayList<Integer> values = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        question = (TextView) findViewById(R.id.question);
        submit = (Button) findViewById(R.id.submit_button);
        option1 = (RadioButton) findViewById(R.id.radioButton);
        option2 = (RadioButton) findViewById(R.id.radioButton2);
        option3 = (RadioButton) findViewById(R.id.radioButton3);

//        if (ContextCompat.checkSelfPermission(getApplicationContext(),
//                Manifest.permission.ACCESS_NOTIFICATION_POLICY)
//                != PackageManager.PERMISSION_GRANTED) {
            int requestcode = 0;
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, requestcode);
//        }


        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        int currentWorkout = sh.getInt("currentWorkout", 1);
        SharedPreferences.Editor editor = sh.edit();

        Intent alarmIntent1 = new Intent(getApplicationContext(), MyBroadcastReceiver.class);
        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(getApplicationContext(), 1, alarmIntent1, FLAG_IMMUTABLE);

        Intent alarmIntent2 = new Intent(getApplicationContext(), MyBroadcastReceiver.class);
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(getApplicationContext(), 2, alarmIntent2, FLAG_IMMUTABLE);

        Intent alarmIntent3 = new Intent(getApplicationContext(), MyBroadcastReceiver.class);
        PendingIntent pendingIntent3 = PendingIntent.getBroadcast(getApplicationContext(), 3, alarmIntent3, FLAG_IMMUTABLE);

        Intent alarmIntent4 = new Intent(getApplicationContext(), MyBroadcastReceiver.class);
        PendingIntent pendingIntent4 = PendingIntent.getBroadcast(getApplicationContext(), 4, alarmIntent4, FLAG_IMMUTABLE);

        Intent alarmIntent5 = new Intent(getApplicationContext(), MyBroadcastReceiver.class);
        PendingIntent pendingIntent5 = PendingIntent.getBroadcast(getApplicationContext(), 5, alarmIntent5, FLAG_IMMUTABLE);

        Intent alarmIntent6 = new Intent(getApplicationContext(), MyBroadcastReceiver.class);
        PendingIntent pendingIntent6 = PendingIntent.getBroadcast(getApplicationContext(), 6, alarmIntent6, FLAG_IMMUTABLE);

        Intent alarmIntent7 = new Intent(getApplicationContext(), MyBroadcastReceiver.class);
        PendingIntent pendingIntent7 = PendingIntent.getBroadcast(getApplicationContext(), 7, alarmIntent7, FLAG_IMMUTABLE);

        AlarmManager manager1 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(System.currentTimeMillis());
        calendar1.set(Calendar.HOUR_OF_DAY, 11);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 1);

        manager1.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar1.getTimeInMillis(), 60000, pendingIntent1);

        AlarmManager manager2 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        calendar2.set(Calendar.HOUR_OF_DAY, 13);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 1);

        manager2.setRepeating(AlarmManager.RTC_WAKEUP, calendar2.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent2);

        AlarmManager manager3 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTimeInMillis(System.currentTimeMillis());
        calendar3.set(Calendar.HOUR_OF_DAY, 15);
        calendar3.set(Calendar.MINUTE, 0);
        calendar3.set(Calendar.SECOND, 1);

        manager3.setRepeating(AlarmManager.RTC_WAKEUP, calendar3.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent3);

        AlarmManager manager4 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTimeInMillis(System.currentTimeMillis());
        calendar4.set(Calendar.HOUR_OF_DAY, 17);
        calendar4.set(Calendar.MINUTE, 0);
        calendar4.set(Calendar.SECOND, 1);

        manager4.setRepeating(AlarmManager.RTC_WAKEUP, calendar4.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent4);

        AlarmManager manager5 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Calendar calendar5 = Calendar.getInstance();
        calendar5.setTimeInMillis(System.currentTimeMillis());
        calendar5.set(Calendar.HOUR_OF_DAY, 18);
        calendar5.set(Calendar.MINUTE, 0);
        calendar5.set(Calendar.SECOND, 1);

        manager5.setRepeating(AlarmManager.RTC_WAKEUP, calendar5.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent5);

        AlarmManager manager6 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Calendar calendar6 = Calendar.getInstance();
        calendar6.setTimeInMillis(System.currentTimeMillis());
        calendar6.set(Calendar.HOUR_OF_DAY, 19);
        calendar6.set(Calendar.MINUTE, 0);
        calendar6.set(Calendar.SECOND, 1);

        manager6.setRepeating(AlarmManager.RTC_WAKEUP, calendar6.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent6);

        AlarmManager manager7 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Calendar calendar7 = Calendar.getInstance();
        calendar7.setTimeInMillis(System.currentTimeMillis());
        calendar7.set(Calendar.HOUR_OF_DAY, 20);
        calendar7.set(Calendar.MINUTE, 0);
        calendar7.set(Calendar.SECOND, 1);

        manager7.setRepeating(AlarmManager.RTC_WAKEUP, calendar7.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent7);

        Calendar currentTime = Calendar.getInstance();
        int currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
        currentTime.set(Calendar.HOUR_OF_DAY, currentHour);

        boolean alarmUp = (PendingIntent.getBroadcast(this, 8,
                new Intent("com.example.become"),
                FLAG_IMMUTABLE) != null);

        if (alarmUp) {
            Log.d("myTag", "Alarm is already active");
        }




        if(currentTime.after(calendar1) && currentTime.before(calendar2)){
            editor.putInt("currentWorkout", 1);
            Log.d("Tag", "Work");
        }
        else if(currentTime.after(calendar2) && currentTime.before(calendar3)){
            editor.putInt("currentWorkout", 2);
            Log.d("Tag", "Work");

        }
        else if(currentTime.after(calendar3) && currentTime.before(calendar4)){
            editor.putInt("currentWorkout", 3);
            Log.d("Tag", "Work");

        }
        else if(currentTime.after(calendar4) && currentTime.before(calendar5)){
            editor.putInt("currentWorkout", 4);
            Log.d("Tag", "Work");

        }
        else if(currentTime.after(calendar5) && currentTime.before(calendar6)){
            editor.putInt("currentWorkout", 5);
            Log.d("Tag", "Work");

        }
        else if(currentTime.after(calendar6) && currentTime.before(calendar7)){
            editor.putInt("currentWorkout", 6);
            Log.d("Tag", "Work");

        }
        else if(currentTime.after(calendar7) && currentTime.before(calendar1)){
            editor.putInt("currentWorkout", 7);
            Log.d("Tag", "Work");

        }
        else{
            Log.d("Tag", "Didn't Work");
        }

        editor.commit();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option1.isChecked() == true) {
                    values.add(1);
                }
                if (option2.isChecked() == true) {
                    values.add(2);
                }
                if (option3.isChecked() == true) {
                    values.add(3);
                }
                option1.setChecked(false);
                option2.setChecked(false);
                option3.setChecked(false);
                ++click;

                if (click < 4) {
                    questionOrganizer();
                }
                else {
                    Intent intent = new Intent(Questionnaire.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void questionOrganizer(){
        int currentOption = values.get(click-1);
        int pathway = values.get(0);
        if(click == 1){
            if(currentOption == 1){
                question.setText("How many pushups can you do? ");
                option1.setText("Less Than 5");
                option2.setText("5 to 10");
                option3.setText("More Than 10");
            }
            else {
                question.setText("What are you currently?");
                option1.setText("A Student");
                option2.setText("A Employee");
                option3.setText("No Occupation / Other");
            }
        }
        else if (click == 2){
            if(pathway == 1){
                question.setText("How long can you hold a plank?");
                option1.setText("Less than 30 seconds");
                option2.setText("30 to 90 seconds");
                option3.setText("More than 90 seconds");
            }
            else{
                if(currentOption == 1){
                    question.setText("What is causing you stress as an student?");
                    option1.setText("Assignments from school");
                    option2.setText("Social life in school");
                    option3.setText("Tests from school");
                }
                else if (currentOption == 2){
                    question.setText("What is causing you stress as a employee");
                    option1.setText("Other co-workers not fitting");
                    option2.setText("Excessive Workload");
                    option3.setText("Poor time-management");
                }
                else if (currentOption == 3){
                    question.setText("What you causing you stress");
                    option1.setText("Stress from close friends and family");
                    option2.setText("Stress from world events");
                    option3.setText("Not listed");
                }
            }
        }
        else if (click == 3){
            if (pathway == 1){
                question.setText("What is your eating habit like?");
                option1.setText("A lot of processed food and snacking");
                option2.setText("Cooking at home, and a bit of snacking");
                option3.setText("Minimal eating and mostly food from outside");
            }
            else{
                question.setText("What do you want to achieve with this app?");
                option1.setText("I want to reduce my weight");
                option2.setText("I want to become happier");
                option3.setText("I want to be more productive");
            }
        }
    }

}