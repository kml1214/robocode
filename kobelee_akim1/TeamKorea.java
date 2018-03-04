package kobelee_akim1;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Team Korea - A robot by Andrew Kim and Kobe Lee
 */
public class TeamKorea extends Robot
{
	int count = 0; // Wall touch counter
	/**
	 * run: TeamKorea's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.pink,Color.pink,Color.blue); // body,gun,radar
		
		double x = getHeading();
		if (x <= 90)
			turnRight(90-x);
		else if (x <= 180)
			turnRight(180-x);
		else if (x <= 270)
			turnRight(270-x);
		else if (x <= 360)
			turnRight(360-x);
			
		// If statements make sure that the robot faces either top, left, right, or bottom upon initialization
		// so that the robot doesn't face odd directions  
		
		ahead(800);
		turnGunRight(180);
		turnRight(90);
	
		while(true){ // "true" while loop makes sure the two while loops in body reiterate repetitively
		while(count == 1 || (count%2 != 0)){ // accounts for the first wall hit, and every odd number wall hit after
			turnGunLeft(180);
			turnGunRight(180);
			ahead(100);	
		}
		while (count%2 == 0){ // accounts for all even-numbered wall hits
			turnGunRight(180);
			turnGunLeft(180);
			ahead(100);
			}
		}
	
		// Robot main loop
		
	}
	
	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		
		double distance = e.getDistance(); // Uses distance to determine amount of power in each shot
		
		if (distance<200)
		{
			fire(3);
		}		
		if (distance < 500)
		{
			fire(2);
		}
		if(distance < 800)
		{
			fire(1);
		}
		else
			fire(0.7);
		
	}
	
	public void onHitRobot(HitRobotEvent event) {
		back(60);
		if (count == 1)
			ahead(800); // when hits robot, continues to wall (safer)
	}

	
	

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		count++; // Increment of counter variable
		
		if (count == 1) // Behavior of first wall-hit
			back(10); 
		else // After the first wall hit, turns the robot around so that it can slide back and forth across the wall
			turnRight(180);
	
		
	}	
}
