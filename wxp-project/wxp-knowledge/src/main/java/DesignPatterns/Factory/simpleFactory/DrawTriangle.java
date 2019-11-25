package DesignPatterns.Factory.simpleFactory;

public class DrawTriangle implements Draw {
    @Override
    public void drawPic() {
        System.out.println("draw Triangle");
    }
}
