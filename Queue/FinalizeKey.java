package Queue;
public class FinalizeKey {
    

    public void finalize(){
        System.out.println("In finalize");
    }
    public static void main(String[] args) {
        
        FinalizeKey f = new FinalizeKey();

        f = null;
        System.gc();
    }
}
