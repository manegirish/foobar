package com.sagesurfer.collaborativecares;

public class LovelyLuckyLambs {

    public static int lovely_lucky_lambs(int total_lambs) {
        return stingy(total_lambs) - generous(total_lambs);
    }

    private static int generous(int total_lambs) {
        if (total_lambs < 1) {
            return 0;
        }
        int henchmen_number = 1;
        int lamb_allowance = 1;
        int current_lambs = total_lambs - lamb_allowance;

        while (current_lambs > 0) {
            lamb_allowance *= 2;
            current_lambs -= lamb_allowance;
            if (current_lambs >= 0) {
                henchmen_number++;
            }
        }

        return henchmen_number;
    }

    private static int stingy(int total_lambs) {
        if (total_lambs < 1) {
            return 0;
        }
        int henchmen_number = 1;
        int extreme_last_allowance = 1;
        int current_lambs = total_lambs - extreme_last_allowance;
        if (current_lambs < 1) {
            return henchmen_number;
        }
        int last_allowance = 1;
        current_lambs -= last_allowance;
        henchmen_number++;

        int lamb_allowance = 0;

        while (current_lambs > 0) {
            lamb_allowance = last_allowance + extreme_last_allowance;
            current_lambs -= lamb_allowance;
            if (current_lambs >= 0) {
                henchmen_number++;
                extreme_last_allowance = last_allowance;
                last_allowance = lamb_allowance;
            }
        }
        return henchmen_number;
    }
}