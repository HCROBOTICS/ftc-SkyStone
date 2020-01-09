// eventually this class should be move until robot senses the color tape

package org.firstinspires.ftc.teamcode.auto;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.PushBot;
import com.qualcomm.robotcore.hardware.ColorSensor;
import static org.firstinspires.ftc.teamcode.auto.ControllerCommand.Command.*;

@Autonomous (name = "John Farside")
public class JohnLeftFarside extends Auto {
    private PushBot robot;

    //this is the downward facing color sensor used to sense the field lines
    ColorSensor color_sensor_down;


    @Override public void runOpMode() {
        robot = new PushBot(hardwareMap);
        robot.init();

        color_sensor_down = hardwareMap.colorSensor.get("color");

        // Compensate for the fact that the motors all face a different direction.
        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();


        while (opModeIsActive()) {

            forward (1000);
            turnLeft(1000);
            while (color_sensor_down.alpha() > 100) {
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

