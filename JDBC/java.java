import java.util.*;

public class java {
    /*public boolean oneEditAway(String first, String second) {
        if((first==null&&second.length()==1)||(second==null&&first.length()==1))
        return  true;
        if(first.length()!=second.length()&&(first.length()-1!=second.length()||second.length()-1!=first.length()))
            return false;
        String str1=first.length()>second.length()?first:second;
        String str2=first.length()>second.length()?second:first;
        return m(str1,str2,0,0,0);
    }
    boolean m(String str1,String str2,int i,int j,int count){
        if(count<2&&i==str1.length()&&j==str2.length())
            return true;
        if(count>1)
            return false;
        if(str1.charAt(i)!=str2.charAt(j)){
            return m(str1,str2,i+1,j,count+1)|| m(str1,str2,i+1,j+1,count+1);
        }
        return false;
    }
*/
        public String compressString(String S) {
            HashMap<Character,Integer> map=new HashMap<>();
            for(char a:S.toCharArray()){
                map.put(a,map.getOrDefault(a,0)+1);
            }
            StringBuffer sb=new StringBuffer();
            for(char a:S.toCharArray()){
                if(map.containsKey(a)){
                    sb.append(a);
                    sb.append(map.get(a));
                    map.remove(a);
                }
            }
            if(sb.length()==S.length())return S;
            return sb.toString();
        }

    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int[]dp=new int[m];
        dp[0]=0;
        dp[1]=1;
        if(m>2) {
            for (int i = 2; i < m; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        int index=0;
        while(index<m&&dp[index]<m){
            index++;
        }
        if(index==0){
            System.out.print(dp[index]);
        }
        if(index!=0&&dp[index]-m>m-dp[index-1]){
            System.out.print(m-dp[index-1]);
        }
        if(index!=0&&dp[index]-m<m-dp[index-1]){
            System.out.print(dp[index]-m);
        }
    }
    }

