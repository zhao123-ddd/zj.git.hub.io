package JDBC.软件构造;

public class Client {
    public static void main(String[] args) {
        LogFactory file=new FileLogFactory();
        LogFactory database=new DatabaseLogFactory();
        file.createLog();
        database.createLog();
    }
}
