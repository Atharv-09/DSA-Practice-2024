package LinkedList;
/*
 * Browsing history
 * 1. browser (homepage)
 * 2. visit(url)
 * 3. back(steps)
 * 4. forward (stps)
 * 
 * QUERIES : 
 * homepage = xyz.com
 * visit(google.com)
 * visit(insta.com)
 * visit(fb.com)
 * back(1)  back(1)  forward(1)  visit(xyz.com)  forward(2)  forward (2)  back(7)
 * 
 * xyz.com -> google.com -> insta.com -> fb.com ->
 * now its back it will return insta.com
 * again back(1) - curr in google.com 
 * forwar(1) - curr in insta.com
 * visit(xyz.com) - from insta.com -> xyz.com (thier will the no link of fb now)
 * forward(2) - but after xyz.com thier is nothing it return xyz.com only
 * back(2) - xyz.com -> google.com -> insta.com -> xyz.com   = it will go to google.com
 * back(7) - we are at google.com , we can't go 7 back it return xyz.com of start
 */
public class BrowsingHistory_DLL {
    static Node current;
    static class Node{

        String url;
        Node next,prev=null;
        Node(String url){
            this.url = url;
            prev=null;next=null;
        }
    }

    BrowsingHistory_DLL(String homepage){
        current = new Node(homepage);
    }

    public void visit(String url){
        Node newNode = new Node(url);
        current.next = newNode;
        newNode.prev = current;

        current = current.next;
    }

    public Node back(int steps){

        while(steps > 0 && current.prev!=null){
            current = current.prev;
            steps--;
        }
        return current;
    }

    public Node forward(int steps){

        while(steps > 0 && current.next!=null){
            current = current.next;
            steps--;
        }
        return current;
    }

    public static void printTheList(){

        Node temp = current;
        while(temp!=null){
            System.out.print(temp.url + " <- ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        BrowsingHistory_DLL  history = new BrowsingHistory_DLL("www.atharva.com");

        history.visit("google.com");
        history.visit("instagram.com");
        history.visit("fb.com");
        history.visit("twiter.com");
        
        printTheList();
        Node node = history.back(2);
        Node node1 = history.back(1);
        System.out.println("we are at : " + node.url);
        System.out.println("we are at : " + node1.url);
        
        Node nodeF = history.forward(1);
        System.out.println("we are at : " + nodeF.url);

        history.visit("pussyCat.com");
        Node nodeF1 = history.back(1); // as when we did instagram next as the pussycat so instea do going insta next to fb it will go to pussycat.com page
        
        System.out.println("we are at : " + nodeF1.url);

    }

}
