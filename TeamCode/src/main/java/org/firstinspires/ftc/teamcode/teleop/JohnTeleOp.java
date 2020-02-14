package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@TeleOp(name = "John TeleOp", group = "John")
public class JohnTeleOp extends OpMode {
    JohnRobot robot;

    @Override
    public void init() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        robot.wheels.encoderReset();

        // Compensate for the fact that the motors all face a different direction.
        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);

        robot.wheels.lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.wheels.rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.wheels.lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.wheels.rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Robot", "Ready");
        telemetry.update();
    }

    // This is designed to loop as fast as possible to avoid bad latency.
    // Please don't add anything that isn't necessary. Thanks
    @Override
    public void loop() {
        robot.go(gamepad1, gamepad2);
        robot.lift.go(-gamepad2.left_stick_y);
        robot.rotate.setPower(-gamepad2.right_stick_y / 2);
        robot.wrist.setPower((gamepad2.right_trigger - gamepad2.left_trigger) / 2);

        if (gamepad2.left_bumper /* close */ )
            robot.lGrab.setPosition(.15);
            robot.rGrab.setPosition(.8);

        if (gamepad2.right_bumper /* open */ )
            robot.lGrab.setPosition(.6);
            robot.rGrab.setPosition(.25);

        if (gamepad1.a)
            robot.drag.setPosition(1);
        else
            robot.drag.setPosition(0);
    }
}
