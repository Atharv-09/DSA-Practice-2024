import java.util.Stack;

public class PrefixToPostfix {
    
     public static void findPreFixToPostfix(String s){

        Stack<String> st = new Stack<>();
        for(int i=s.length()-1;i>=0;i--){

            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(Character.toString(ch));
            }else{

                String ch1= st.pop();
                String ch2 = st.pop();
                
                String pushString =  ch1 + ch2 + ch;
                st.push(pushString);
            }
        }

        System.out.println(st.peek());
    }
    public static void main(String[] args) {
        
        findPreFixToPostfix("*+PQ-MN");
    }
}