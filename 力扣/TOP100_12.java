package 力扣;

public class TOP100_12 {
    public String intToRoman(int num) {
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] sb={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int index=0;
        StringBuilder s=new StringBuilder();
        while (index<13){
            while(num>=nums[index]){
                s.append(sb[index]);
                num-=nums[index];
            }
            index++;
        }
        return  s.toString();
    }

    public static void main(String[] args) {
        TOP100_12 m=new TOP100_12();
        System.out.println(m.intToRoman(800));
    }
}
