package JDBC.软件构造1;

public class AVIFile implements VideoFile{
    @Override
    public void decode(String osType, String fileName) {
        System.out.println(osType+"以"+fileName+"格式播放文件");
    }
}
