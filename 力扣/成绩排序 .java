/*第一行 人数
第二行0逆序1升序
后面姓名+成绩 空格隔开
 */
package 力扣;
import java.util.*;
class student {
    public String name;
    public int score;

    public student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class 成绩排序 {
    public static void main(String[]args){
     Scanner scanner=new Scanner(System.in);
     while(scanner.hasNext()){
         int num=scanner.nextInt();
         int k=scanner.nextInt();
         ArrayList<student> list=new ArrayList<>();
         for(int i=0;i<num;i++){
              list.add(new student(scanner.next(), scanner.nextInt()));
         }
         if(k==0){
             Collections.sort(list, new Comparator<student>() {
                 @Override
                 public int compare(student o1, student o2) {
                     return o2.score-o1.score;
                 }
             });
         }else if(k==1){
             Collections.sort(list, new Comparator<student>() {
                 @Override
                 public int compare(student o1, student o2) {
                     return o1.score-o2.score;
                 }
             });
         }
         for(student m:list){
             System.out.println(m.name+" "+m.score);
         }
     }
     }
    }


