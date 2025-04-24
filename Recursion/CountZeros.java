package Recursion;

public class CountZeros {

    int helper(int num,int count){

        if(num <=0) return count;
        int rem = num%10;
        if(rem == 0)
            return helper(num/10,count+1);
        else
            return helper(num/10,count);
    }
    void count(int num){

        System.out.println(helper(num,0));
    }
    public static void main(String[] args) {

        new CountZeros().count(20200300);
    }
}
