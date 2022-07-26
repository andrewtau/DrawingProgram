import java.awt.*;
public class Move extends Item {
private Point startingPoint;
private Point endPoint;
private Point point1;
private Point point2;
private int pointCount;
private Triangle triangle;
private Line line;

public Move(Point point) {
pointCount = 1;
startingPoint = point;
}

public Move(Point point1, Point point2) {
	startingPoint = point1;
	endPoint = point2;
	pointCount = 2;
}

public void setStartingPoint(Point point) {
	startingPoint = point;
}

public Point getStartingPoint() {
	return startingPoint;
}

public void setEndPoint(Point point) {
endPoint = point;
}

public Point getEndPoint() {
return endPoint;
}

public boolean includes(Point point) {
    return ((distance(point, point1 ) < 10.0) || (distance(point, point2)< 10.0));
}

public void render() {
	uiContext.drawLine(startingPoint, endPoint);
}
}

