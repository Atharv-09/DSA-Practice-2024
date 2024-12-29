import java.util.Stack;

public class RemoveKDigits {
    

    // Code for contigious removal of k digits
    // Not a answer to given question
    static void removeKdigits_notSolutionToQuestion(String num,int k){

        int ans = 0;
        if(num.length() == k){
            System.out.println(0);
            return;
        }

        int numLen = num.length();
        int first = Integer.parseInt(num.substring(k));
        int last = Integer.parseInt(num.substring(0,numLen-k));
        ans = Math.min(first,last);

        for(int i=1;k+i<numLen-1;i++){

            String s1 = num.substring(0,i);
            String s2 = num.substring(k+i, numLen);

            int currVal = Integer.parseInt(s1+s2);

            ans = Math.min(ans,currVal);
        }

        System.out.println(ans);
    }
    // 1432219

    static String removeKdigits(String num,int k){

        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<num.length();i++){
            while((!st.isEmpty() && k>0) && (st.peek()-'0' > num.charAt(i)-'0')){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        // 9121
        // suppose we have 123456 k=3 , here no eleent is popped up so we will remove the k elements from last
        while(k > 0){
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";
       // pop element in ans 
        String ans = "";
        while(!st.isEmpty()){
            ans = ans + st.peek();
            st.pop();
        }

        //if thier are 0 in the start we haev to trim (at start means as per stack it comes in last)
        // s = 922000
        int m = ans.length()-1;
        while(m != 0){
            if(ans.charAt(m) != '0') break;
            m--;
        }

        ans = ans.substring(0, m+1);
        
        // reverse
        StringBuffer sb = new StringBuffer(ans);
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        
        String num = "2004001";
        int k = 5;

        System.out.println(removeKdigits(num,k));

    }
}
