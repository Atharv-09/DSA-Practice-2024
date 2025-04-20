public class PrimeorNot_06 {

    public static void main(String[] args) {
        

        int no = 14;
        int count = 0;

        // for(int i=1;i<=no;i++){
            
        //     if(no % i ==0)
        //         count++;
        //     if(count > 2){
        //         System.out.println("Not a prime");
        //         break;
        //     }
        // }
        // if(count == 2) System.out.println("Prime no");

        // O(sqrt(no))
        for(int i=1;i<=Math.sqrt(no);i++){

            if( no % i == 0){
                count++;

                if(no/i != i)
                    count++;
            }
        }

        if(count == 2) System.out.println("Prime");
        else System.out.println("Not a prime");
    }
    
}
