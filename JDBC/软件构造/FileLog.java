package JDBC.软件构造;

public class FileLog implements  Log{
    public FileLog(){
        this.writeLog();
    }
    @Override
    public void writeLog() {
        System.out.println("文件日志记录");
    }
}
