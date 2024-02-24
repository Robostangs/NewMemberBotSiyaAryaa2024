// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrain.SwerveDriveState;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** An example command that uses an example subsystem. */
public class DriveCommand extends Command {

  
  //@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  //private final Drivetrain m_subsystem;
  //
  ///**
  // * Creates a new ExampleCommand.
  // *
  // * @param subsystem The subsystem used by this command.
  // */
  //public DriveCommand(Drivetrain subsystem) {
  //  m_subsystem = subsystem;
  //  // Use addRequirements() here to declare subsystem dependencies.
  //  addRequirements(subsystem);
  //}

  private Drivetrain mDrivetrain = Drivetrain.getInstance();

  //Variables used to store trigger and joystic values from controller
  private DoubleSupplier leftTrigger, rightTrigger, leftJoy;
  private double leftTriggerValue, rightTriggerValue, leftJoyValue;
  private double overallSpeed;
  private double leftSpeed, rightSpeed;

  public DriveCommand(DoubleSupplier leftTrigger, DoubleSupplier rightTrigger, DoubleSupplier leftJoy) {
   // Auto-generated constructor stub
    this.leftTrigger = leftTrigger;
    this.rightTrigger = rightTrigger;
    this.leftJoy = leftJoy;

    addRequirements(mDrivetrain);
}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //converts trigger inputs into numberical values
    leftTriggerValue = leftTrigger.getAsDouble();
    rightTriggerValue = rightTrigger.getAsDouble();
    leftJoyValue = leftJoy.getAsDouble();

    // CALCULATE Right and Left Speed
    overallSpeed = rightTriggerValue - leftTriggerValue;

    leftSpeed = overallSpeed + leftJoyValue;
    rightSpeed = overallSpeed - leftJoyValue;

    // sending speed to drivetrain
    mDrivetrain.setSpeed(leftSpeed, rightSpeed);

    //print Certain variables to "SmartDashborad"
    SmartDashboard.putNumber("Overall Speed", overallSpeed);
    SmartDashboard.putNumber("Left Speed", leftSpeed);
    SmartDashboard.putNumber("Right Speed", rightSpeed);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Show command");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mDrivetrain.setSpeed(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
