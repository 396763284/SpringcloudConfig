package DesignPatterns.Bridge;

public class TestClient {
    public static void main(String[] args) {
        Image image =new JPGImage();
        image.setImp(new IOSImp());
        image.parseFile("tttt");
    }
}
