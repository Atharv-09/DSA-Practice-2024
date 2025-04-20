package Array;

public class DuplicatInArray {

    // using 2 loops
    // using sorting
    // usnig hashing
    // using boolean array or mark the element index -ve


    // Using tortois and hare algp
    // TC : O(N) SC : O(1)
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast);

        slow = nums[0];
        while(slow!=fast){
            slow =nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
