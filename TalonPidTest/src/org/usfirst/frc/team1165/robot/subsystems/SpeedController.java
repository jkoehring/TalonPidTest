package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.OperateSpeedControllerWithJoystick;
//import org.usfirst.frc.team1165.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SpeedController extends ReportableSubsystem
{

	private edu.wpi.first.wpilibj.CANTalon speedController = new CANTalon(0);
	// private edu.wpi.first.wpilibj.SpeedController speedController = new
	// Talon(0);

	public SpeedController()
	{
		speedController.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		speedController.configEncoderCodesPerRev(20);

		speedController.setP(0.75);
		speedController.setI(0.01);
		speedController.setD(0.0);
		
		speedController.setCloseLoopRampRate(.01);
		
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new Reporter(this));
		setDefaultCommand(new OperateSpeedControllerWithJoystick());
	}

	public void setThrottle(double speed)
	{
		speedController.setControlMode(TalonControlMode.PercentVbus.getValue());
		speedController.set(speed);
	}

	public void setRpm(double rpm)
	{
		speedController.setControlMode(TalonControlMode.Speed.getValue());
		speedController.set(rpm);
	}

	public void stopRpm()
	{
		//speedController.set(0);
		speedController.setControlMode(TalonControlMode.PercentVbus.getValue());
	}

	public void stopThrottle()
	{
		setThrottle(0);
	}

	@Override
	public void report()
	{
		SmartDashboard.putNumber("Cur Value", speedController.get());
		SmartDashboard.putNumber("Cur RPM", speedController.getSpeed());
	}
}
