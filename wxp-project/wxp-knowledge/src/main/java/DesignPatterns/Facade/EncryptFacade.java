package DesignPatterns.Facade;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 15:52
 */
public class EncryptFacade {
    private CipherMachine cipherMachine;
    private FileReader reader;
    private FileWriter writer;

    public EncryptFacade(){
        cipherMachine= new CipherMachine();
        reader=new FileReader();
        writer= new FileWriter();
    }

    public void FileEncrypt(String  fileName) {
        cipherMachine.cipher(fileName);
        reader.read(fileName);
        writer.fileWriter(fileName);

    }
}
