package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.OperateSpeedControllerWithJoystick;
//import org.usfirst.frc.team1165.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.CANTalon;
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
		speedController.configEncoderCodesPerRev(20);
		//speedController.setPIDSourceType(pidSource);
		speedController.setP(0.75);
		speedController.setI(0.01);
		speedController.setD(0.0);
		
		speedController.setCloseLoopRampRate(.1);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new Reporter(this));
		setDefaultCommand(new OperateSpeedControllerWithJoystick());
	}

	public void setThrottle(double speed)
	{
		speedController.set(speed);
	}

	public void setRpm(double rpm)
	{
		speedController.setControlMode(TalonControlMode.Speed.getValue());
		speedController.set(rpm);
	}

	public void stopRpm()
	{
		speedController.set(0);
		speedController.setControlMode(TalonControlMode.PercentVbus.getValue());
	}

	@Override
	public void report()
	{
		SmartDashboard.putNumber("Cur Throttle", speedController.get());
		SmartDashboard.putNumber("Cur RPM", speedController.getSpeed());
	}
}
