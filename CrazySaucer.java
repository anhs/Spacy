
public class CrazySaucer extends MovingObject
{
  public CrazySaucer(double x, double y, double heading)
  {
    super(x, y, heading);
  }

  public void draw()
  {
    StdDraw.setPenRadius(0.025);
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.filledCircle(xPosition, yPosition, 80);
    StdDraw.filledSquare(xPosition-80, yPosition, 10);
    StdDraw.filledSquare(xPosition+80, yPosition, 10);
    StdDraw.filledSquare(xPosition, yPosition-80, 10);
    StdDraw.filledSquare(xPosition, yPosition+80, 10);
    StdDraw.filledCircle(xPosition-60, yPosition-60, 10);
    StdDraw.filledCircle(xPosition-60, yPosition+60, 10);
    StdDraw.filledCircle(xPosition+60, yPosition-60, 10);
    StdDraw.filledCircle(xPosition+60, yPosition+60, 10);



    
  }
  
  
}
