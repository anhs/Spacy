
public class SpaceShip extends MovingObject
{
  public SpaceShip(double x, double y, double heading)
  {
    super(x, y, heading);
  }

  public void draw()
  {
    StdDraw.setPenRadius(0.025);
    StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
    Pose pose = new Pose(this.xPosition, this.yPosition, heading);
    GameUtils.drawPoseAsTriangle(pose, GameConstants.MAIN_SHIP_WIDTH,
        GameConstants.MAIN_SHIP_HEIGHT);
    StdDraw.filledRectangle(this.xPosition - GameConstants.MAIN_SHIP_WIDTH,
        this.yPosition - GameConstants.MAIN_SHIP_HEIGHT / 3, GameConstants.SHIP_GUN_WIDTH,
        GameConstants.SHIP_GUN_HEIGHT);
    StdDraw.filledRectangle(this.xPosition + GameConstants.MAIN_SHIP_WIDTH,
        this.yPosition - GameConstants.MAIN_SHIP_HEIGHT / 3, GameConstants.SHIP_GUN_WIDTH,
        GameConstants.SHIP_GUN_HEIGHT);

  }

}
