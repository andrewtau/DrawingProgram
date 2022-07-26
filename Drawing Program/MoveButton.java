import javax.swing.*;
import java.awt.event.MouseAdapter;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class MoveButton  extends JButton implements ActionListener {
  protected JPanel drawingPanel;
  protected View view;
  private MouseHandler mouseHandler;
  private MoveCommand moveCommand;
  private UndoManager undoManager;
  public MoveButton(UndoManager undoManager, View jFrame, JPanel jPanel) {
    super("Move");
    addActionListener(this);
    view = jFrame;
    drawingPanel = jPanel;
    this.undoManager = undoManager;
    mouseHandler = new MouseHandler();
  }
  public void actionPerformed(ActionEvent event) {
    view.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    drawingPanel.addMouseListener(mouseHandler);
	
  }
  
private class MouseHandler extends MouseAdapter {
private int pointCount = 0;
private Point prevEvent;
private int currX, currY, newX, newY, newPosX, newPosY;  // Variables to keep track of position
public void mouseClicked(MouseEvent event) {
if (++pointCount == 1) {
//moveCommand.setPoint(View.mapPoint(event.getPoint()));
moveCommand = new MoveCommand(View.mapPoint(event.getPoint()));
prevEvent = event.getPoint();
undoManager.beginCommand(moveCommand);
currX = event.getX();
currY = event.getY();
} else if (pointCount == 2) {
	moveCommand.setMovePoint(View.mapPoint(event.getPoint()));
	//moveCommand = new MoveCommand(View.mapPoint(event.getPoint()));
	pointCount = 0;
	newX = event.getX();
	newY = event.getY();
	newPosX = newX - currX;
	newPosY = newY - currY;
	drawingPanel.setLocation(newPosX, newPosY);
	view.refresh();
	drawingPanel.removeMouseListener(this);
	view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	undoManager.endCommand(moveCommand);
      }
  }
}
}