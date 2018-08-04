package leetcode;

/**
 * @author Navin Kumar
 * @date 7/21/18
 *
 * https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame55 {

    // https://www.programcreek.com/2014/03/leetcode-jump-game-java/
    private boolean canJump(int[] nums) {
        if(nums.length <= 1)
            return true;

        int max = nums[0]; //max stands for the largest index that can be reached.
        int n = nums.length;

        for(int i=0; i<n; i++){
            //if not enough to go to next
            if(max <= i && nums[i] == 0)
                return false;

            //update max
            if(i + nums[i] > max){
                max = i + nums[i];
            }

            //max is enough to reach the end
            if(max >= n-1)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        JumpGame55 game = new JumpGame55();
        int[] a = {2,3,1,1,4};
        System.out.println(game.canJump(a));
        a = new int[]{3,2,1,0,4};
        System.out.println(game.canJump(a));
        a = new int[]{0};
        System.out.println(game.canJump(a));
        a = new int[]{1};
        System.out.println(game.canJump(a));
    }

}
