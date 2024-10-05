public class UnionOf2SortedArr {

    // 1 . HashMap : we can put the values as the key in map and thier count in map and take alll the keys from map
    static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
        HashMap <Integer,Integer > freq=new HashMap<>();
        ArrayList<Integer> Union=new ArrayList<>();
        for (int i = 0; i < n; i++)
          freq.put(arr1[i],freq.getOrDefault(arr1[i],0)+1);
          
        for (int i = 0; i < m; i++)
          freq.put(arr2[i],freq.getOrDefault(arr2[i],0)+1);
        for (int it: freq.keySet())
          Union.add(it);
        return Union;
      }
    // 2 . HashSet : we will put both arrays values in set such that only union part/unique element are thier not duplicates
    static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
        HashSet <Integer> s=new HashSet<>();
        ArrayList < Integer > Union=new ArrayList<>();
        for (int i = 0; i < n; i++)
          s.add(arr1[i]);
        for (int i = 0; i < m; i++)
          s.add(arr2[i]);
        for (int it: s)
          Union.add(it);
        return Union;
      }

      
    // TC : O(m+n) SC : O(m+n)    
    // take the two pointers at array 1  and array 2 such that the lowest element we will put in ans and check that lowest eleentn is already thier in ans or not if not then we will put

    public void unionOfTwoSortedArray(int[] arr1,int[] arr2){

        int i =0;
        int j =0;


        int m = arr1.length;
        int n = arr2.length;
        List<Integer> unionArr = new ArrayList<>();

        while(i < m && j < n){
            if(arr1[i] <= arr2[j]){ 
                
                if(unionArr.size()==0 || arr1[i] != unionArr.get(unionArr.size()-1))
                    unionArr.add(arr1[i]);
                i++;
                
            }else{

                if(unionArr.size()==0 || arr2[j] != unionArr.get(unionArr.size()-1))
                    unionArr.add(arr2[j]);
                j++;
            }
        }

        while(i<m){
            if(arr1[i] != unionArr.get(unionArr.size()-1))
                    unionArr.add(arr1[i]);
                i++;
        }

        while(j<n){
            if(arr2[j] != unionArr.get(unionArr.size()-1))
                    unionArr.add(arr2[j]);
                j++;
        }

        for(int x:unionArr){
            System.out.print(x+" ");
        }
    }

    //OTHER WAY : 
    ///INSTEAD OF CHECKIN THE ELEMENT PUTTED IN ANS LAST INDEX OR NOT WE CAN DIRECTLY LOOP AND MAKE THE PONTER FORWARD TILL THE NEWEST ELEMENT

     //Function to return a list containing the union of the two arrays.
     public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
     {
         ArrayList<Integer> ans = new ArrayList<>();
         
         int i=0, j=0;
         
         while(i<n && j<m)
         {
             int x = arr1[i];
             int y = arr2[j];
             
             if(x<y)
             {
                 ans.add(x);
                 while(i<n && arr1[i]==x) i++;
             }
             else if(x==y)
             {
                 ans.add(x);
                 while(i<n && arr1[i]==x) i++;
                 while(j<m && arr2[j]==y) j++;
             }
             else
             {
                 ans.add(y);
                 while(j<m && arr2[j]==y) j++;
             }
         }
         
         while(i<n)
         {
             int x = arr1[i];
             ans.add(x);
             while(i<n && arr1[i]==x) i++;
         }
         
         while(j<m)
         {
             int y = arr2[j];
             ans.add(y);
             while(j<m && arr2[j]==y) j++;
         }
         
         return ans;
     }
    public static void main(String[] args) {
        
// 1 2 
        int[] arr1 = new int[]{1,2,2,2,4,5,5,7};
        int[] arr2 = new int[]{2,3,5,6,8};

        new UnionOf2SortedArr().unionOfTwoSortedArray(arr1, arr2);
    }
}
