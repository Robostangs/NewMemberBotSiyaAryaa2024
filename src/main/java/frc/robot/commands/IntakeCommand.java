package frc.robot.commands;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.ShootCommand;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeCommand extends Command {

     private Shooter mShooter = Shooter.getInstance();

    private DoubleSupplier leftTrigger;
    private double xButtonValue;

    private double ShooterMotorSpeed;

    public IntakeCommand(DoubleSupplier leftTrigger) {
        this.leftTrigger = leftTrigger;

        addRequirements(mShooter);

    }

    @Override
    public void execute() {

        mShooter.setFront(-1*leftTrigger.getAsDouble()*Constants.kShooter.shootMulti);

    }

    @Override
    public void initialize() {
    }

    // Running end
    @Override
    public void end(boolean interrupted) {
        mShooter.setFront(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }


}
