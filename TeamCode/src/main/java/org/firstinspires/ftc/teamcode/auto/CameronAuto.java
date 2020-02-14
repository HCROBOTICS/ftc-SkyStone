package org.firstinspires.ftc.teamcode.auto;

import org.firstinspires.ftc.teamcode.hardware.CameronRobot;
import org.firstinspires.ftc.teamcode.hardware.Odometer;
import org.firstinspires.ftc.teamcode.hardware.Vuforia;
import org.firstinspires.ftc.teamcode.hardware.Wheels;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import static org.firstinspires.ftc.teamcode.auto.ControllerCommand.Command.*;

@Autonomous (name = "Cameron Auto")
public class CameronAuto extends LinearOpMode {
    protected CameronRobot robot;
    protected Vuforia vuforia;
    protected Odometer odometer;

    ControllerCommand.Command direction;
    public static final int TURN = 2700;
    public static final int PAUSE = 500;

    @Override public void runOpMode() throws InterruptedException {
        robot = new CameronRobot(hardwareMap);
        robot.init();

        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);

        //vuforia = new Vuforia(hardwareMap);
        //vuforia.init();

        odometer = new Odometer(robot.wheels, telemetry);

        waitForStart();
        //vuforia.start();

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

        backward(2);
        sleep(PAUSE);

        turnRight(TURN);
        sleep(PAUSE);

        // Go to the foundation.
        backward(32);
        sleep(PAUSE);

        turnLeft(2700);
        sleep(PAUSE);

        backward(28);
        sleep(PAUSE);

        // Grab the foundation (waiting long enough for the servos to go down).
        robot.servosDown();
        sleep(1000);

        // Return to the corner.
        forward(36);
        sleep(PAUSE);

        // Release the foundation.
        robot.servosUp();
        sleep(1000);

        // Drive under the bridge.
        driveToLine(Wheels.Direction.RIGHT);

        robot.stop();
        //vuforia.stop();
    }

    void forward(double inches) {
        robot.wheels.encoderReset();
        robot.wheels.go(Wheels.Direction.FORWARDS, .25);

        while (Math.abs(odometer.getDistanceY()) < inches) {
            if (isStopRequested()) break;
        }

        robot.stop();
    }

    void backward(double inches) {
        robot.wheels.encoderReset();
        robot.wheels.go(Wheels.Direction.FORWARDS, -.25);

        while (Math.abs(odometer.getDistanceY()) < inches) {
            if (isStopRequested()) break;
        }

        robot.wheels.stop();
    }

    void left(double inches) {
        robot.wheels.encoderReset();
        robot.wheels.go(new ControllerCommand(STRAFE_LEFT));

        while (Math.abs(robot.wheels.encoderAverageX()) < inches) {
            if (isStopRequested()) break;
        }

        robot.wheels.stop();
    }

    void right(double inches) {
        robot.wheels.encoderReset();
        robot.wheels.go(new ControllerCommand(STRAFE_RIGHT));

        while (Math.abs(robot.wheels.encoderAverageX()) < inches) {
            if (isStopRequested()) break;
        }

        robot.wheels.stop();
    }

    void turnLeft(int ticks) {
        robot.wheels.encoderReset();
        robot.wheels.go(new ControllerCommand(TURN_LEFT));

        while (Math.abs(robot.wheels.encoderAverageJohn()) < ticks) {
            if (isStopRequested()) break;
        }

        robot.stop();
    }

    void turnRight (int ticks) {
        robot.wheels.go(new ControllerCommand(TURN_RIGHT));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageJohn() < ticks) {
            if (isStopRequested()) break;
        }

        robot.stop();
    }

    void driveToLine(Wheels.Direction direction) {
        robot.wheels.encoderReset();
        robot.wheels.go(direction, .5);

        /* Wait until the color sensor sees a line. */
        while (Math.abs(robot.color.blue() - robot.color.red()) < 150) {
            if (isStopRequested()) break;
        }

        robot.wheels.stop();
    }
}
