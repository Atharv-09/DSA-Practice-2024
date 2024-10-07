import java.util.*;

//Problem Statement: Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero. In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.

// ex:  nums = [-1,0,1,2,-1,-4]
// op :  [[-1,-1,2],[-1,0,1]]

public class Sum3 {


    // Brute force
    // By using 3 loop check each 3 element possible and put it into ans if its sum = 0
    // TIME COMPLEITY : : O(N^3 * log(no. of unique triplets)) And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.
    // SPACE COMPLEXITY : O(2 * no. of the unique triplets) set and list to store triplet.
    static List<List<Integer>> find3Sum(int[] arr,int n){

        Set<List<Integer>> set = new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int tripletSum = arr[i] + arr[j] + arr[k];
                    if(tripletSum == 0){

                        List<Integer> ans = Arrays.asList(arr[i],arr[j],arr[k]);
                        ans.sort(null);
                        set.add(ans);
                    }
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }

    public static void print(List<List<Integer>> arr){
        for(List<Integer> ls : arr){
            for(int x:ls){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }

    // Better 
    // Instead of using third loop we can take 2 element sum and in set we can check if the 0-(2 elemt) sum is thier that means it is the third element
    // if its thier add it into ans list, sort and add it to set
    // TIME : O(N^N)* log(no. of unique triplets)
    // Space: O(2*No of unique triplets)

    static List<List<Integer>> find3Sum1(int[] arr,int n){

        Set<List<Integer>> set = new HashSet<>();

        for(int i=0;i<n;i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1;j<n;j++){
                    
                    int doubleS = arr[i] + arr[j];
                    int third = 0-doubleS;

                    if(hashset.contains(third)){

                        List<Integer> ans = Arrays.asList(arr[i],arr[j],third);
                        ans.sort(null);
                        set.add(ans);
                    }
                    hashset.add(arr[j]);
            }
        }
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }

    // Optimal- // THREE POINTER APPROACH
    // Time Complexity: O(NlogN)+O(N2), where N = size of the array.
    // Reason: The pointer i, is running for approximately N times. And both the pointers j and k combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N2). 
    
    // Instead of using set to put the unique element we are using sorting and skipping the duplicate element
    

    static List<List<Integer>> find3Sum2(int[] arr,int n){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){

            // remove duplicates
            if(i!=0 && arr[i] == arr[i-1]) continue;
            int p1 = i+1;
            int p2 = n-1;

            while(p1<p2){

                int total = arr[i]+arr[p1]+arr[p2];
                if(total == 0){
                    List<Integer> ans = Arrays.asList(arr[i],arr[p1],arr[p2]);
                    list.add(ans);
                    p1++;p2--;
                    // check if the same element is thier in next pos
                    while(p1 <p2 && arr[p1] == arr[p1-1]) p1++;
                    while(p1 <p2 && arr[p2] == arr[p2+1]) p2--;
                    
                }else if(total > 0){
                    p2--;
                }else{
                    p1++;
                }
            }
        }
        return list;

    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{-1,1,0,-1,-4,2};
        List<List<Integer>> result = find3Sum(arr,arr.length);
        List<List<Integer>> result1 = find3Sum1(arr,arr.length);
        List<List<Integer>> result2 = find3Sum2(arr,arr.length);

        print(result2);
    }
}
