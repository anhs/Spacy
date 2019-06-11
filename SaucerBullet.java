
public class SaucerBullet extends MovingObject
{
  public SaucerBullet(double x, double y, double heading)
  {
    super(x, y, heading);
  }

  public void draw()
  {
    StdDraw.setPenColor(StdDraw.CYAN);
    StdDraw.filledCircle(this.xPosition, this.yPosition, 10);
  }
}
