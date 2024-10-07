public class MajorityElementN3 {
    

    // 1. Brute force - take each element count and check if the count > N/3
    // TC : O(N^2) SC : O(1)


    // 2. Using HashMap - take the key as element and value as the count of element and check if some element count > N/3
    // TC : O(Nlogn) SC : O(N)

    // 3. using sorting technique take the element and thier resp count check if coun > N/3 return
    // TC : O(Nlogn) SC : O(1)

    // Usind EXTENDED Boyer Moore’s Voting Alorithm

    public static void majorityElement(int[] arr,int n){

        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int cnt1 = 0,cnt2=0;

        for(int i=0;i<n;i++){

            if(cnt1 == 0 && arr[i]!=ele2){
                cnt1 = 1;
                ele1 = arr[i];
            }else if(cnt2 == 0 && arr[i]!=ele1){
                cnt2 = 1;
                ele2 = arr[i]; 
            }else if(arr[i] == ele1) cnt1++;
            else if(arr[i] == ele2) cnt2++;
            else{
                cnt1--;cnt2--;
            }
        }
        // But the above simple way of the extended booyer fail without using condition in cnt1 == 0 or cnt2 ==0 , add some condition
        // fail for input like = [{2,1,1,3,1,4,5,6}
        // coz at index 0 cnt1 = 1, ele1 = 2
        // coz at index 1 cnt2 = 1, ele2 = 1
        // coz at index 2 cnt2 = 2, ele2 = 1
        // coz at index 3 cnt1 = 0, cnt2 = 1 , ele1 = 2 , ele2 = 1
        // here as the cnt1 = 0 it goes in 1st condition and assign 1 to ele1 but 1 is already assigned to ele2 so use condition that  
        // it will only assign if that values is not assigned by other element
        
        cnt1=0;cnt2=0;
        // to recheck the element is literaaly > n/3
        for(int i=0;i<n;i++){
            if(arr[i] == ele1) cnt1++;
            if(arr[i] == ele2) cnt2++;
        }
        int chk = n/3;
        if(cnt1 > chk) System.out.println(ele1);
        if(cnt2 > chk) System.out.println(ele2);
        
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{2,1,1,3,1,4,5,6};

        majorityElement(arr,arr.length);
    }
}
