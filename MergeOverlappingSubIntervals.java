//Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.
// ex :  intervals=[[1,3],[2,6],[8,10],[15,18]]
// output :  [[1,6],[8,10],[15,18]]

import java.util.*;
public class MergeOverlappingSubIntervals {
    

    // BRUTE : 
    // First sort the sub intervals coz we are checking the first of second with the last of the first array
    // TC : O(N*logN) + O(2*N), SC : O(N)
    // Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that, we are using 2 loops i and j. But while using loop i, we skip all the intervals that are merged with loop j. So, we can conclude that every interval is roughly visited twice(roughly, once for checking or skipping and once for merging). So, the time complexity will be 2*N instead of N2.
    static void findOverlappingIntervals(int[][] arr,int n){

        Arrays.sort(arr,new Comparator<int[]>() {
            public int compare(int[] x,int[] y){
                return x[0]-y[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            int first = arr[i][0];
            int last = arr[i][1];
            if(ans.size()>0 && last <= ans.get(ans.size()-1).get(1)) continue;
            for(int j=i+1;j<n;j++){
                if(arr[j][0] < last){
                    last = Math.max(last,arr[j][1]);
                }else{
                    break;
                }
            }
            ans.add(Arrays.asList(first,last));
        }

        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i).get(0) +" " + ans.get(i).get(1));
        }
    }

    // Optimal Approach
    // Before we selected one interval and compared it witht others using another loop
    /*We will start traversing the given array with a single loop. At the first index, as our answer list is empty, we will insert the first element into the answer list. While traversing afterward we can find two different cases:

            Case 1: If the current interval can be merged with the last inserted interval of the answer list:
            In this case, we will update the end of the last inserted interval with the maximum(current interval’s end, last inserted interval’s end) and continue moving afterward. 

            Case 2: If the current interval cannot be merged with the last inserted interval of the answer list:
            In this case, we will insert the current interval in the answer array as it is. And after this insertion, the last inserted interval of the answer list will obviously be updated to the current interval.
     */ 


    
    static void findOverlappingIntervals1(int[][] arr,int n){

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr,new Comparator<int[]>() {
            public int compare(int[] x,int[] y){
                return x[0]-y[0];
            }
        });

        for(int i=0;i<n;i++){

            // is the list is empty or if the curr start is greater then the list elements - last element end then that is the new interval add it into list
                    

            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1)){
                    // if the intervals doesnt overlap with the last interval

                List<Integer> list = Arrays.asList(arr[i][0],arr[i][1]);
                ans.add(list);
            }else{
                    // if the interval overlap the last then just set the last end index whoever is MAX

                int max = Math.max(arr[i][1],ans.get(ans.size()-1).get(1)); // we are taking max between curr end AND ansswer last element end 
                ans.get(ans.size()-1).set(1,max); // setting the maximum end value at the 1st index of the last elenent of ans list
            }

        }
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i).get(0) +" " + ans.get(i).get(1));
        }        

    }
    
    public static void main(String[] args) {
        
        int[][] arr= new int[][]{{1,3},{2,6},{8,10},{15,18}};
        
        findOverlappingIntervals1(arr,arr.length);
    }
}

/* OPTIMAL APPROACH INTUITION : 
 In the previous approach, while checking the intervals, we first selected an interval using a loop and then compared it with others using another loop. But in this approach, we will try to do the same using a single loop. Let’s understand how:

We will start traversing the given array with a single loop. At the first index, as our answer list is empty, we will insert the first element into the answer list. While traversing afterward we can find two different cases:

Case 1: If the current interval can be merged with the last inserted interval of the answer list:
In this case, we will update the end of the last inserted interval with the maximum(current interval’s end, last inserted interval’s end) and continue moving afterward. 

Case 2: If the current interval cannot be merged with the last inserted interval of the answer list:
In this case, we will insert the current interval in the answer array as it is. And after this insertion, the last inserted interval of the answer list will obviously be updated to the current interval.

*/