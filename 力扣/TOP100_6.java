package 力扣;
/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
        L   C   I   R
        E T O E S I I G
        E   D   H   N
        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
*/
import java.util.ArrayList;
import java.util.List;

public class TOP100_6 {
    public String convert(String s,int numRows){
        if(numRows<2) return  s;
        List<StringBuilder> rows=new ArrayList<>();
        for(int i=0;i<numRows;i++) rows.add(new StringBuilder());
        int i=0,flag=-1;
        for (char c:s.toCharArray()){
            rows.get(i).append(c);
            if(i==0||i==numRows-1) flag=-flag;
            i+=flag;
        }
        StringBuilder sb=new StringBuilder();
        for(StringBuilder row:rows){
            sb.append(row);
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        TOP100_6 demo=new TOP100_6();
        System.out.println(demo.convert("LEETCODEISHIRING", 3));
    }
}
