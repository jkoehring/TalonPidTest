package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Operates the linear actuator using input from a joystick
 */
public class OperateSpeedControllerWithJoystick extends Command
{

	public OperateSpeedControllerWithJoystick()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.speedController);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		//Robot.speedController.setRpm()
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		double speed = Robot.oi.getSpeedControllerSpeed();
		
		// Treat a zone around the center position as zero to prevent fluctuating
		// motor speeds when the joystick is at rest in the center position.
		Robot.speedController.setThrottle(Math.abs(speed) >= .1 ? speed : 0);
		
		Robot.speedController.report();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		stop();
	}
	
	private void stop()
	{
		Robot.speedController.setThrottle(0);
	}
}
