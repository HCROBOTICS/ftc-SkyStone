// john is using this as base code for his multiple autonomous classes

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

import static org.firstinspires.ftc.teamcode.auto.ControllerCommand.Command.*;

@Autonomous (name = "John Auto")
public class JohnAuto extends Auto {
    protected JohnRobot robot;

    // used to make auto-wide changes to distances the robot moves linearly
    public static final int LINEAR_MULT = 1;
    // used to make auto-wide changes to how much the robot turns
    public static final int TURN_MULT = 1;

    // used for making ninety-degree turns
    public static final int RIGHT_TURN = 2700;
    public static final int LEFT_TURN = -2700;


    @Override public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();

        // Compensate for the fact that the motors all face a different direction.
        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {
            /* This is dumb, but I don't have a better solution yet. */

            driveToLine();

            break; // Forgive me.
        }

        robot.stop();
    }

    void forward(int ticks) {
        ticks *= LINEAR_MULT;
        robot.wheels.go(new ControllerCommand(FORWARD));
        robot.wheels.encoderReset();

        /* Wait until the motors have moved enough. */
        while (robot.wheels.encoderAverageLeft() < ticks);

        robot.stop();
    }

    void turnLeft(int ticks) {
        ticks *= TURN_MULT;
        robot.wheels.go(new ControllerCommand(TURN_LEFT));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageLeft() < ticks); // do nothing

        robot.stop();
    }

    void turnRight (int ticks) {
        ticks *= TURN_MULT;
        robot.wheels.go(new ControllerCommand(TURN_RIGHT));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageLeft() < ticks); // do nothing

        robot.stop();
    }

    void backward (int ticks) {
        ticks *= LINEAR_MULT;
        robot.wheels.go(new ControllerCommand(BACKWARD));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageLeft() < ticks); // do nothing

        robot.wheels.stop();
    }

    void driveToLine() {
        robot.wheels.go(new ControllerCommand(FORWARD));

        /* Wait until the color sensor sees a line. */
        while (robot.color_sensor_down.alpha() < JohnRobot.LINE_LUMINOSITY);

        robot.wheels.stop();
    }
}

