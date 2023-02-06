package com.example.become;

import java.util.Arrays;

public class WorkoutPlanManager {
    static String[] productivePlan = {"Work for 2 hours", "Go to bed", "Take a break", "Go take a 10 minute walk", "Take 5 minute break and stretch", "Drink Water", "Do 15 jumping jacks"};
    static String[] happyPlan = {"Do some YOGA", "Take 5 minutes to meditate", "Take a walk", "Stand Up for 5 minutes", "Take a nap", "Do 10 mountain climbers", "10 pushups"};
    static String[] lowIntensityWorkout = {"5 pushups", "20 second plank", "3 burpees", "10 squats", "Do 5 situps", "Do 5 lunges", "15 knee pushups"};
    static String[] pushupPlan = {"10 pushups in 2 intervals(take 3 min break)", "3 sets of 8 reverse pushups", "3-5 diamond pushups", "30 squats", "Incline Pushup", "Tricep Dips", "Bicep Curl something"};
    static String[] plankPlan = {"One Push-up", "One Push-up", "Leg Raises, Bent knee", "30 squats", "10 pushups", "Calf Raises", "Side Plank"};
    static String[] snankCutPlan = {"Stay Hydrated", "Take a 10 minute walk", "Stay Hydrated", "Do 10 pushups", "30 squats", "30 second plank", "10 situps"};

    public static int workoutMaker(){
        Integer[] code = Questionnaire.values.toArray(new Integer[0]);
        int workoutPlan = 0;
        if(code[0]==1){
            if (code[1] < 2) {
                workoutPlan = 1;
            }
            if (code[2] < 2) {
                workoutPlan = 2;
            }
            if (code[3] > 3) {
                workoutPlan = 3;
            }
        }
        else if (code[0] == 2 || code[0] == 3) {
            Integer[] lastthree = Arrays.copyOfRange(code, code.length - 3, code.length);
            int last3dig = 0;
            for(int i=0;i<lastthree.length;i++) {
                last3dig = last3dig*10+lastthree[i];
            }
            if (last3dig == 113 || last3dig == 133 || last3dig == 223 || last3dig == 233 || last3dig == 313 || last3dig == 323) {
                workoutPlan = 4;
            }

            else if (last3dig == 112 || last3dig == 132 ||last3dig ==  222 ||last3dig== 232||last3dig== 312|| last3dig == 322   ) {
                workoutPlan = 5;
            }
            else {
                workoutPlan = 6;
            }
        }
        return workoutPlan;
    }
}
