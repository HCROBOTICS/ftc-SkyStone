// this class will not be used in matches, only as an inherited class
// it's just gonna turn into variables and methods

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

    /* sensor value to determine if block is skystone:
      OFFICIAL FIRST RED:  (237,  28,  36)
      OFFICIAL FIRST BLUE: (  0, 101, 179)
      OFFICIAL FIRST GRAY: (153, 153, 154)
      https://www.firstinspires.org/sites/default/files/uploads/resource_library/first-brand-guidelines-web-2015.pdf
    */
    public static final int RED_SENSOR_VALUE = 125;

    // how long we sleep
    public static final int SLEEP_TIME = 100;

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

        while (robot.wheels.encoderAverageJohn() < ticks); // do nothing

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

    void driveToLine() {
        robot.wheels.go(new ControllerCommand(FORWARD));

        /* Wait until the color sensor sees a line. */
        while (robot.color_sensor_down.alpha() < JohnRobot.LINE_LUMINOSITY) {
            if (!opModeIsActive()) break;
        }

        robot.wheels.stop();
    }

    void driveToLineReverse() {
        robot.wheels.go(new ControllerCommand(BACKWARD));

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

    void initGrab() {
        robot.lGrab.setPosition(1);
        robot.rGrab.setPosition(0);
    }
}

