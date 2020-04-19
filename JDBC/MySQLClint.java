import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class MySQLClint {
    private static String ip;
    private static int port;
    private static String user;
    private static String password;
    private static String defaultDatabase;

    private static void parseArgs(String[] args) {
        ip = args[0].substring(2);
        port = Integer.parseInt(args[1].substring(2));
        user = args[2].substring(2);
        defaultDatabase = args[4];
        System.out.print("Enter password: ");
        Scanner scanner = new Scanner(System.in);
        password = scanner.nextLine();

        System.out.println(ip);
        System.out.println(port);
        System.out.println(user);
        System.out.println(password);
        System.out.println(defaultDatabase);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 模仿从参数中获取MySQL Server的信息
        parseArgs(args);

        // 1. 注册 Driver
        // 用 java 语言的角度说：通过 反射机制（运行时操作类信息的一种方法）加载 com.mysql.jdbc.Driver 类
        // 可能抛异常——受查异常   加到方法签名上 OR try-catch 掉
        Class.forName("com.mysql.jdbc.Driver"); // 传入的是类的名称是个 String 类型

        // 2. 通过 DriverManager 获取 MySQL 网络连接 java.sql.Connection
        // 需要 URL、数据库的用户名、数据库的密码
        String url = "jdbc:mysql://127.0.0.1:3306/java14_0308?useSSL=false&characterEncoding=utf8";
        // 也会抛出受查异常 —— SQLException
        Connection connection = DriverManager.getConnection(url, "root", "");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String sql = scanner.nextLine();
            if (sql.trim().isEmpty()) {
                continue;
            }

            if (sql.equalsIgnoreCase("quit")) {
                break;
            }

            Statement statement = connection.createStatement();

            String firstWord = sql.split(" ")[0];
            if (firstWord.equalsIgnoreCase("select")
                    || firstWord.equalsIgnoreCase("show")
                    || firstWord.equalsIgnoreCase("desc")) {
                // 有结果的 SQL
                executeSQLWithResult(statement, sql);
            } else {
                // 没有结果的 SQL
                executeSQLWithoutResult(statement, sql);
            }

            statement.close();
        }

        // 4. 关闭连接
        connection.close();
    }

    private static void executeSQLWithoutResult(Statement statement, String sql) throws SQLException {
        int 受到影响的行数 = statement.executeUpdate(sql);
        System.out.println("受到影响的行数是: " +  受到影响的行数);
    }

    private static void executeSQLWithResult(Statement statement, String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);

        // 取到结果集元信息
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 0; i < columnCount; i++) {
            String columnName = metaData.getColumnName(i + 1);
            System.out.print(columnName + " ");
        }
        System.out.println();

        while (rs.next()) {
            for (int i = 0; i < columnCount; i++) {
                String value = rs.getString(i + 1);
                System.out.print(value + " ");
            }
            System.out.println();
        }

        rs.close();
    }
}
