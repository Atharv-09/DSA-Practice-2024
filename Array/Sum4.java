
//Problem Statement: Given an array of N integers, your task is to find unique quads that add up to give a target value. In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.

// input :  arr[] = [1,0,-1,0,-2,2], target = 0
// output :  [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
import java.util.*;

public class Sum4 {
    
    // brute force : using 4 loops 
    // TC : O(n^4)

    public static List<List<Integer>> find3Sum(int[] arr,int n,int target){

        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){

                        long total = (long) arr[i] + arr[j];
                        total += arr[k];
                        total += arr[l];

                        if(total == target){
                            List<Integer> list = new ArrayList<>();
                            list = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            Collections.sort(list);
                            set.add(list);
                        }
                    }
                }
            }
        }

        List<List<Integer>> ansList = new ArrayList<>(set);
        return ansList;
    }


    // Better 
    // by taking set we can check we have 4th element in set it will remove he 4th loop 
    // using hashset and set DS

    public static List<List<Integer>> find3Sum1(int[] arr,int n,int target){
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Long> hashset = new HashSet<>();
                for(int k=j+1;k<n;k++){
                    

                        long total = arr[i] + arr[j];
                        total += arr[k];
                        long fourth = (target-total);

                        if(hashset.contains(fourth)){
                            List<Integer> list = new ArrayList<>();
                            list.add(arr[i]);
                            list.add(arr[j]);
                            list.add(arr[k]);
                            list.add((int)fourth);
                            Collections.sort(list);
                            set.add(list);
                        }
                    hashset.add((long)arr[k]);
                }
            }
        }

        List<List<Integer>> ansList = new ArrayList<>(set);
        return ansList;

    }

    // Optimal
    // take 4 pointers 
    public static List<List<Integer>> find3Sum2(int[] arr,int n,int target){

        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(arr);

        for(int i=0;i<n;i++){

            if(i>0 && arr[i] == arr[i-1]) continue;
            for(int j=i+1;j<n;j++){
                    
                if(j>i+1 && arr[j] == arr[j-1]) continue;
                int k = j+1;
                int l = n-1;

                while(k<l){
                    long sum = arr[i];
                    sum += arr[j];
                    sum += arr[k];
                    sum += arr[l];
                    if (sum == target) {
                    List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && arr[k] == arr[k - 1]) k++;
                        while (k < l && arr[l] == arr[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }

    public static void print(List<List<Integer>> ans){
        for(List<Integer> list:ans){
            for(int k:list){
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        List<List<Integer>> ans = find3Sum2(arr, arr.length,9);
        print(ans);
    }
}
