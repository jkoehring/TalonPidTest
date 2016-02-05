package org.usfirst.frc.team1165.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1165.robot.Robot;

/**
 *
 */
public class SetThrottle extends Command
{

	public SetThrottle()
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.speedController);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.speedController.setThrottle(SmartDashboard.getNumber("Set Throttle"));
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
