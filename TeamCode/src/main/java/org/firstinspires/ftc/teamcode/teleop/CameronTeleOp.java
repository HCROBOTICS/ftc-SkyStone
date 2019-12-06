package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.CameronRobot;
import org.firstinspires.ftc.teamcode.hardware.PushBot;

@TeleOp(name = "Cameron Tele Op", group = "Cameron")
public class CameronTeleOp extends OpMode {
    CameronRobot robot;

    @Override
    public void init() {
        robot = new CameronRobot(hardwareMap);
        robot.init();

        telemetry.addData("Robot", "Ready");
        telemetry.update();
    }

    @Override
    public void loop() {
        robot.wheels.goJoystick(gamepad1);
        robot.arm.go(gamepad2);
    }
}
