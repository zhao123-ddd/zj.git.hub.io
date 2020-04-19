import java.util.*;

public class Demp{
        public int findKth(int[] a, int n, int K) {
            quicksort(a,0,n-1);
            return a[n-K];
        }
        public int sort(int[]a,int left,int right){
            int start=left;
            int key=a[start];
            while(left<right){
                while(left<right&&a[right]>=key) {
                    right--;
                }
                while(left<right&&a[left]<=key) {
                    left++;
                }
                swap(a,left,right);
            }
            swap(a,start,left);
            return left;

        }

        public void quicksort(int[]a,int left,int right){

            if(left<right){
                int mid=sort(a,left,right);
                quicksort(a,left,mid-1);
                quicksort(a,mid+1,right);
            }
        }
        public void swap(int[]a,int i,int j){
            int temp=a[j];
            a[j]=a[i];
            a[i]=temp;
        }

    public static void main(String[] args) {
        int nums[]=new int[]{1,2,2,2,3};
        Demp m=new Demp();
        m.findKth(nums,5,2);
    }
    }


