package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.hardware.PushBot;

public class JohnTeleOp extends OpMode {
    PushBot robot;

    @Override
    public void init() {
        robot = new PushBot(hardwareMap);
        robot.init();

        telemetry.addData("Robot", "Ready");
        telemetry.update();
    }

    @Override
    public void loop() {
        robot.wheels.goJoystick(gamepad1);
    }
}
