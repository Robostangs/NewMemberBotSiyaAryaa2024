// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj.Timer;

public final class Autos extends Command {

  private Drivetrain mDrivetrain;

  // how long you want to drive for
  double driveTime;

  double StartTime;
  double CurrentTime;

  // how fast
  double leftSpeed, rightSpeed;

  double Difference;
  boolean finish;
  
  public Autos (double driveTime, double leftSpeed, double rightSpeed, Drivetrain mDrivetrain) {
    this.mDrivetrain = mDrivetrain;
    this.driveTime = driveTime;
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
    addRequirements(mDrivetrain);
  }

  /** Example static factory for an autonomous command. */
  public static Command Auto(Drivetrain mDrivetrain) {
    return Commands.sequence(mDrivetrain.exampleMethodCommand(), new DriveCommand(null, null, null));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }

  @Override
  public void initialize () {
    StartTime = Timer.getFPGATimestamp();  //get what thime is when program starts  initTime
  }

  @Override
  public void execute () {
    CurrentTime = Timer.getFPGATimestamp();  //updating time

    Difference = CurrentTime - StartTime;
    if (Difference <= driveTime) {
      mDrivetrain.setSpeed(leftSpeed, rightSpeed);
    }
    else {
      finish = true;
      mDrivetrain.setSpeed(0, 0);
    }
  }

  @Override
  public void end (boolean interruped) {
    mDrivetrain.setSpeed(0, 0);
  }

  @Override
  public boolean isFinished () {
    return finish;
  }
}
