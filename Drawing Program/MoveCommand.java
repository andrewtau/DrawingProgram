import java.awt.*;
import java.text.*;
import java.util.*;

public class MoveCommand extends Command {
  private Move move;
  private int pointCount;
  private Item item; // Testing this
  private Point point1, point2, point3;
  public MoveCommand() {
    this(null);
    pointCount = 0;
  }
  public MoveCommand(Point point) {
    move = new Move(point);
	if(++pointCount == 1){
	move.setStartingPoint(point);
	Enumeration enumeration = model.getItems();
  	item = (Item)(enumeration.nextElement());
      if (item.includes(point)) {
        model.markSelected(item);
      } else if(pointCount == 2)
		{
		System.out.println("Point Count is " + pointCount);
			move.setEndPoint(point);	  	
	  	}
	  } 
}	
	
  public MoveCommand(Point point1, Point point2) {
    move = new Move(point1, point2);
    pointCount = 2;
	Enumeration enumeration = model.getItems();
  	item = (Item)(enumeration.nextElement());
      if (item.includes(point1)) {
        model.moveSelectedItems(item, point1, point2);
      }
  }
	
  public void setMovePoint(Point point) {
    if (++pointCount == 1) {
	  move.setStartingPoint(point);
    } else if (pointCount == 2)	{
	  move.setEndPoint(point);
	  model.unSelect(item);	
    }
  }
  
  public void rerender()
  {
  	move.render();
  }
  
  // New method to check to see if an object is selected
  public boolean isSelected() {
   Enumeration enumeration = model.getSelectedItems();
   item = (Item)(enumeration.nextElement());
  	if(model.selected(item))
	{
		return true;
	}
	else{
		return false;
	}
  }
  
  // Testing this too
public void setPoint(Point point) {
Enumeration enumeration = model.getItems();
while (enumeration.hasMoreElements()) {
  	item = (Item)(enumeration.nextElement());
      if (item.includes(point)) {
        model.markSelected(item);
      }
    }
  }
  public void execute() {
    model.markSelected(item);
	//model.addItem(item);
	model.moveSelectedItems(item, move.getStartingPoint(), move.getEndPoint());
	//move.render(); 
  }
  public boolean undo() {
    model.unSelect(item);
    return true;
  }
  public boolean redo() {
    execute();
    return true;
  }
  
    public boolean end() {
    if (move.getStartingPoint() == null) {
      undo();
      return false;
    }
    if (move.getEndPoint() == null) {
       move.setEndPoint(move.getStartingPoint());
    }
    return true;
  }
}