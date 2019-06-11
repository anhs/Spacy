
public class SlowRocket extends MovingObject
{
  public SlowRocket(double x, double y, double heading)
  {
    super(x, y, heading);
  }

  public void draw()
  {
    StdDraw.setPenRadius(0.025);
    StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
    Pose pose = new Pose(this.xPosition, this.yPosition, heading);
    GameUtils.drawPoseAsTriangle(pose, 20, 20);
  }
}
