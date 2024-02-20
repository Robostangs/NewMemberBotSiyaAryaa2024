// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.TeleopDriveCmd;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
  Drivetrain mDrive = Drivetrain.getInstance();
  XboxController devick = new XboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    mDrive.setDefaultCommand(new TeleopDriveCmd(
      () -> devick.getLeftY(),
      () -> devick.getRightY()
    ));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}