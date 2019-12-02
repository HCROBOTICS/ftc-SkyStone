package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@TeleOp(name = "John Tele Op", group = "John")
public class JohnTeleOp extends OpMode {
    JohnRobot robot;

    @Override
    public void init() {
        robot = new JohnRobot(hardwareMap);
        robot.init();

        // Compensate for the fact that the motors all face a different direction.
        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);

        telemetry.addData("Robot", "Ready");
        telemetry.update();
    }

    @Override
    public void start() {
        robot.grab.setPosition(0);
        robot.wrist.setPosition(0);
    }

    @Override
    public void loop() {
        robot.wheels.goJoystick(gamepad1);
        robot.lift.move(gamepad1.right_trigger - gamepad1.left_trigger);
        robot.rotate.setPower((gamepad1.left_bumper? 1:0) - (gamepad1.right_bumper? 1:0));

        if (gamepad1.a)
            robot.grab.setPosition(0.5);
        else if (gamepad1.b)
            robot.grab.setPosition(1);

        if (gamepad1.x)
            robot.wrist.setPosition(robot.wrist.getPosition() - 0.005);
        else if (gamepad1.y)
            robot.wrist.setPosition(robot.wrist.getPosition() + 0.005);
    }
}
