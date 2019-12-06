package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@TeleOp(name = "John Tele Op", group = "John")
public class JohnTeleOp extends OpMode {
    JohnRobot robot;

    public static double WRIST_SPEED = .005;

    @Override
    public void init() {
        robot = new JohnRobot(hardwareMap);
        robot.init();

        // Compensate for the fact that the motors all face a different direction.
        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);

        robot.wheels.lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.wheels.rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.wheels.lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.wheels.rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        telemetry.addData("Robot", "Ready");
        telemetry.update();
    }

    /*
    @Override
    public void start() {
        robot.grab.setPosition(0);
        robot.wrist.setPosition(0);
    }
    */

    @Override
    public void loop() {
        robot.wheels.goJoystick(gamepad1);
        robot.lift.move(-gamepad2.left_stick_y);
        robot.rotate.setPower(gamepad2.right_stick_y);

        if (gamepad2.left_bumper)
            robot.grab.setPosition(0.5);
        else if (gamepad2.right_bumper)
            robot.grab.setPosition(1);

        robot.wrist.setPosition(robot.wrist.getPosition() - WRIST_SPEED * (gamepad2.left_trigger - gamepad2.right_trigger));
    }
}
