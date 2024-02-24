package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

public class ComplexAuto extends SequentialCommandGroup{

    public ComplexAuto(Drivetrain mDrivetrain) {
        addCommands(
            new Autos (5, 0.35, 0.35, mDrivetrain),
            new Autos(1, -0.25, -0.25, mDrivetrain)
        );
    }
}
