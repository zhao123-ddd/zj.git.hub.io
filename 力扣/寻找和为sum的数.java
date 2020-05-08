package 力扣;

import java.util.Scanner;

/*
数组中寻找合为sum的数
dp[i][j]=dp[i-1][j]+dp[i-1]dp[sum-A[i]];
i为前i个数 j为和
 */
public class 寻找和为sum的数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int[] A=new int[n+1];
            long[][]dp= new long[n + 1][m + 1];
            for(int i=1;i<=n;i++){
                A[i]=scanner.nextInt();
            }
            for(int i=0;i<=m;i++){
            dp[0][i]=0;
            }
            for(int i=0;i<=n;i++){
                dp[i][0]=1;
            }

            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(A[i]<=j){
                        dp[i][j]=dp[i-1][j]+dp[i-1][j-A[i]];
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    }




