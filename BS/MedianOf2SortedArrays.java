package BS;

class Main{

    // TC : O(n+m) space : O(n+m)   
    // Brute force
    public static double findMedian(int[] arr1,int arr2[],int n,int m){

        int k = n+m;
        int[] arr3 = new int[k];
        int i=0,j=0,p=0;
        while(i<n && j<m){
            if(arr1[i] < arr2[j]) arr3[p++] = arr1[i++];
            else arr3[p++] = arr2[j++];
        }
        while(i<n){
            arr3[p++] = arr1[i++];
        }
        while (j<m) {
            arr3[p++] = arr2[j++];
        }
        
        if(k%2 == 1) return (double)arr3[k/2];
        else {
            double median = ((double)((double)arr3[k/2] + (double)arr3[k/2]-1))/2.0;
            return median;
        }
    }

    // Better
    // optimise the space , do we need that third array ? No right
    // we just keeping the tracker to get that particular index

    // we will take the count of the index as we check
    // Time Complexity: O(n1+n2)
   public static double findMedian1(int[] arr1,int arr2[],int n,int m){

        int countI = 0 ; //it contains the index of the element
        // req index
        int k = n+m;
        int ind1 = k/2,ind2=ind1-1;
        int ind1Ele=0,ind2Ele=0;
        
        int i=0,j=0;
        while(i<n && j<m){
            if(arr1[i] < arr2[j]){
                if(countI == ind1) ind1Ele = arr1[i];
                if(countI == ind2) ind2Ele = arr1[i];
                countI++;
                i++;
            }else{
                if(countI == ind1) ind1Ele = arr2[j];
                if(countI == ind2) ind2Ele = arr2[j];
                countI++;
                j++;
            }
        }
        while(i<n){
            if(countI == ind1) ind1Ele = arr1[i];
            if(countI == ind2) ind2Ele = arr1[i];
            countI++;
            i++;
        }
        while (j<m) {
            if(countI == ind1) ind1Ele = arr1[i];
            if(countI == ind2) ind2Ele = arr1[i];
            countI++;
            i++;   
        }
        if(k%2 == 1) return (double)ind2Ele/2;
        
        return (double)((double)(ind1Ele+ind2Ele)/2);
    }

    //optimal using BS
    // as we have sorted element we have to find the mdeian
    // arr1 = 1 3 4 7 10 12 arr2 = 2 3 6 15 
    
    // arr3 = 1 2 3 3 4 | 6 7 10 12 15 (we have left half,right half 5 element )

    // for the left half we took 3 elements from arr1 and 2 elements from arr2
    // for thr right hald we took 3 elements from arr1 and 2 elements from arr2
    // we have to formulate correct left/right half so the median will be last element of arr1 + first element of arr2 /2
    
    // 1. we will try to build left/right hald
    //1. if we took nothing from arr1 and all from arr2 => not possile coz its 4elements only but we want 5 element
    //2. if we took 1 element from arr1 and other 4 from arr2 => (1)(2,3,6,15) | 3,4,7,10,12  => sort => 1,2,3,6,15 | 3,4,7,10,12 [15 > 3 it is no sorted]
    //3. If we took 2 element from arr1 and other 3 elemnt from arr2 => (1,3)(2,3,6) | (4,7,10)(15) => sort => 1,2,3,3,6 | 4,7,10,15 (as 6>4 it is not sorted)
    //4. if we took 3 elements from arr1 and other 2 element from arr2 -> (1,3,4){2,3) | (7,10)(6,15) -> sort => 1,2,3,3,4 | 6,7,10,15 (as 4<6 array is sorted)
    //5. if we took 4 elemtns from arr1 and 1 element from arr2 -> (1,3,4,7) (2) | (10,12),(3,6,15) -> sort => 1,2,3,4,7 | 3,6,10,12,15 (7>3, not sorted)
    // no need to check further(thier will be one where we get out ans) 

    public static double findMedian2(int[] nums1,int n1,int nums2[],int n2){

        if(n1>n2) return findMedian2(nums2,n2,nums1,n1);// as we are doing binaary search on nums1 so nums1 should we smallest to decrease the complexity

        // BS on condition from 0 to n1 (we can pick no-one or pick all of them)
        // if we pick any thing between then pick remaining elements from nums2
        // if l1,l2 | r1,r2 if(l1>r2) that means it is not possible , HIGH eliminated
        // if (l2 > r1) that means no possible, Left eliminated 

        int low = 0;
        int high = n1;
        int left = (n1+n2+1)/2;
        int n = n1+n2;

        while(low <= high){

            int mid1 = (low+high)/2; // we pick suppose 2 element from arr1 so other 3 element are from arr2
            int mid2 = left-mid1;  // other 3 element from arr2
            
            int l1 = Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE,r2 = Integer.MAX_VALUE;
            // we have the mid1 and mid2 to the righest part so suppose we took all element from arr1 the mid1 goes to n1+1

            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
             
            if(mid1-1 >=0) l1 = nums1[mid1-1];
            if(mid2-1 >=0) l2 = nums2[mid2-1];

            if(l1 <= r2 && l2<= r1){
                if(n%2==1){
                    return (double)Math.max(l1,l2);
                }else{
                    return (double)(((double)Math.max(l1,l2) + (double)Math.min(r1, r2))/2.0);
                }
            }else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }

        }
        return 0;
    }
    public static void main(String[] args) {
        
        int[] arr1 = new int[]{1,5,7,8,12};
        int[] arr2 = new int[]{5,8,10};

        System.out.println(findMedian2(arr1,arr1.length,arr2,arr2.length));
    }
}