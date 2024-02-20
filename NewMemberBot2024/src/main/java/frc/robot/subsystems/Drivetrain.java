package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

/* This class is called a subsystem
 * A subsystem class is used to interact with a physical subsystem on the robot
 */
public class Drivetrain extends SubsystemBase {
    public static Drivetrain mDrive;

     private static CANSparkMax fl = new CANSparkMax(0, MotorType.kBrushless);
     private static CANSparkMax fr = new CANSparkMax(1, MotorType.kBrushless);
     private static CANSparkMax bl = new CANSparkMax(2, MotorType.kBrushless);
     private static CANSparkMax br = new CANSparkMax(3, MotorType.kBrushless);

    public Drivetrain() {
        fl.setInverted(false);
        fr.setInverted(false);
        bl.setInverted(false);
        br.setInverted(false);

        br.follow(fr);
        bl.follow(fl);
    }

    public static Drivetrain getInstance(){
        if (mDrive == null){
            mDrive = new Drivetrain();
        }
        return mDrive;
    }

    public void set(double l, double r){
        fl.set(l); fr.set(r);
    }
    
}
