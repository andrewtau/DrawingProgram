import java.awt.*;
public class Triangle extends Item{
private Line line1;
private Line line2;
private Line line3;
private Point point1;
private Point point2;
private Point point3;

public Triangle(){
	
	line1 = null;
	line2 = null;
	line3 = null;
	point1 = null;
	point2 = null;
	point3 = null;
}

public Triangle(Point point1, Point point2)
{
	this.point1 = point1;
	this.point2 = point2;
	point3 = null;
}

public Triangle(Point point1, Point point2, Point point3)
{
	this.point1 = point1;
	this.point2 = point2;
	this.point3 = point3;
}

public Triangle(Line line, Point point3)
{
	this.line1 = line;
	this.point3 = point3;
}

public void render(){
uiContext.drawLine(point1, point2);
uiContext.drawLine(point2, point3);
uiContext.drawLine(point1, point3);
}

public boolean includes(Point point) {
    return ((distance(point, point1 ) < 10.0) || (distance(point, point2)< 10.0));
}

public void setLine1(Line line)
{
	line1 = line;
}

public void setLine2(Line line)
{
	line2 = line;
}

public void setLine3(Line line)
{
	line3 = line;
}

public void setPoint1(Point point) 
{
	point1 = point;
}
public void setPoint2(Point point) 
{
	point2 = point;
}

public void setPoint3(Point point)
{
	point3 = point;
}

public Line getLine1()
{
	return line1;
}

public Line getLine2()
{
	return line2;
}

public Line getLine3()
{
	return line3;
}

public Point getPoint1() 
{
	return point1;
}
public Point getPoint2() 
{
	return point2;
}

public Point getPoint3()
{
	return point3;
}

public String toString()
{
	return "Triangle";
	//return "Triangle from " + point1 + " to " + point2 + " to " + point3;
}

}