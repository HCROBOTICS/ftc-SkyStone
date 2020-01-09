// eventually this class should be move until robot senses the color tape

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.JohnRobot;
import org.firstinspires.ftc.teamcode.hardware.PushBot;
import com.qualcomm.robotcore.hardware.ColorSensor;
import static org.firstinspires.ftc.teamcode.auto.ControllerCommand.Command.*;

@Autonomous (name = "John Right Farside")
public class JohnRightFarside extends Auto {
    private JohnRobot robot;

    //this is the downward facing color sensor used to sense the field lines

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

            forward (1000);
            turnRight(1000);
            while (robot.color_sensor_down.alpha() < JohnRobot.LUMOSITY) {
                robot.wheels.go(new ControllerCommand(FORWARD));
            }

        }

    }

    void forward(int ticks) {
        ticks *= JohnAuto.linear_mult;
        robot.wheels.go(new ControllerCommand(FORWARD));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageLeft() < ticks); // do nothing

        robot.wheels.go(new ControllerCommand(STOP));
    }

    void turnLeft(int ticks) {
        ticks *= JohnAuto.turn_mult;
        robot.wheels.go(new ControllerCommand(TURN_LEFT));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageLeft() < ticks); // do nothing

        robot.wheels.go(new ControllerCommand(STOP));
    }

    void turnRight (int ticks) {
        ticks *= JohnAuto.turn_mult;
        robot.wheels.go(new ControllerCommand(TURN_RIGHT));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageLeft() < ticks); // do nothing

        robot.wheels.go(new ControllerCommand(STOP));
    }

    void backward (int ticks) {
        ticks *= JohnAuto.linear_mult;
        robot.wheels.go(new ControllerCommand(BACKWARD));
        robot.wheels.encoderReset();

        while (robot.wheels.encoderAverageLeft() < ticks); // do nothing

        robot.wheels.go(new ControllerCommand(STOP));
    }
}

