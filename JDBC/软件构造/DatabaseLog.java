package JDBC.软件构造;

public class DatabaseLog implements Log {
    public DatabaseLog(){
        this.writeLog();
    }
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录");
    }
}
