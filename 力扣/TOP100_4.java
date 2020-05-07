package 力扣;
/*
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。
 */
public class TOP100_4 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            int[] temp = A;
            A = B;
            B = temp;
            int tep = m;
            m = n;
            n = tep;
        }
        int min = 0, max = m, len = (n + m + 1) / 2;
        while (min <= max) {
            int i = (min + max) / 2;
            int j = len - i;
            if (i<max&&B[j-1]>A[i]) {
                min = i + 1;
            } else if (i > min && A[i-1] > B[j]) {
                max = i -1;
            } else {
                int maxleft = 0;
                if (i == 0) {
                    maxleft = B[j - 1];
                }
                if (j == 0) {
                    maxleft = A[i - 1];
                } else {
                    maxleft = Math.max(B[j - 1], A[i - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxleft;
                }
                int minright = 0;
                if (i == m) {
                    minright = B[j];
                }
                if (j == n) {
                    minright = A[i];
                } else {
                    minright = Math.min(B[j], A[i]);
                }
                return (maxleft + minright) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        TOP100_4 A=new TOP100_4();
        System.out.println(A.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
