// Statement 1 : There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values.

import java.util.*;
import java.lang.*;
public class RearrangeElementBySign {

    // For array having same number of pos and neg elements
    // vARIETY 1 : Equal numbers of +ve and -ve eleemnts in array and order matters
    // Time : O(N) Space : O(N)
    public static void rearrange(int[] arr,int n){

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(arr[i] <0) neg.add(arr[i]);
            else pos.add(arr[i]);
        }
        
        for(int i=0;i<n/2;i++){
            arr[2*n] = pos.get(i);
            arr[2*n+1] = neg.get(i);
        }

    }


     // OPTIMAL : By considering the indexes of pos as even and neg as odd 
     public static void rearrange(int[] arr,int n){

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));

        // positive elements start from 0 and negative from 1.
        int posIndex = 0, negIndex = 1;
        for (int i = 0; i < n; i++) {

            // Fill negative elements in odd indices and inc by 2.
            if (A.get(i) < 0) {
                ans.set(negIndex, A.get(i));
                negIndex += 2;
            }

            // Fill positive elements in even indices and inc by 2.
            else {
                ans.set(posIndex, A.get(i));
                posIndex += 2;
            }
        }

     }
    // VARIETY 2: Not Equal numbers of +ve and -ve eleemnts in array and order matters
 
    /// ex : arr[] = {1,2,-4,-5,3,4}, N = 6 ANS : [1 -4 2 -5 3 4]
     // OPTIMAL

    public static void rearrange1(int[] arr,int n){

        int posCount = 0,negCount = 0;
        for(int i=0;i<n;i++){
            if(arr[i] < 0) negCount++;
            else posCount++;
        }

        int[] pos = new int[posCount];
        int[] neg = new int[negCount];
        int p=0,ne=0;
        for(int i=0;i<n;i++){
            if(arr[i] < 0){
                neg[ne++] = arr[i];
            }else{
                pos[p++] = arr[i];
            }
        }

        int i=0,j=0,k=0;
        while(i<posCount && j<negCount){
            
            arr[k] = pos[i++];
            arr[k+1] = neg[j++];
            k+=2;
        }

        while(i<posCount){
            arr[k++] = pos[i++];
        }

        while(j<negCount){
            arr[k++] = neg[j++];
        }


        for(int l=0;l<n;l++){
            System.out.print(arr[l]+ " ");
        }

    }

    // VARIETY 3: Equal numbers of +ve and -ve eleemnts in array and order doesn't matters

    // As we know order doesn't matter and we have same no of pos and neg numbers
    // we can check if the +Ve no is at even index or not, if not we can get negative and swap it
    // same for -ve element at odd index or not, if not we can get positive and swap.

    // p1 p2 n1 p3 n2 n3
    // 1. p2 is not at right index swap with -ve element index - p1 n1 p2 p3 n2 n3  -> swap(p3,n2) p1 n1 p2 n2 p3 n3

    // IME : O(N) SPace : O(1) 
    public static void rearrange2(int[] arr,int n){

        int pos = 0,neg=1;
        while(pos < n && neg < n){

            if(arr[pos] >= 0) pos+=2; // we have positive element at even index
            else if(arr[neg] < 0) neg+=2; // we have negative element at odd index
            else{
                int temp = arr[pos];
                arr[pos] = arr[neg];
                arr[neg] = temp;
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,14,8,-2,-4,4,-2};

        rearrange2(arr,arr.length);
    }
}

/*
// same way for VARIETY-2 but they toook first lesser size array of pos/neg then looped that much index of both and then appended the bigger size array remaining elements

public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A, int n) {
    // Define 2 ArrayLists, one for storing positive 
    // and other for negative elements of the array.
    ArrayList<Integer> pos = new ArrayList<>();
    ArrayList<Integer> neg = new ArrayList<>();

    // Segregate the array into positives and negatives.
    for (int i = 0; i < n; i++) {
        if (A.get(i) > 0)
            pos.add(A.get(i));
        else
            neg.add(A.get(i));
    }

    // If positives are lesser than the negatives.
    if (pos.size() < neg.size()) {

        // First, fill array alternatively till the point 
        // where positives and negatives are equal in number.
        for (int i = 0; i < pos.size(); i++) {
            A.set(2 * i, pos.get(i));
            A.set(2 * i + 1, neg.get(i));
        }

        // Fill the remaining negatives at the end of the array.
        int index = pos.size() * 2;
        for (int i = pos.size(); i < neg.size(); i++) {
            A.set(index, neg.get(i));
            index++;
        }
    }

    // If negatives are lesser than the positives.
    else {
        // First, fill array alternatively till the point 
        // where positives and negatives are equal in number.
        for (int i = 0; i < neg.size(); i++) {
            A.set(2 * i, pos.get(i));
            A.set(2 * i + 1, neg.get(i));
        }

        // Fill the remaining positives at the end of the array.
        int index = neg.size() * 2;
        for (int i = neg.size(); i < pos.size(); i++) {
            A.set(index, pos.get(i));
            index++;
        }
    }
    return A;
}

*/