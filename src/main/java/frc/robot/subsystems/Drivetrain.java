// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

/*
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.sim.Pigeon2SimState;
import com.ctre.phoenix6.sim.TalonFXSimState;
*/

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants.kDrivetrain;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//Drivetrain = Drive subsystem
public class Drivetrain extends SubsystemBase {
  
  public static Drivetrain mDrivetrain;
  
  private final CANSparkMax m_leftLeader = new CANSparkMax(Constants.kDrivetrain.LEFT_LEADER_ID, MotorType.kBrushless);
  private final CANSparkMax m_leftFollower = new CANSparkMax(Constants.kDrivetrain.LEFT_FOLLOW_ID, MotorType.kBrushless);
  private final CANSparkMax m_rightLeader = new CANSparkMax(Constants.kDrivetrain.RIGHT_LEADER_ID, MotorType.kBrushless);
  private final CANSparkMax m_rightFollower = new CANSparkMax(Constants.kDrivetrain.RIGHT_FOLLOW_ID, MotorType.kBrushless);

  /*
  This is for TalonFX 500
  private final TalonFX m_leftLeader = new TalonFX(Constants.kDrivetrain.LEFT_LEADER_ID);
  private final TalonFX m_leftFollower = new TalonFX(Constants.kDrivetrain.LEFT_FOLLOW_ID);
  private final TalonFX m_rightLeader = new TalonFX(Constants.kDrivetrain.RIGHT_LEADER_ID);
  private final TalonFX m_rightFollower = new TalonFX(Constants.kDrivetrain.RIGHT_FOLLOW_ID);
  

  // control the state of a simulated
  
  private final TalonFXSimState m_leftSimState = m_leftLeader.getSimState();
  private final TalonFXSimState m_leftFollowerSimState = m_leftFollower.getSimState();
  private final TalonFXSimState m_rightSimstate = m_rightLeader.getSimState();
  private final TalonFXSimState m_rightFollowerSimState = m_rightFollower.getSimState();
  */

  public static Drivetrain getInstance() {
    if (mDrivetrain == null) {
      mDrivetrain = new Drivetrain();
    }
    return mDrivetrain;
  }

  /** Creates a new ExampleSubsystem. */

  //Initialize all the devices
  public Drivetrain() {

    //LEFT wheels work as Counterclockwise, RIGHT wheels work C ckwise; they are invert
    // This inverts some motors so they all spin in the correct direction
    m_leftLeader.setInverted(false);
    m_leftFollower.setInverted(false);
    m_rightLeader.setInverted(true);
    m_rightFollower.setInverted(true);


    // Set the back wheels follow the front wheels 
    m_leftFollower.follow(m_leftLeader);
    m_rightFollower.follow(m_rightLeader);
    /* 
    m_leftFollower.setControl(new Follower(m_leftLeader.getDeviceID(), false));
    m_rightFollower.setControl(new Follower(m_rightLeader.getDeviceID(), false));
    */

    //Brake
    m_leftLeader.setIdleMode(Constants.kDrivetrain.kIdleMode);
    m_leftFollower.setIdleMode(Constants.kDrivetrain.kIdleMode);
    m_rightLeader.setIdleMode(Constants.kDrivetrain.kIdleMode);
    m_rightFollower.setIdleMode(Constants.kDrivetrain.kIdleMode);

    /*
    initializeLeftDriveTalonFX(m_leftLeader.getConfigurator());
    initializeLeftDriveTalonFX(m_leftFollower.getConfigurator());
    initializeRightDriveTalonFX(m_rightLeader.getConfigurator());
    initializeRightDriveTalonFX(m_rightFollower.getConfigurator());
    */
  }

  // Chassis Speeds of the motors
  // public ChassisSpeeds getcurrentRobotChassisSpeeds() {
  //   return m_kinematics.toChassisSpeeds(getState().ModuleStates);
  

    // allows commands to control the sppeds of the drivetrain motors
  public void setSpeed (double l, double r) {
      m_leftLeader.set(l*kDrivetrain.driveMulti);
      m_rightLeader.set(r*kDrivetrain.driveMulti);
  }

  private final double kGearRatio = 10.71;
    private final double kWheelRadiusInches = 3;

    /* Simulation model of the drivetrain */
  private final DifferentialDrivetrainSim m_driveSim = new DifferentialDrivetrainSim(
      DCMotor.getFalcon500Foc(2), // 2 CIMS on each side of the drivetrain.
       kGearRatio, // Standard AndyMark Gearing reduction.
       2.1, // MOI of 2.1 kg m^2 (from CAD model).
       26.5, // Mass of the robot is 26.5 kg.
       Units.inchesToMeters(kWheelRadiusInches), // Robot uses 3" radius (6" diameter) wheels.
       0.546, // Distance between wheels is _ meters.

       /*
       * The standard deviations for measurement noise:
       * x and y: 0.001 m
        * heading: 0.001 rad
        * l and r velocity: 0.1 m/s
        * l and r position: 0.005 m
        */
       /* Uncomment the following line to add measurement noise. */
      null // VecBuilder.fill(0.001, 0.001, 0.001, 0.1, 0.1, 0.005, 0.005)
   );

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}