import java.util.Stack;

public class PostfixToPrefix {
    
    public static void findPostFixToPrefix(String s){

        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(Character.toString(ch));
            }else{

                String ch1= st.pop();
                String ch2 = st.pop();
                
                String pushString = ch+ ch2 + ch1;
                st.push(pushString);
            }
        }

        System.out.println(st.peek());
    }
    public static void main(String[] args) {
        
        findPostFixToPrefix("AB-DE+F*/");
    }
}
