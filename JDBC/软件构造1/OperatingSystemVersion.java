package JDBC.软件构造1;

public  abstract class OperatingSystemVersion {
    VideoFile videoFile;

    public void setVideoFile(VideoFile videoFile) {
        this.videoFile = videoFile;
    }
    abstract void play(String fileName);
}
