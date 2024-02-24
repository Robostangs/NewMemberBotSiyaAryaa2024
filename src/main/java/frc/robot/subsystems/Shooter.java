package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.ArmFeedforward;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
import frc.robot.Constants.kShooter;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;

public class Shooter extends SubsystemBase{

    public static Shooter mShooter;
    
    private final CANSparkMax m_leftShootingMotor = new CANSparkMax(Constants.kShooter.LEFT_SHOOTING_MOTOR, MotorType.kBrushless);
    private final CANSparkMax m_rightShootingMotor = new CANSparkMax(Constants.kShooter.RIGHT_SHOOTING_MOTOR, MotorType.kBrushless);
    private final TalonSRX m_bottonMotor = new TalonSRX(8); 
    // private final TalonFX m_bottonMotor = new TalonFX(0); 

    public static Shooter getInstance() {
        if (mShooter == null) {
          mShooter = new Shooter();
        }
        return mShooter;
      }

    public Shooter() {
        // Brake
        m_leftShootingMotor.setIdleMode(Constants.kShooter.kIdleMode);
        m_rightShootingMotor.setIdleMode(Constants.kShooter.kIdleMode);    

        m_leftShootingMotor.setInverted(true);
        m_rightShootingMotor.setInverted(false);
       //  m_rightShootingMotor.follow(m_leftShootingMotor);
    }
    
    public void setFront (double front) {
        m_leftShootingMotor.set(front*kShooter.shootMulti);
        m_rightShootingMotor.set(front*kShooter.shootMulti);
    }

    public void setBack(double back){
        m_bottonMotor.set(TalonSRXControlMode.PercentOutput, back);
    }

   /*  public void setintake (double speed) {
        m_bottonMotor.set(speed);
    } */
}
