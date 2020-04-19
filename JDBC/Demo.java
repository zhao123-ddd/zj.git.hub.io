import java.sql.*;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://127.0.0.1:3306/java_14?useSSL=false&characterEncoding=utf8";
        Connection connection= DriverManager.getConnection(url,"root","");
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("mysql>");
            String sql=scanner.nextLine();
            if(sql.equals("quit")){
                break;
            }
            // 创建语句对象
            Statement statement=connection.createStatement();
            if(sql.startsWith("select")){
              //结果集
                ResultSet rs=statement.executeQuery(sql);
            ResultSetMetaData metaData=rs.getMetaData();
            int col=metaData.getColumnCount();
            for(int i=0;i<col;i++){
                String result=metaData.getColumnName(i+1);
                System.out.print(result+" ");
            }
                System.out.println();
            while(rs.next()){
                for (int i=0;i<col;i++){
                    String result1=rs.getString(i+1);
                    System.out.print(result1+" ");
                }
                System.out.println();
            }
            rs.close();
            } else {
                int n=statement.executeUpdate(sql);
                System.out.printf("%d受到影响%n"+n);
            }
            statement.close();
        }
       connection.close();
    }
    char a;


}
