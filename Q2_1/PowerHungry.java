package com.sagesurfer.collaborativecares;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PowerHungry {

    public static String answer(int[] xs) {
        List<Integer> integerArrayList = new ArrayList<>();
        //Use BigInteger as the result number might be huge which might not fit inside an Integer
        BigInteger final_number = new BigInteger("1");

        //lets convert the int[] to a list of integers so its easier to work with
        for (int x : xs) {
            integerArrayList.add(x);
        }

        //if there is only one element just return it
        if (integerArrayList.size() == 1) {
            return integerArrayList.get(0).toString();
        }

        //Remove all 0's from the list as (anything * 0) = 0 and (anything * 1) = itself
        boolean exists = false;
        for (int i = 0; i < integerArrayList.size(); i++) {
            if (integerArrayList.get(i) == 0 || integerArrayList.get(i) == 1) {
                if (integerArrayList.get(i) == 1) {
                    exists = true;
                }
                integerArrayList.remove(i);
                i--;
            }
        }
        //if the array is empty check if there was ever a 1 and return the result
        if (integerArrayList.size() == 0) {
            if (exists) {
                return "1";
            } else {
                return "0";
            }
        }
        /* after removing all the 0's and 1's, if there is one element and its negative, lets return 0 as
        * turning off the panel is better than it draining energy
        **/
        if (integerArrayList.size() == 1 && integerArrayList.get(0) < 0) {
            return "0";
        }

        /* Check how many negative numbers are in the array,
         if there is an odd number then lets remove the negative number closest to 0
         to create a large subset that comes out to a positive number
        */

        Integer negativeCount = 0;
        Integer smallestNegative = Integer.MIN_VALUE;
        for (Integer integer : integerArrayList) {
            if (integer < 0) {
                negativeCount++;
                if (integer > smallestNegative) {
                    smallestNegative = integer;
                }
            }
        }

        //If the number of negatives is odd remove the smallest negative
        if (negativeCount % 2 == 1) {
            integerArrayList.remove(smallestNegative);
        }

        /* With an even number of negatives and positives,
        // Lets multiply all the elements together to get the highest number
        */

        for (Integer integer : integerArrayList) {
            final_number = final_number.multiply(new BigInteger(integer.toString()));
        }

        //Return the result
        return final_number.toString();
    }
}