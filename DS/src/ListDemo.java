import java.util.ArrayList;
import java.util.List;
public class ListDemo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("java");
        list.add("c");
        list.add("cpp");
        for(String list1:list ){
            System.out.println(list1);
        }
        System.out.println(list.indexOf("cpp"));
        System.out.println(list.get(0));
        System.out.println(list.contains("cpp+"));
        list.remove(0);
        for(String list1:list ){
            System.out.println(list1);
        }
        ArrayList<String> list1=(ArrayList<String>)list;
        System.out.println(list1);
    }
}
