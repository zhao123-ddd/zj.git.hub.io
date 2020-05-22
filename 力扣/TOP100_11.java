package 力扣;

public class TOP100_11 {
    public int maxArea(int[] height) {
        int i=0,max=0,j=height.length-1;
        while(i<j){
            max=height[i]<height[j]?Math.max(max,(j-i)*height[i++]):Math.max(max,(j-i)*height[j--]);
        }
        return max;
    }
}
