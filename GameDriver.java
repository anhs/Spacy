import java.awt.Color;

/**
 * Driver for the Asteroids application.
 * 
 * @author CS 159 Instructors
 * @version V1.0, 3/18
 *
 */
public class GameDriver
{

  /**
   * Create a game object and a display screen and execute the main update loop.
   * 
   * @param args
   *          - args[0] optional integer indicating the number of asteroids that appear on each
   *          level. If no argument is provided a default value will be used.
   */
  public static void main(String[] args)
  {
    SpaceApple sim;
    sim = new SpaceApple();

    StdDraw.setCanvasSize(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
    StdDraw.setXscale(0, GameConstants.SCREEN_WIDTH);
    StdDraw.setYscale(0, GameConstants.SCREEN_HEIGHT);
    StdDraw.enableDoubleBuffering();

    while (true)
    {
      StdDraw.clear(new Color(0,0,0));
      sim.update();
      sim.draw();
      StdDraw.show();
      StdDraw.pause(10);
    }

  }

}
