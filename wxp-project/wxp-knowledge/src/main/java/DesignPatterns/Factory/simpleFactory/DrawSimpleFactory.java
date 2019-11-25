package DesignPatterns.Factory.simpleFactory;

public class DrawSimpleFactory {


   public static Draw setDraw(String type) throws UnSupportedShapeException {
       Draw draw;

       if(type.equals("circle")){
            draw= new DrawCircle();
        }else if(type.equals("circle")){
            draw=new DrawTriangle();
        }else{
            throw new UnSupportedShapeException(type);
        }
        return draw;
    }
}
