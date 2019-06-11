
public class Bullet extends MovingObject
{
  public Bullet(double x, double y, double heading)
  {
    super(x, y, heading);
  }

  public void draw()
  {
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.filledRectangle(this.xPosition, this.yPosition, 1, 5);
  }
  
  
  
  
  
  
}
