// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest.Idle;
import com.revrobotics.CANSparkBase.IdleMode;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kShooterControllerPort = 0;
  }

  public static final String CANBUS_NAME = null;
  public static final int PIGEON2_ID = 1;

  // ID of Motors
  public abstract static class kDrivetrain {
    public static final int LEFT_LEADER_ID = 2;
    public static final int LEFT_FOLLOW_ID = 17;
    public static final int RIGHT_LEADER_ID = 14;
    public static final int RIGHT_FOLLOW_ID = 20;

    public static final IdleMode kIdleMode = IdleMode.kBrake;

    public final static double driveMulti = 0.4;
  }

  // Auto Constants
  public abstract static class kAutoDrive {
    public final static double driveTime = 10;
    public final static double leftSpeed = 0.5;
    public final static double rightSpeed = 0.5;
  }

  public abstract static class kShooter {
    public final static int LEFT_SHOOTING_MOTOR = 15;
    public final static int RIGHT_SHOOTING_MOTOR = 13;

    public final static double shootMulti = 0.6;

    public static final IdleMode kIdleMode = IdleMode.kBrake;
  }

  public abstract static class kXboxController {
    public final static int x = 1;
  }
    //public final static Idle motorState = Idle.kBrake;
  }