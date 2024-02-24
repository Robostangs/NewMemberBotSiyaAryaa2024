package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{

    /*  private final CANSparkMax m_leftShootingMotor = new CANSparkMax(Constants.kShooter.LEFT_SHOOTING_MOTOR, MotorType.kBrushless);
    private final CANSparkMax m_rightShootingMotor = new CANSparkMax(Constants.kShooter.RIGHT_SHOOTING_MOTOR, MotorType.kBrushless);

    public static Intake mIntake;

    public static Intake getInstance() {
        if (mIntake == null) {
            mIntake = new Intake();
        }
        return mIntake;
    }

    public Intake(){
        m_leftShootingMotor.setIdleMode(Constants.kShooter.kIdleMode);
        m_rightShootingMotor.setIdleMode(Constants.kShooter.kIdleMode);    

        m_leftShootingMotor.setInverted(true);
        m_rightShootingMotor.setInverted(false);
        m_rightShootingMotor.follow(m_leftShootingMotor);
    }

    public void setintake (double speed) {
        m_leftShootingMotor.set(-1*speed);
    }  */
}