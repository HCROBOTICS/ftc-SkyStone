package org.firstinspires.ftc.teamcode.auto;

import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.teamcode.hardware.CameronRobot;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;
import org.firstinspires.ftc.teamcode.hardware.Odometer;
import org.firstinspires.ftc.teamcode.hardware.Vuforia;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import java.util.concurrent.ForkJoinPool;

import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;
import static org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit.mmPerInch;
import static org.firstinspires.ftc.teamcode.auto.ControllerCommand.Command.*;

@Autonomous (name = "Cameron Auto")
@Disabled
public abstract class CameronAuto extends LinearOpMode {
    protected CameronRobot robot;
    protected Vuforia vuforia;
    protected Odometer odometer;

    ControllerCommand.Command direction;

    @Override public void runOpMode() {
        robot = new CameronRobot(hardwareMap);
        robot.init();

        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);

        vuforia = new Vuforia(hardwareMap);
        vuforia.init();

        odometer = new Odometer(robot.wheels);

        waitForStart();

        vuforia.start();
        go();

        /* while (opModeIsActive()) {
            VuforiaTrackable look = vuforia.look();

            if (look != null) {
                // express position (translation) of robot in inches.
                VectorF translation = vuforia.getLastLocation().getTranslation();
                telemetry.addData("Pos (in)", "{X, Y, Z} = %.1f, %.1f, %.1f",
                        translation.get(0) / mmPerInch, translation.get(1) / mmPerInch, translation.get(2) / mmPerInch);

                // express the rotation of the robot in degrees.
                Orientation rotation = Orientation.getOrientation(vuforia.getLastLocation(), EXTRINSIC, XYZ, DEGREES);
                telemetry.addData("Rot (deg)", "{Roll, Pitch, Heading} = %.0f, %.0f, %.0f", rotation.firstAngle, rotation.secondAngle, rotation.thirdAngle);
            } else {
                telemetry.addData("Visible Target", "none");
            }

            telemetry.update();
        } */

        robot.stop();
        vuforia.stop();
    }

    abstract void go();

    void forward(int ticks) {
        robot.wheels.encoderReset();
        robot.wheels.go(new ControllerCommand(FORWARD));

        while (Math.abs(robot.wheels.encoderAverageY()) < ticks) {
            if (!opModeIsActive()) break;
        }

        robot.stop();
    }

    void backward(int ticks) {
        robot.wheels.encoderReset();

        while (Math.abs(robot.wheels.encoderAverageY()) < ticks) {
            if (!opModeIsActive()) break;

            robot.wheels.go(new ControllerCommand(BACKWARD));
        }

        robot.wheels.stop();
    }

    void left(int ticks) {
        robot.wheels.go(new ControllerCommand(STRAFE_LEFT));
        robot.wheels.encoderReset();

        while (Math.abs(robot.wheels.encoderAverageX()) < ticks) {
            if (!opModeIsActive()) break;
        }

        robot.wheels.stop();
    }

    void right(int ticks) {
        robot.wheels.encoderReset();
        robot.wheels.go(new ControllerCommand(STRAFE_RIGHT));

        while (Math.abs(robot.wheels.encoderAverageX()) < ticks) {
            if (!opModeIsActive()) break;
        }

        robot.wheels.stop();
    }

    void driveToLine(ControllerCommand control) {
        robot.wheels.go(control);

        /* Wait until the color sensor sees a line. */
        while (robot.color.blue() < 150 && robot.color.red() < 150) {
            if (!opModeIsActive()) break;
            telemetry.addData("Red", robot.color.red());
            telemetry.addData("Blue", robot.color.blue());
            telemetry.update();
        }

        robot.wheels.stop();
    }
}
