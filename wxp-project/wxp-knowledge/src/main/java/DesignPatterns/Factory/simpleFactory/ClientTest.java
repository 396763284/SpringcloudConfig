package DesignPatterns.Factory.simpleFactory;

public class ClientTest {
    public static void main(String[] args) {
        try {
            Draw draw= DrawSimpleFactory.setDraw("circle");
            draw.drawPic();
        } catch (UnSupportedShapeException e) {
            e.printStackTrace();
        }
    }
}
