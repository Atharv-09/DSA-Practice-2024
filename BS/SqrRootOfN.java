package BS;


public class SqrRootOfN {
    // brute take elmeent 1 to N and check if sqaure of that is n else return the mininum one

    // Optimal
    // WAY 1 
    // here what I did I go from 0 to n/2 coz as ew want to square then max sqaure root element will be less then n/2
    // so from 0 to n/2 or(from element 1 to n/2+1)
    // check the mul of mid element 1. mul == n then that mid+1 element is the and 2. if mul is smaller we have to go at right side, eliminate left side (low = mid+1)
    public static void findSqrRoot(int n){
        if(n==1 || n==2){
            System.out.println(1);
            return;
        }

        int low = 0;
        int high = n/2;

        while(low  <= high){
            int mid = (low+high)/2;

            int mul = (mid+1)*(mid+1);

            if(mul == n) {
                System.out.println(mid+1);
                return;
            }
            else if(mul > n) high = mid-1;
            else {

                low = mid+1;
            }
        }
        System.out.println(low);
    }

    // way 2 
    public static void findSqrRoot1(int n){

        int low = 1, high = n;
            //Binary search on the answers:
            while (low <= high) {
                long mid = (low + high) / 2;
                long val = mid * mid;
                if (val <= (long)(n)) {
                    //eliminate the left half:
                    low = (int)(mid + 1);
                } else {
                    //eliminate the right half:
                    high = (int)(mid - 1);
                }
            }
          System.out.println(high);
    }
    public static void main(String[] args) {
        
        findSqrRoot(5);
    }
}
