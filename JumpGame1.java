/*You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
*/

public class JumpGame1 {

    // basically we are giong from end and checking can we reach to the newLast index from currIndex 
    // _ _ _ _ _ _ _ 9 _ _ from end we can see can we reach to end from 9 - yes 
    // we will make goaldex now as the 9th index
    // _ _ _ 3 _ _ _ 9 _ _ our new goal is to reach the index of that 9
    // no we can reach coz 3+3 = 6 we can reach only the 6th index but not 9th index(i.e 7)
    // as out goal is 9 now we will chcek with next element
    // _ _ 6 3 _ _ _ 9 _ _ 
    // index of 6 = 2 + 6 = 8 >= 7 (index of 9) so now this 6th element index will be our new goal
    // if current position + maximum jump >= goal

    // SOLUTION link : https://leetcode.com/problems/jump-game/

    public boolean canJump(int[] nums) {
        int goal = nums.length-1;

        for(int i=nums.length-2;i>=0;i--){

            int val = nums[i] + i;
            if(val >= goal){
                goal = i;
            }
        }

        return goal == 0;
    }

    // other solution : 
    public boolean canJump1(int[] nums) {
        int reachable = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        } 
        return true;
     }
}
