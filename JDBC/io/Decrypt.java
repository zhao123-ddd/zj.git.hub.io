package JDBC.io;

import java.io.*;

public class Decrypt {
    public static void main(String[] args) throws IOException {
        String secretKey = "Java14班";
        String srcPath = "加密后的情报文件.txt";
        String destPath = "解密后的情报文件.txt";

        try (InputStream is = new FileInputStream(srcPath)) {
            try (OutputStream os = new FileOutputStream(destPath)) {
                byte[] buffer = new byte[4096];
                int len;

                while ((len = is.read(buffer, 0, 4096)) != -1) {
                    decrypt(buffer, 0, len, secretKey);

                    os.write(buffer, 0, len);
                }

                os.flush();
            }
        }
    }

    private static byte calcSecretKey(String secretKey) throws IOException {
        byte k = 0;
        for (byte b : secretKey.getBytes("UTF-8")) {
            k += b;
        }

        return k;
    }

    private static void decrypt(byte[] buffer, int offset, int length, String secretKey) throws IOException {
        // 把每个 byte 都 + 一个值（从密钥计算得出）

        for (int i = 0; i < length; i++) {
            buffer[i + offset] = (byte)(buffer[i + offset] - calcSecretKey(secretKey));
        }
    }
}
