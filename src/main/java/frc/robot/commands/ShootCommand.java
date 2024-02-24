package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.ShootCommand;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShootCommand extends Command {

    private Shooter mShooter = Shooter.getInstance();

    private DoubleSupplier rightTrigger;

    private double ShooterMotorSpeed;

    public ShootCommand(DoubleSupplier rightSupplier) {
        rightSupplier = rightTrigger;
        addRequirements(mShooter);
    }

    @Override
    public void execute() {
        // mShooter.setFront(rightTrigger.getAsDouble()*0.1);
                mShooter.setFront(0.1);

        SmartDashboard.putNumber("Shooter Motors Speed", ShooterMotorSpeed);
    }

    @Override
    public void initialize() {
        System.out.println("Show command");
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
