package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.JohnLift;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;
import org.firstinspires.ftc.teamcode.hardware.PushBot;

@TeleOp(name = "John Tele Op", group = "John")
public class JohnTeleOp extends OpMode {
    JohnRobot robot;

    @Override
    public void init() {
        robot = new JohnRobot(hardwareMap);
        robot.init();

        telemetry.addData("Robot", "Ready");
        telemetry.update();
    }

    @Override
    public void loop() {
        robot.wheels.goJoystick(gamepad1);
        robot.lift.move(gamepad1.right_trigger - gamepad1.left_trigger);
    }
}
