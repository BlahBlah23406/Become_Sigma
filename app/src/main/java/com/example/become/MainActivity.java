package com.example.become;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView task1; TextView task2; TextView task3; TextView task4; TextView task5; TextView task6;
    Button currentTask;
    int currentWorkout;
    int workoutPlan;
    SharedPreferences.Editor editor;
    boolean canCompleteTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        task1 = findViewById(R.id.task1);
        task2 = findViewById(R.id.task2);
        task3 = findViewById(R.id.task3);
        task4 = findViewById(R.id.task4);
        task5 = findViewById(R.id.task5);
        task6 = findViewById(R.id.task6);
        currentTask = findViewById(R.id.currentTask);



        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        boolean hasUsedAppOnceBefore = sh.getBoolean("usedAppFirstTime", true);
        workoutPlan = sh.getInt("workoutPlan", 0);
        currentWorkout = sh.getInt("currentWorkout", 1);
        canCompleteTask = sh.getBoolean("canCompleteTask", true);
        editor = sh.edit();
        if(hasUsedAppOnceBefore){
            editor.putBoolean("usedAppFirstTime", false);
            editor.commit();
            Intent intent = new Intent(MainActivity.this, Questionnaire.class);
            startActivity(intent);
        }
        else{
            if(workoutPlan == 0) {
                workoutPlan = WorkoutPlanManager.workoutMaker();
                editor.putInt("workoutPlan", workoutPlan);
                editor.commit();
            }
            textSetting();
            currentTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(canCompleteTask){
                        currentWorkout = currentWorkout+1;
                        canCompleteTask = false;
                        editor.putInt("currentWorkout", currentWorkout);
                        editor.putBoolean("canCompleteTask", canCompleteTask);
                        editor.commit();
                        textSetting();
                    }
                    else{
                        //Add Toast Message
                    }
                }
            });
        }
    }

    public void textSetting(){
        String[] plan = null;
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
        currentTask.setText(plan[currentWorkout-1]+"");
        if(currentWorkout < 7){
            task1.setText(plan[currentWorkout]+"");
        }
        else {
            task1.setVisibility(View.INVISIBLE);
        }
        if(currentWorkout < 6){
            task2.setText(plan[currentWorkout+1]+"");
        }
        else{
            task2.setVisibility(View.INVISIBLE);
        }
        if(currentWorkout < 5){
            task3.setText(plan[currentWorkout+2]+"");
        }
        else{
            task3.setVisibility(View.INVISIBLE);
        }
        if(currentWorkout < 4){
            task4.setText(plan[currentWorkout+3]+"");
        }
        else{
            task4.setVisibility(View.INVISIBLE);
        }if(currentWorkout < 3){
            task5.setText(plan[currentWorkout+4]+"");
        }
        else{
            task5.setVisibility(View.INVISIBLE);
        }
        if(currentWorkout < 2){
            task6.setText(plan[currentWorkout+5]+"");
        }
        else{
            task6.setVisibility(View.INVISIBLE);
        }
    }
}