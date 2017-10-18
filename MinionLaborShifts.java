package com.sagesurfer.collaborativecares;

import java.util.ArrayList;

public class MinionLaborShifts {

    public static int[] answer(int[] data, int n) {
        if (n == 0) {
            return new int[0];
        }
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int aData1 : data) {
            int nTimes = 0;
            for (int aData : data) {
                if (aData == aData1) {
                    nTimes++;
                }
            }
            if (nTimes <= n) {
                integerArrayList.add(aData1);
            }
        }
        int[] final_list = new int[integerArrayList.size()];

        for (int index = 0; index < integerArrayList.size(); index++) {
            final_list[index] = integerArrayList.get(index);
        }
        for (int aFinal_list : final_list) {
            System.out.println(aFinal_list);
        }
        return final_list;
    }
}