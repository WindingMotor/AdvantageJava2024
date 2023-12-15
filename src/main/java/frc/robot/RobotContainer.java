package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import frc.robot.wmlib2.command.SwerveJoystick;
import frc.robot.wmlib2.sensor.IO_GyroReal;
import frc.robot.wmlib2.swerve.IO_ModuleReal;
import frc.robot.wmlib2.swerve.Swerve;

public class RobotContainer {

    private final CommandXboxController driverController = new CommandXboxController(3);

    private final Swerve swerve = new Swerve(
            new IO_ModuleReal(Constants.ModuleSettings.FRONTLEFT),
            new IO_ModuleReal(Constants.ModuleSettings.FRONTRIGHT),
            new IO_ModuleReal(Constants.ModuleSettings.BACKLEFT),
            new IO_ModuleReal(Constants.ModuleSettings.BACKRIGHT),
            new IO_GyroReal()
    );

    public RobotContainer(){

        configureBindings();

        Constants.DriverBindings driverBindings = Constants.DriverBindings.XBOX;

        swerve.setDefaultCommand(new SwerveJoystick(
                () -> driverBindings.xInverted ? -driverController.getRawAxis(driverBindings.xInput) : driverController.getRawAxis(driverBindings.xInput),
                () -> driverBindings.yInverted ? -driverController.getRawAxis(driverBindings.yInput) : driverController.getRawAxis(driverBindings.yInput),
                () -> driverBindings.rInverted ? -driverController.getRawAxis(driverBindings.rInput) : driverController.getRawAxis(driverBindings.rInput),
                () -> true,
                swerve
        ));
      
    }

    private void configureBindings(){
        // Add any additional bindings configuration here
    }

    public Command getAutonomousCommand(){
        return new PrintCommand("Test");
    }
  
}