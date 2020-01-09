package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.CameronRobot;

@TeleOp(name = "Cameron Tele Op", group = "Cameron")
public class CameronTeleOp extends OpMode {
    CameronRobot robot;

    @Override
    public void init() {
        robot = new CameronRobot(hardwareMap);
        robot.init();

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
    }
}
