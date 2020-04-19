package JDBC.软件构造1;

public class Client {
    public static void main(String[] args) {
         VideoFile AVIFile=new AVIFile();
         VideoFile RMVBFile=new RMVBFile();
         VideoFile MPEGFile=new MPEGFile();
         VideoFile WMVFile=new WMVFile();
         OperatingSystemVersion WindowsVersion=new WindowsVersion();
         OperatingSystemVersion LinuxVersion=new LinuxVersion();
         OperatingSystemVersion UnixVersion=new UnixVersion();
         WindowsVersion.setVideoFile(AVIFile);
         WindowsVersion.play("AVFile");
         System.out.println("------------------");
         LinuxVersion.setVideoFile(RMVBFile);
         LinuxVersion.play("RMVBFile");
         System.out.println("------------------");
         UnixVersion.setVideoFile(WMVFile);
         UnixVersion.play("WMVFile");
         System.out.println("------------------");
    }
}
