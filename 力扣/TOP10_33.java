package 力扣;
/*假设按照升序排序的数组在预先未知的某个点上进行了旋转。

        ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

        搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

        你可以假设数组中不存在重复的元素。

        你的算法时间复杂度必须是 O(log n) 级别。
 */
public class TOP10_33 {
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1,mid=0;
        while(i<=j){
            mid=(j+i)/2;
            if(nums[mid]==target) return  mid;
            if(nums[mid]>=nums[i]){
                if(target>=nums[i]&&target<=nums[mid]){
                    j=mid-1;
                }else {
                    i=mid+1;
                }
            }else {
                if(target>=nums[mid]&&target<=nums[j]){
                    i=mid+1;
                }else {
                    j=mid-1;
                }
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        TOP10_33 m=new TOP10_33();
        System.out.println(m.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
