
public class MyLifeBar extends MovingObject
{
  public MyLifeBar(double x, double y, double heading)
  {
    super(x, y, heading);
  }
  
  public void draw()
  {
    StdDraw.setPenColor(StdDraw.ORANGE);
    StdDraw.setPenRadius(1);
    StdDraw.filledRectangle(xPosition, yPosition, 10, 10);
  }
}
