//this class will not be used in matches, only as an inherited class

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.auto.Auto;
import org.firstinspires.ftc.teamcode.auto.ControllerCommand;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

import static org.firstinspires.ftc.teamcode.auto.ControllerCommand.Command.*;

@Autonomous (name = "John Drive To Line")
@Disabled public class JohnAuto extends Auto {
    protected JohnRobot robot;

    // used for making ninety-degree turns
    public static final int RIGHT_TURN = 2700;
    public static final int LEFT_TURN = -2700;

    void forward(int ticks) {
        robot.wheels.go(new ControllerCommand(FORWARD));
        robot.wheels.encoderReset();
        /* Wait until the motors have moved enough. */
        while (robot.wheels.encoderAverageLeft() < ticks) {
            if (!opModeIsActive()) break;
        }

        robot.stop();
    }

    void turnLeft(int ticks) {
        robot.wheels.go(new ControllerCommand(TURN_LEFT));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageLeft() < ticks) {
            if (!opModeIsActive()) break;
        } // do nothing

        robot.stop();
    }

    void turnRight (int ticks) {
        robot.wheels.go(new ControllerCommand(TURN_RIGHT));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageLeft() < ticks); // do nothing

        robot.stop();
    }

    void backward (int ticks) {
        robot.wheels.go(new ControllerCommand(BACKWARD));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageLeft() < ticks) {
            if (!opModeIsActive()) break;
        }

        robot.wheels.stop();
    }

    void driveToLine() {
        robot.wheels.go(new ControllerCommand(FORWARD));

        /* Wait until the color sensor sees a line. */
        while (robot.color_sensor_down.alpha() < JohnRobot.LINE_LUMINOSITY) {
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

    void grab_skystone(){
        //lower rotate
        robot.rGrab.setPosition(.8);
        robot.lGrab.setPosition(.15);
        //raise rotate
    }
    void release_skystone() {
        robot.rGrab.setPosition(.45);
        robot.lGrab.setPosition(.5);
        //raise rotate?
    }

    void resetRotate() {
        robot.rotate.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rotate.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}

