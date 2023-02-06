package com.example.become;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class history extends AppCompatActivity {
    TextView done, notDone;
    PieChart pieChart;
    int weeklyWorkout, currentWorkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        //variable names soon to be changed
        done = findViewById(R.id.notDone);
        notDone = findViewById(R.id.done);
        pieChart = findViewById(R.id.piechart);
        Button back = findViewById(R.id.backMain);
        SharedPreferences thing= this.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        weeklyWorkout=thing.getInt("weeklyWorkout", 0);

        setData(weeklyWorkout);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(history.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setData(int d){

        done.setText(Integer.toString(d));
        notDone.setText(Integer.toString(49-d));
        int doneNum=d/49*100+1;
        int notDoneNum=100-doneNum;
        Log.d("percent", Integer.toString(doneNum));
        pieChart.addPieSlice(
                new PieModel(
                        "Completed",
                        doneNum,
                        Color.parseColor("#00FF00")));
        pieChart.addPieSlice(
                new PieModel(
                        "Not Completed",
                        notDoneNum,
                        Color.parseColor("#808080")));

    }


}