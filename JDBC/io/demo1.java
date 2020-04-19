package JDBC.io;

import java.io.*;
import java.io.Writer;
import java.util.Scanner;

public class demo1 {
    public static void main (String[] args) throws IOException {
        File path1=new File("板书.png");
        File path2=new File("板书1.png");
         try (Writer writer=new OutputStreamWriter(new FileOutputStream(path2),"GBK")){
             try (Reader reader=new InputStreamReader(new FileInputStream(path1),"UTF-8")){

             }

         }
        }
    }






