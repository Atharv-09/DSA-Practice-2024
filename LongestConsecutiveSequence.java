//Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.

// ex :  [100, 200, 1, 3, 2, 4] => Op = 4 {1,2,3,4}
import java.util.*;
public class LongestConsecutiveSequence {


    // 1. Linear search the ele+1,ele+2,ele+3 ... is thier in array then take count to take cound
    // TIEM : O(N^2) 

    static boolean linearSearch(int[] arr,int ele){

        for(int i=0;i<arr.length;i++){
            if(ele == arr[i]) return true;
        }
        return false;
    }
    static void findLongestConsecutiveSeq(int[] arr,int n){

        int maxCount = Integer.MIN_VALUE;
        int ansEleStart = 0;
        for(int i=0;i<n;i++){
            int ele = arr[i];
            int count = 1;
            while(linearSearch(arr,ele+1)){
                ele = ele+1;
                count +=1;
            }
            if(count > maxCount) {
                ansEleStart = ele;
                maxCount = count;
            }
        }
        System.out.println("Element start from : " + (ansEleStart-maxCount+1) + " End at : " + ansEleStart + " count : " + maxCount);

    }


    // 2. Sorting 
    // Sort the array and check if the i+1 index having element arr[i-1] + 1 take count
    // TIEM : O(NlogN) SPACE : O(1)

    static void findLongestConsecutiveSeq1(int[] arr,int n){

        Arrays.sort(arr);
        int count = 1;
        int maxCount =0;
        for(int i=0;i<n-1;i++){
            if(arr[i+1] == (arr[i]+1)){
                count++;
            }else{
                count = 1;
            }
            maxCount = Math.max(count, maxCount);
        }
        System.out.println(maxCount);
    }

    //OR
    static int findLongestConsecutiveSeq2(int[] a,int n){

        Arrays.sort(a);
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;

        //find longest sequence:
        for (int i = 0; i < n; i++) {
            if (a[i] - 1 == lastSmaller) {
                //a[i] is the next element of the
                //current sequence.
                cnt += 1;
                lastSmaller = a[i];
            } else if (a[i] != lastSmaller) {
                cnt = 1;
                lastSmaller = a[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }


    // 3 . Usin Set DS { OPTIMAL }
    /*We will adopt a similar approach to the brute-force method but with optimizations in the search process. Instead of searching sequences for every array element as in the brute-force approach, we will focus solely on finding sequences only for those numbers that can be the starting numbers of the sequences. This targeted approach narrows down our search and improves efficiency.
    -  put all the eleements in set DS
    - now loop the element and check is ele-1 is thier in set ? 
        YES - its not the starting element, i++
        NO - its the starting element , for this check ho wmany consecutive elements are thier

        TIME : O(N) Space : O(N)

    */

    static void findLongestConsecutiveSeq3(int[] a,int n){

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++)
            set.add(a[i]);
        int maxCount = 0;
        for(int it:set){

            if(!set.contains(it-1)){
                int ele = it;
                int count = 1;
            
                while(set.contains(ele+1)){
                    count++;
                    ele++;
                }
                maxCount = Math.max(count,maxCount);
            }

        }
        System.out.println(maxCount);

    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{100,4,2,3,19};

        findLongestConsecutiveSeq3(arr,arr.length);
    }
}
