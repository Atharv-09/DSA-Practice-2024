class Solution {
    public int reverse(int x) {
        
        // using conveting int to string and reverse

        // int res = 0;
        // String str = String.valueOf(Math.abs(x));
        
        // StringBuilder sb = new StringBuilder(str).reverse();

        // try{
        // res = Integer.parseInt(sb.toString());
        // }catch(NumberFormatException e){
        //     return 0;
        // }
        // return (x<0) ? -res :  res;

        boolean isNegative = x < 0 ? true : false;
        if(isNegative)  x= -x;


        int res = 0;
        while(x > 0){
            int digit = x % 10;
            x = x/10;
            if(res > (Integer.MAX_VALUE - digit)/10){
                return 0;
            }
            res = res * 10 + digit;
        }
        return isNegative ? -res : res;
        
    }
}