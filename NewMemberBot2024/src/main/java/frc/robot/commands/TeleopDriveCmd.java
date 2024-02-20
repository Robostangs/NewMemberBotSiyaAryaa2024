package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

/* This class is called a command
 * Commands essentially control a subsystem by utilizing the methods (funcitons) in the cammand
 * In this case, the "ForzaDrive" command uses the "setMotors" command from the drivetrain subsystem
 * This command is run during teleop
 */
public class TeleopDriveCmd extends Command {
    DoubleSupplier nick;
    DoubleSupplier devin;
    Drivetrain mDrive = Drivetrain.getInstance();

    public TeleopDriveCmd(DoubleSupplier pe, DoubleSupplier po){
        this.devin = po;
        this.nick = pe;
        addRequirements(mDrive);
    }
    
    // Initialize method is run when the command begins
    @Override
    public void initialize() {
    }

    // Execute method contains code for the "middle" of the command (most code will be written here)
    @Override
    public void execute() {
        mDrive.set(nick.getAsDouble(), devin.getAsDouble());
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
