package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;
import static org.firstinspires.ftc.teamcode.auto.ControllerCommand.Command.*;

public class JohnAuto extends Auto {
    protected JohnRobot robot;

    // used for making ninety-degree turns
    public static final int TURN = 2500;
    // how far we go to align ourselves with the blocks
    public static final int INITIAL_FORWARD = 3500;

    // positions for the two drag servos
    public static final int DRAG_DOWN = 1;
    public static final int DRAG_UP = 0;

    // how long we sleep
    public static final int SLEEP_TIME = 1000;

    void forward(int ticks) {
        robot.wheels.go(new ControllerCommand(FORWARD));
        robot.wheels.encoderReset();

        /* Wait until the motors have moved enough. */
        while (robot.wheels.encoderAverageJohn() < ticks) {
            if (!opModeIsActive()) break;
        }

        robot.stop();
    }

    void turnLeft(int ticks) {
        robot.wheels.go(new ControllerCommand(TURN_LEFT));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageJohn() < ticks) {
            if (!opModeIsActive()) break;
        } // do nothing

        robot.stop();
    }

    void turnRight (int ticks) {
        robot.wheels.go(new ControllerCommand(TURN_RIGHT));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageJohn() < ticks) {
            if (!opModeIsActive()) break;
        }// do nothing

        robot.stop();
    }

    void backward (int ticks) {
        robot.wheels.go(new ControllerCommand(BACKWARD));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageJohn() < ticks) {
            if (!opModeIsActive()) break;
        }

        robot.wheels.stop();
    }

    void JohnStrafe (int ticks, double power) {
        robot.wheels.rf.setPower(-0.5);
        robot.wheels.lf.setPower(-0.5);
        robot.wheels.lb.setPower(power);
        robot.wheels.rb.setPower(-power);

        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageJohn() < ticks) {
            if (!opModeIsActive()) break;
        }

        robot.wheels.stop();
    }

    void driveToLine() {
        robot.wheels.go(new ControllerCommand(FORWARD));

        /* Wait until the color sensor sees a line. */
        while (Math.abs(robot.color_sensor_down.blue() - robot.color_sensor_down.red()) < 250) {
            if (!opModeIsActive()) break;
        }

        robot.wheels.stop();
    }

    void driveToLineStrafe(double power) {
        robot.wheels.rf.setPower(-0.5);
        robot.wheels.lf.setPower(-0.5);
        robot.wheels.lb.setPower(power);
        robot.wheels.rb.setPower(-power);

        /* Wait until the color sensor sees a line. */
        while (Math.abs(robot.color_sensor_down.blue() - robot.color_sensor_down.red()) < 250) {
            if (!opModeIsActive()) break;
        }

        robot.wheels.stop();
    }

    void driveToLineReverse() {
        robot.wheels.go(new ControllerCommand(BACKWARD));

        /* Wait until the color sensor sees a line. */
        while (Math.abs(robot.color_sensor_down.blue() - robot.color_sensor_down.red()) < 500) {
            if (!opModeIsActive()) break;
        }

        robot.wheels.stop();
    }

    void wheelsInit() {
        // Compensate for the fact that the motors all face a different direction.
        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);
    }

    void resetRotate() {
        robot.rotate.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rotate.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    void initGrab() {
        robot.lGrab.setPosition(1);
        robot.rGrab.setPosition(0);
    }

    void initJohn() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();
        resetRotate();
    }
}

