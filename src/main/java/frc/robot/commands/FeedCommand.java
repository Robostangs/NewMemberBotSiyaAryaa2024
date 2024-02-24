package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class FeedCommand extends Command{
    private Shooter mShooter = Shooter.getInstance();
    // private BooleanSupplier a;
    public FeedCommand(){
        addRequirements(mShooter);
    }
    @Override
    public void execute(){
        mShooter.setBack(1);
    }
    @Override
    public void initialize() {
        System.out.println("Show command");
    }


    @Override
    public boolean isFinished() {
        return false;
    }
}
