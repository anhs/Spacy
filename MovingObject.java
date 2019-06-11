
public abstract class MovingObject
{
  protected double xPosition;
  protected double yPosition;
  protected double heading;
  protected double speed = 0;
  protected Vector2D vec;
  
  public MovingObject(double x, double y, double heading)
  {
    xPosition = x;
    yPosition = y;
    this.heading = heading;
  }
  
  public void move(double heading)
  {
    Point point = new Point(this.xPosition, this.yPosition);
    point.move(vec);
    this.xPosition = point.xPosition;
    this.yPosition = point.yPosition;
  }
  
  public abstract void draw();
}
