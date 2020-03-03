import java.util.ArrayList;

public class Exception {
    public static void main(String[] args) {
        try{
            new ArrayList().get(0);
        }catch(RuntimeException e){
            throw new MyException("dasdas",e);
        }
    }
}
