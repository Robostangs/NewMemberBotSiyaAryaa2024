// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ComplexAuto;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.FeedCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = Drivetrain.getInstance();
  private final Shooter m_shooter = Shooter.getInstance();

  // private final Intake m_Intake = Intake.getInstance();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
    new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */


  private void configureBindings() {
    // Schedule `DriveCommand` when `exampleCondition` changes to `true`
    /* new Trigger(m_drivetrain::exampleCondition)
        .onTrue(new DriveCommand(m_drivetrain, () -> m_driverController.getLeftTriggerAxis(), () -> m_driverController.getRightTriggerAxis(), () -> m_driverController.getLeftX()));
 */ 

    // Drivetrain controller
    m_drivetrain.setDefaultCommand(
    new DriveCommand(
        ()-> -m_driverController.getLeftX(),
        ()-> -m_driverController.getLeftY(), 
        ()-> m_driverController.getRightX()));

   // m_shooter.setDefaultCommand(new ShootCommand(()  -> m_driverController.getRightTriggerAxis()));
   // m_shooter.setDefaultCommand(new IntakeCommand(() -> m_driverController.getLeftTriggerAxis()));
    m_driverController.rightTrigger().whileTrue(new ShootCommand(() -> m_driverController.getRightTriggerAxis()));
    m_driverController.leftTrigger().onTrue(new IntakeCommand(() -> m_driverController.getLeftTriggerAxis()));
    m_driverController.a().onTrue(new FeedCommand());
    // m_driverController.rightTrigger().whileTrue(new ShootCommand(m_shooter, () -> m_driverController.getRightTriggerAxis()));
  
  // m_Intake.setDefaultCommand(new IntakeCommand(() -> m_driverController.getLeftTriggerAxis()));
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}

  public Command getAutonomousCommand() {
    return new Autos (Constants.kAutoDrive.driveTime, Constants.kAutoDrive.leftSpeed, Constants.kAutoDrive.rightSpeed, m_drivetrain);
  }
}
