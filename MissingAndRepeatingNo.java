//Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.
// :  array[] = {3,1,2,5,3}
// miss = 4, rep = 3
// : array[] = {3,1,2,5,4,6,7,5}
// mis = 8, rep =5
import java.util.*;
public class MissingAndRepeatingNo {

    // brute force approach
    // will go from 1 to N and check for each element count, if count == 2 then its repeating and if count == 0 then its missing
    // TIME COMP : O(N^2) 
    // SPACE : O(1)

    public static void findMissAndRepeating(int[] arr,int n){

        int missEle = -1,repeatingEle =-1;
        for(int i=1;i<=n;i++){
            int count = 0;
           
            for(int j=0;j<n;j++){

                if(arr[j] == i) count++;
            }
            if(count == 2) repeatingEle = i;
            if(count == 0) missEle = i;

            if(missEle!=-1 && repeatingEle!=-1) break;
        }
        System.out.println("Missing eleent : " + missEle +"\nRepeating element : "+ repeatingEle);
    }

    // Better Using HashMap
    // we will take the count of occurent of elemnt in map and check if occurence is 2 then ele is rep and if occurenace is 0 then ele is missing
    // TC: O(N)
    // SC : O(N)
    public static void findMissAndRepeating1(int[] arr,int n){

        int missEle = -1,repeatingEle =-1;
        int[] hash = new int[n + 1];

        for(int i=0;i<n;i++){
            hash[arr[i]]++;
        }

        for(int i=1;i<=n;i++){
            if(hash[i] == 0) missEle = i;
            else if(hash[i] == 2) repeatingEle = i;

            if(missEle!=-1 && repeatingEle!=-1) break;
        }
        System.out.println("Missing eleent : " + missEle +"\nRepeating element : "+ repeatingEle);

    }

    //Optimal-1 Using XOR
    // As we know the xor of 4^4 = 0 that means the remaining 2 element after xor
    // we will get 2 different element at last x^y in that thier is some differentiating bit that is becoming them different and not cancelling out 
    // so check that differentiate bitNo and check for other element arr[0-n] and 1toN, what is thier in that differentiating ibt no 
    // if its one put it in 1st side or zero put it in 0th side
    // as we know the same element will go to same side (as the repeating element will be 3 times and missing number will be 1 time)
    // so that will only remaing in both part so check who is appearing twice that is repeating number and other is missing no.

    // TC : O(N)
    // SC : O(1)
    public static void findMissAndRepeating2(int[] arr,int n){

        int xor = 0;
        for(int i=0;i<n;i++){
            xor = xor ^ arr[i];
            xor = xor ^ (i+1);
        }

        //get differentiating bit
        int bitNo = 0;
        while(true) {

            if((xor & (1<<bitNo)) != 0) break;
            
            bitNo++;
        }
        // int number = (xor & ~(xor - 1));
        int zero = 0;
        int one = 0;

        for(int i=0;i<n;i++){

            if((arr[i] & (1<<bitNo)) !=0 ){
                // part of 1 club
                one = one ^ arr[i];
            }else{
                zero = zero ^ arr[i];
            }
        }

        
        for(int i=1;i<=n;i++){

            if((i & (1<<bitNo)) !=0 ){
                // part of 1 club
                one = one ^ i;
            }else{
                zero = zero ^ i;
            }
        }
        int count = 0;
        for(int i=0;i<1;i++){
            if(arr[i] == zero) count++;
        }
        int miss=-1,rep=-1;
        if(count == 2){
            rep = zero;
            miss = one;
        }else{
            rep=one;miss=zero;
        }
        System.out.println("Missing : "+miss +" Repeating : " + rep);
    }

    // Optimal 1 USing MATHS
    // TC :O(N) SC :O(1)
    public static void findMissAndRepeating3(int[] arr,int n){

        long sumOfN = (n*(n+1))/2;
        long sumOfSqrOfN = (n * (n + 1) * (2 * n + 1)) / 6;

        long sumOfArrNum = 0;
        long sumOfSqrOfArrNum = 0;
        
        for(int i=0;i<n;i++){
            sumOfArrNum += (long) arr[i];
            sumOfSqrOfArrNum += (long)arr[i]*(long)arr[i];
        }

        // As we know S-Sn = X-Y [X- missing, Y- repeating]
        // S2-S2n = X2-Y2 = (X+Y)(X-Y)

        // S-Sn = X-y
        long xMinusY = sumOfArrNum-sumOfN;
        // S2-S2n = X^2-Y^2:
        long x2MinusY2 = sumOfSqrOfArrNum-sumOfSqrOfN;

        // as we know x^2-y^2 = (x+y)(x-y)
        // x+y = x2-y2 / (x-y)

        long xPlusY = x2MinusY2/xMinusY;

        // we have x+y and x-y now sum up to get X value

        long x = (xPlusY + xMinusY)/2;
        long y = x-xMinusY;

        System.out.println("Missing eleent : " + x +"\nRepeating element : "+ y);

    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{3,1,2,5,3};

        findMissAndRepeating2(arr,arr.length);
    }
}
