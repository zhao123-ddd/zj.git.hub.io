package 力扣;
 /* 小青蛙有一天不小心落入了一个地下迷宫,
  小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫.
  为了让问题简单,假设这是一个n*m的格子迷宫,
  迷宫每个位置为0或者1,0代表这个位置有障碍物,
  小青蛙达到不了这个位置;1代表小青蛙可以达到的位置
  小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),
  小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,
  向上爬一个单位距离需要消耗3个单位的体力值,
  向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,
  小青蛙将无法逃离迷宫现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置).
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 地下迷宫 {
  /*  static int m, n, max = 0;
    static String path = "";
    //static boolean flag = false;
    static int[][] map;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int p = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        runmap(0, 0, p);
        if (!path.equals("")) {
            System.out.println(path);
        } else {
            System.out.println("Can not escape!");
        }
    }

    private static void runmap(int x, int y, int energy) {
        if (energy < 0 || x < 0 || y < 0 || x >= n || y >= m || map[x][y] != 1) return;
        else {
            list.add("[" + x + "," + y + "]");
            map[x][y] = 0;
            if (x == 0 && y == m - 1) {
                if (energy >= max) {
                    max = energy;
                    updatepath();
                }
                map[x][y] = 1;
                list.remove(list.size() - 1);
                //flag = true;
                return;
            }
            runmap(x, y+1, energy-1);
            runmap(x+1, y, energy);
            runmap(x-1, y, energy-3);
            runmap(x, y-1, energy-1);
            map[x][y] = 1;
            list.remove(list.size()-1);
        }
    }

    private static void updatepath() {
   StringBuilder sb=new StringBuilder();
   for(int i=0;i<list.size()-1;i++){
       sb.append(list.get(i)+",");
   }
   sb.append(list.get(list.size()-1));
   path=sb.toString();

    }*/
  static  int n,m,max;
  static String path="";
  static int[][]map;
  static boolean flag=false;
  static ArrayList<String> list=new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         n=sc.nextInt();
         m=sc.nextInt();
         int P=sc.nextInt();
         map=new int[n][m];
         for (int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                 map[i][j]=sc.nextInt();
             }
         }
         runmap(0,0,P);
         if(flag){
             System.out.println(path);
         }else {
             System.out.println("Can not escape!");
         }
    }

    private static void runmap(int x, int y, int energy) {
        if(energy<0||x<0||y<0||x>=n||y>=m||map[x][y]!=1) return;
        else {
            map[x][y]=0;
            list.add("["+x+","+y+"]");
            if(x==0&&y==m-1){
                if(energy>max){
                    max=energy;
                    updatepath();
                }
                map[x][y]=1;
                list.remove(list.size()-1);
                flag=true;
                return;
            }
            runmap(x, y+1, energy-1);
            runmap(x+1, y, energy);
            runmap(x-1, y, energy-3);
            runmap(x, y-1, energy-1);
            map[x][y]=1;
            list.remove(list.size()-1);
        }
    }

    private static void updatepath() {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<list.size()-1;i++){
            sb.append(list.get(i)+",");
        }
        sb.append(list.get(list.size()-1));
        path=sb.toString();
    }
}
