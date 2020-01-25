package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.teamcode.hardware.CameronRobot;
import org.firstinspires.ftc.teamcode.hardware.Odometer;

@TeleOp(name = "Cameron Tele Op", group = "Cameron")
public class CameronTeleOp extends OpMode {
    CameronRobot robot;
    Odometer odometer;

    @Override
    public void init() {
        robot = new CameronRobot(hardwareMap);
        robot.init();

        odometer = new Odometer(robot.wheels, new Position());

        telemetry.addData("Robot", "Ready");
        telemetry.update();

        robot.s0.setPosition(0.5);
        robot.s1.setPosition(0.5);
    }

    @Override
    public void loop() {
        robot.go(gamepad1, gamepad2); // move the wheels

        if (gamepad1.right_bumper) {
            robot.s0.setPosition(0.05);
            robot.s1.setPosition(0.95);
        } else if (gamepad1.left_bumper) {
            robot.s0.setPosition(0.6);
            robot.s1.setPosition(0.4);
        }

        telemetry.addData("X", odometer.getDistanceX());
        telemetry.addData("Y", odometer.getDistanceY());
        telemetry.addData("Turn", robot.wheels.encoderAverageJohn());

        if (gamepad1.b) {
            robot.wheels.encoderReset();
            telemetry.addData("Encoders", "reset");
        }
    }
}
