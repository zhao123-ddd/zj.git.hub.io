package JDBC.io;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        while(m>0){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            int[]nums=new int[2*n];
            int k1=k;
            while(k1>0){
                int []nums1=new int[n];
                int []nums2=new int[n];
                if(k1==k){
                    for(int i=0;i<2*n;i++){
                        if(i<n){
                            nums1[i]=scanner.nextInt();
                        }else{
                            nums2[i-n]=scanner.nextInt();
                        }
                    }
                    for(int i=0;i<2*n;i++){
                        if(i%2==0){
                            nums[i]=nums1[i/2];
                        }else{
                            nums[i]=nums2[i/2];
                        }
                    }
                }else{
                    nums1=Arrays.copyOfRange(nums,0,n);
                    nums2=Arrays.copyOfRange(nums,n,2*n);
                    for(int i=0;i<2*n;i++){
                        if(i%2==0){
                            nums[i]=nums1[i/2];
                        }else{
                            nums[i]=nums2[i/2];
                        }
                    }
                }
                k1--;
            }
            if(m!=1){
                for(int i=0;i<2*n;i++){
                    System.out.print(nums[i]);
                    System.out.print(" ");
                }
            }else{
                for(int i=0;i<2*n;i++){
                    if(i<2*n-1){
                        System.out.print(nums[i]);
                        System.out.print(" ");
                    }else{
                        System.out.print(nums[i]);
                    }
                }
            }
            m--;
        }
    }
}
