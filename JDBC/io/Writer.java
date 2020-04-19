package JDBC.io;

import java.io.*;

// 字节输出流
public class Writer {
    public static void main(String[] args) throws IOException {
        try (OutputStream os = new FileOutputStream("加油中国-2.txt")) {
            try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"))) {
                for (int i = 0; i < 10; i++) {
                    writer.printf("%02d: 你好世界%n", i);
                }

                writer.flush();
            }
        }
    }
}
