package com.example.become;

import java.util.Arrays;

public class WorkoutPlanManager {
    static String[] productivePlan = {"One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup"};
    static String[] happyPlan = {"One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup"};
    static String[] lowIntensityWorkout = {"One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup"};
    static String[] pushupPlan = {"One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup"};
    static String[] plankPlan = {"One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup"};
    static String[] snankCutPlan = {"One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup", "One Pushup"};

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
