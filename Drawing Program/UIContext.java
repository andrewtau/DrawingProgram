import java.awt.*;
public interface UIContext {
  //  public abstract void drawCircle(Circle circle);
  public abstract void drawLine(Point point1, Point point2 );
  public abstract void draw(Point startingPoint, String text);
  public abstract void draw(Item item);
}
