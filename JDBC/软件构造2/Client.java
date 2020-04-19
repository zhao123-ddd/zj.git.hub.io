package JDBC.软件构造2;

public class Client {
    public static void main(String[] args) {
        EncryptFacade encryptFacade=new EncryptFacade();
        encryptFacade.fileEncrypt("A","B");
    }
}
