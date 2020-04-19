package JDBC.io;

import java.io.*;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) throws IOException {
        File path1=new File("板书1.png");
        File path2=new File("板书.png");
        try(Scanner scanner=new Scanner(new InputStreamReader(new FileInputStream(path1),"GBK"))){
            try(OutputStream os=new FileOutputStream(path2)) {
                while (scanner.hasNext()) {
                    byte[] buffer = new byte[4096];
                    buffer = scanner.nextLine().getBytes("GBK");
                    os.write(buffer,0,buffer.length);
                }
            }
        }
    }
}
