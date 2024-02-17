package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

/* This class is called a command
 * Commands essentially control a subsystem by utilizing the methods (funcitons) in the cammand
 * In this case, the "ForzaDrive" command uses the "setMotors" command from the drivetrain subsystem
 * This command is run during teleop
 */
public class TeleopDriveCmd extends CommandBase {

  

    /* This is the constructor for the command
     * In the "RobotContainer" file, you provide an instance of the drivetrain, and different "DoubleSupplier" values
     * The DoubleSupplier values provide updated values to the class as the program runs
     */
   
    
    // Initialize method is run when the command begins
    @Override
    public void initialize() {
    }

    // Execute method contains code for the "middle" of the command (most code will be written here)
    @Override
    public void execute() {
     
    }

    // End is run at the end of a command
    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
