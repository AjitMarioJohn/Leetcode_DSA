package com.questions.simple;

public class SpecialIntegerInArray {
    public int numberOfSpecialInteger(String[] arr){
        int count = 0;
        for(String str : arr){
            int convertNum = Integer.parseInt(str);
            int num = convertNum;
            int backNum = 0;
            while(backNum <= num){
                if(reverseNumber(num).equals(String.valueOf(backNum))){
                    count++;
                    break;
                }
                num--;
                backNum++;
            }
        }
        return count;
    }

    private String reverseNumber(int number){
        return new StringBuffer(String.valueOf(number)).reverse().toString();
    }
}
