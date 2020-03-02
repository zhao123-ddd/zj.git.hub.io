import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("作者","鲁迅");
        map.put("出版时间","1955");
        map.put("标题","朝花夕拾");
        for(Map.Entry<String,String > entry:map.entrySet()){
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
        map.put("出版时间","1988");
        map.put("类型","散文");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
        System.out.println(map.containsKey("出版时间"));
        System.out.println(map.containsValue("1888"));
        map.remove("作者");
        for(Map.Entry<String,String > entry:map.entrySet()){
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
        Map<String,String> map2=new HashMap<>( );
        map2.put("作者","zz");
        System.out.println(map.entrySet().equals(map2.entrySet()));
    }
}
