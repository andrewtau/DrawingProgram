import java.awt.Graphics;
import java.awt.*;
public class NewSwingUI implements UIContext {
  private Graphics graphics;
  private static NewSwingUI swingUI;
  private NewSwingUI() {
  }
  public static NewSwingUI getInstance() {
    if (swingUI == null) {
      swingUI = new NewSwingUI();
    }
    return swingUI;
  }
  public  void setGraphics(Graphics graphics) {
    this.graphics = graphics;
  }
  public void draw(Point startingPoint, String text) {
    if (startingPoint != null) {
      if (text != null) {
        graphics.drawString(text, (int) startingPoint.getX(), (int) startingPoint.getY());
      }
    }
    int length = graphics.getFontMetrics().stringWidth(text);
    graphics.drawString("_", (int) startingPoint.getX() + length, (int) startingPoint.getY());
  }
  public void drawLine(Point point1,  Point point2) {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    if (point1 != null) {
      i1 = Math.round((float) (point1.getX()));
      i2 = Math.round((float) (point1.getY()));
      if (point2 != null) {
        i3 = Math.round((float) (point2.getX()));
        i4 = Math.round((float) (point2.getY()));
      } else {
        i3 = i1;
        i4 = i2;
      }
      graphics.drawLine(i1, i2, i3, i4);
    }
  }
  public void draw(Item item) {
    System.out.println( "Cant draw unknown Item \n");
  }
}