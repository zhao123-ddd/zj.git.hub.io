package 网络;

import java.util.*;
import java.io.*;
import java.net.*;

public class TCP_Client {
    public static void main(String[] args) throws IOException {
        String request = "你好世界";
        if (args.length > 0) {
            request = args[0];
        }

        Socket socket = new Socket("127.0.0.1", 9898);

        OutputStream os = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(os, "UTF-8")
        );
        writer.println(request);
        writer.flush();

        InputStream is = socket.getInputStream();
        Scanner scanner = new Scanner(is, "UTF-8");

        String response = scanner.nextLine();
        System.out.println(response);

        socket.close();
    }
}
