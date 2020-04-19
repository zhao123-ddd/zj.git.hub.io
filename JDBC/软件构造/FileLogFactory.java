package JDBC.软件构造;

public class FileLogFactory implements LogFactory {

    @Override
    public Log createLog() {
        return new FileLog();
    }
}
