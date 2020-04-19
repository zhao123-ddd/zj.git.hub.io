package 网络;

import java.util.*;
import java.net.*;
import java.io.*;

public class TCP_Server {
    public static void main(String[] args) throws IOException {
        // 开一家店
        ServerSocket serverSocket = new ServerSocket(9898);
        // 循环处理业务
        while (true) {
            Socket socket = serverSocket.accept();

            // 获取输入流
            InputStream is = socket.getInputStream();
            // 封装成 Scanner
            Scanner scanner = new Scanner(is, "UTF-8");
            // 使用 \r\n 进行分割的方式，读取一个请求
            String request = scanner.nextLine();    // nextLine() 把 \r\n 已经去掉
            System.out.println("收到请求: " + request);

            // 业务处理
            String response = request;

            // 发送响应，也许要使用 \r\n 跟在后边，进行分割
            OutputStream os = socket.getOutputStream();
            // 封装成 PrintWriter
            PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(os, "UTF-8")
            );
            // 发送响应
            writer.println(response);   // println 会帮我们在后边增加 \r\n
            writer.flush();

            socket.close();
        }
    }
}