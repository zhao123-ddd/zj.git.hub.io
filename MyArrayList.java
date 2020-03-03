

import java.util.ArrayList;
import java.util.List;

public  class MyArrayList{
    public int balancedStringSplit(String s){
        int size=0;
        List<Character> list=new ArrayList<>();
        for(char c:s.toCharArray()){
            if(list.isEmpty()) {
                list.add(c);
            }

            else if(c!=list.get(list.size()-1)){
                list.remove(list.size()-1);
                if(list.isEmpty()){
                    size++;
                }
            }
            else if(c==list.get(list.size()-1)){
                list.add(c);
            }
        }
        return size;

    }

    public static void main(String[] args) {
        MyArrayList m=new MyArrayList();
        System.out.println(m.balancedStringSplit("RRLLRRLLRLRLRLRLRLRLRLRL"));
    }

}