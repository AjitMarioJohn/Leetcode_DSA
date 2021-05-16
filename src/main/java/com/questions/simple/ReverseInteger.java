package com.questions.simple;

public class ReverseInteger{
	public int reverse(int x) {
        if(x == 0)
			return x;
		int reverseInt = 0;
		while(x!=0){
			reverseInt = reverseInt*10+(x%10);
			x =  x/10;
		}
		return reverseInt;
    }
}