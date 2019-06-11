import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * AsteroidsGame class.
 * 
 * @author Anh Alexander Tran 3/28/2019 I received no help for this class
 */

public class SpaceApple
{
  ArrayList<EnemyLifeBar> enemyLife = new ArrayList<>();
  ArrayList<MyLifeBar> myLife = new ArrayList<>();
  Random generator = new Random();
  CrazySaucer saucer;
  SpaceShip ship;
  Star[] stars = new Star[GameConstants.NUMBER_OF_STARS];
  ArrayList<Bullet> bullets = new ArrayList<>();
  ArrayList<SaucerBullet> sauceBullets = new ArrayList<>();
  ArrayList<SlowRocket> slowRockets = new ArrayList<>();


  /**
   * Constructor for the AsteroidsGame class.
   * 
   * @param numAsteroids
   *          number of asteroids
   */
  public SpaceApple()
  {
    
    // CrazySaucer
    saucer = new CrazySaucer(GameConstants.SCREEN_WIDTH / 2, GameConstants.SCREEN_HEIGHT * .75,
        3 * Math.PI / 2);
    ship = new SpaceShip(GameConstants.SCREEN_WIDTH / 2, GameConstants.SCREEN_HEIGHT / 6,
        (Math.PI) / 2);
  //creates my life bar
    for (int i = 0; i < 10; i++)
    {
      MyLifeBar life = new MyLifeBar((i+1)*10, 10, 0);
      myLife.add(life);
    }
    // creates stars
    for (int i = 0; i < GameConstants.NUMBER_OF_STARS; i++)
    {
      int x = random(GameConstants.SCREEN_WIDTH);
      int y = random(GameConstants.SCREEN_HEIGHT);
      stars[i] = new Star(x, y);
    }
  }

  // The heart of the game
  public void update()
  {
    // stars move
    for (int i = 0; i < stars.length; i++)
      stars[i].move();
    // ship moves up
    if (StdDraw.isKeyPressed(KeyEvent.VK_UP)
        && ship.yPosition < GameConstants.SCREEN_HEIGHT - GameConstants.MAIN_SHIP_HEIGHT)
    {
      ship.speed = 10;
      ship.vec = new Vector2D(Math.PI / 2, ship.speed);
      ship.move(Math.PI / 2);
    }
    // ship moves down
    if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && ship.yPosition > 0)
    {
      ship.speed = 6;
      ship.vec = new Vector2D(Math.PI * 1.5, ship.speed);
      ship.move(Math.PI * 1.5);
    }
    // ship moves left
    if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && ship.xPosition > 10)
    {
      ship.speed = 6;
      ship.vec = new Vector2D(Math.PI, ship.speed);
      ship.move(Math.PI);
    }
    // ship moves right
    if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && ship.xPosition < GameConstants.SCREEN_WIDTH - 10)
    {
      ship.speed = 6;
      ship.vec = new Vector2D(0, ship.speed);
      ship.move(0);
    }
    // create bullet
    if (StdDraw.hasNextKeyTyped())
    {
      if (StdDraw.nextKeyTyped() == ' ')
      {
        Bullet bullet = new Bullet(ship.xPosition - 15, ship.yPosition, Math.PI / 2);
        bullets.add(bullet);
        Bullet bullet1 = new Bullet(ship.xPosition + 15, ship.yPosition, Math.PI / 2);
        bullets.add(bullet1);
      }
    }

    // move saucer
    if (saucer.yPosition > GameConstants.SCREEN_HEIGHT - 80)
    {
      saucer.heading = (3*Math.PI)/2;
      saucer.vec = new Vector2D((3*Math.PI)/2, 30);
      saucer.move(3*Math.PI/2);
    }
    else if (saucer.yPosition < 80)
    {
      saucer.heading = Math.PI/2;
      saucer.vec = new Vector2D(Math.PI/2, 30);
      saucer.move(Math.PI/2);
    }
    else if (saucer.xPosition > GameConstants.SCREEN_WIDTH - 80)
    {
      saucer.heading = Math.PI;
      saucer.vec = new Vector2D(Math.PI, 30);
      saucer.move(Math.PI);
    }
    else if (saucer.xPosition < 80)
    {
      saucer.heading = 0;
      saucer.vec = new Vector2D(0, 30);
      saucer.move(0);
    }
    else
    {
      saucer.vec = new Vector2D(saucer.heading, 1.5);
      saucer.move(saucer.heading);
    }
    if (generator.nextDouble() < 0.025)
    {
      Random random = new Random();
      double randomHeading = 31 + (2 * Math.PI - 31) * random.nextDouble();
      saucer.heading = randomHeading;
    }


   
    //saucer bullet
    if (generator.nextDouble() < 0.05)
    {
      SaucerBullet sauceBullet = new SaucerBullet(saucer.xPosition, saucer.yPosition,
          (5 * Math.PI) / 4);
      sauceBullets.add(sauceBullet);
      SaucerBullet sauceBullet1 = new SaucerBullet(saucer.xPosition, saucer.yPosition,
          (3 * Math.PI) / 4);
      sauceBullets.add(sauceBullet1);
      SaucerBullet sauceBullet2 = new SaucerBullet(saucer.xPosition, saucer.yPosition,
          (Math.PI) / 4);
      sauceBullets.add(sauceBullet2);
      SaucerBullet sauceBullet3 = new SaucerBullet(saucer.xPosition, saucer.yPosition,
          (7 * Math.PI) / 4);
      sauceBullets.add(sauceBullet3);
    }
    //saucer slow rockets
    if (generator.nextDouble() < 0.02)
    {
      SlowRocket slowRocket = new SlowRocket(saucer.xPosition + 100, saucer.yPosition, 0);
      slowRockets.add(slowRocket);
      SlowRocket slowRocket1 = new SlowRocket(saucer.xPosition - 100, saucer.yPosition, Math.PI);
      slowRockets.add(slowRocket1);
      SlowRocket slowRocket2 = new SlowRocket(saucer.xPosition, saucer.yPosition - 100, (3*Math.PI) / 2);
      slowRockets.add(slowRocket2);
      SlowRocket slowRocket3 = new SlowRocket(saucer.xPosition, saucer.yPosition + 100, Math.PI / 2);
      slowRockets.add(slowRocket3);
    }
    //move slow rockets
    for (int i = 0; i < slowRockets.size(); i++)
    {
      slowRockets.get(i).vec = new Vector2D(slowRockets.get(i).heading, 3);
      slowRockets.get(i).move(slowRockets.get(i).heading);
    }
    // move bullets
    for (int i = 0; i < bullets.size(); i++)
    {
      bullets.get(i).vec = new Vector2D(bullets.get(i).heading, 20);
      bullets.get(i).move(bullets.get(i).heading);
    }
    // move saucer bullets
    for (int i = 0; i < sauceBullets.size(); i++)
    {
      sauceBullets.get(i).vec = new Vector2D(sauceBullets.get(i).heading, 7);
      sauceBullets.get(i).move(sauceBullets.get(i).heading);
    }

  }

  /**
   * This method draws the game's objects.
   */
  public void draw()
  {
 // draw stars
    for (int i = 0; i < stars.length; i++)
    {
      stars[i].draw();
    }
    // draw ship
    ship.draw();
    
    // draw bullets
    for (int i = 0; i < bullets.size(); i++)
    {
      bullets.get(i).draw();
    }
    // draw sauce bullets
    for (int i = 0; i < sauceBullets.size(); i++)
    {
      sauceBullets.get(i).draw();
    }
    //draw slow rockets
    for (int i = 0; i < slowRockets.size(); i++)
    {
      slowRockets.get(i).draw();
    }
    //draw life bar
    for (int i = 0; i < myLife.size(); i++)
    {
      myLife.get(i).draw();
    }
    // draw saucer
    saucer.draw();
  }

  public int random(int max)
  {
    Random x = new Random();
    return x.nextInt(max);
  }

}
