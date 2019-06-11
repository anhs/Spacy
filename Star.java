/**
 * This is the Star class.
 * 
 * @author Anh Alexander Tran I received no help for this assingment
 */
public class Star
{
  private double x;
  private double y;

  public Star(double x, double y)
  {
    this.x = x;
    this.y = y;
  }

  /**
   * This method draws a star.
   */
  public void draw()
  {
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.filledCircle(this.x, this.y, 1);
  }

  public void move()
  {
    Vector2D vec = new Vector2D((3 * Math.PI) / 2, 1);
    Point point = new Point(this.x, this.y);
    point.moveAndWrap(vec, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
    this.x = point.xPosition;
    this.y = point.yPosition;
  }
}
