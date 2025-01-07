package BS;

public class NthRootofNumber {
    
    
    // TC : O(m)*(n)
    // BRUTE FORCE [check for each element from 1 t0 n]
    public static int check(int x,int n){

        int ans = 1;
        for(int i=0;i<n;i++){
            ans = ans*x;
        }

        return ans;
    }
    public static void findNthRootOfNumber(int n,int m){


        for(int i=1;i<m;i++){

            if(check(i,n) == m){
                System.out.println(i);
                return;
            }else if(check(i,n) > m){
                break;
            }
        }
        System.out.println(-1);
    }

    //OPTIMAL
    //TC : search space 1 to m [log2m * log2n]
    public static int check1(int x,int n,int m){

        long ans = 1;
        for(int i=0;i<n;i++){
            ans = ans*x;
            if(ans > m) return 2; // means if the multiplication goes beyond the given m
        }

        if(ans == m) return 1;
        return 0;
    }
    public static void findNthRootOfNumber1(int n,int m){

        int low = 1;
        int high = m;

        while(low <= high){

            int mid= (low+high)/2;
            int val = check1(mid, n,m);

            if(val == 1){
                System.out.println(mid);
                return;
            }
            // why we wrote 2 coz as in above method we checked the multiplication goes more then m then we will eliminate right partt
            if(val == 2){ // eliminate he right half
                high = mid-1;
            }else{ // eliminate left half
                low = mid+1;
            }
        }

        System.out.println(-1);
    }

    // BEST SHORT APPROACH : 
    public int nthRoot(int n, int m) {
        // code here
        
        int low = 1;
        int high = m;
        
        while(low <= high){
            
            int mid = (low+high)/2;
            int pow = (int)Math.pow(mid,n);
            
            if(pow == m){
                return mid;
            }else if(pow > m){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        
        findNthRootOfNumber1(3,145);
    }
}
