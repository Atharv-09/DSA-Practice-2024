public class PrintAllDivisors_05 {


    // TIME : O(sqrt(no))
    public static void main(String[] args) {
        
        int no = 45;
        
        int sqrt = (int)Math.sqrt(no);
        for(int i=1;i<=sqrt;i++){

            if(no%i == 0){
                System.out.println(i);
                
                if(no/i != i){
                    System.out.println(no/i);
                }
            }
        }
    }
    
}
