package JDBC.软件构造;

public class DatabaseLogFactory implements LogFactory {
    @Override
    public Log createLog() {
        return new DatabaseLog();
    }
}
