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

        robot.wheels.lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.wheels.rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.wheels.lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.wheels.rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

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
        robot.go(gamepad1, gamepad2);
        robot.lift.go(-gamepad2.left_stick_y);
        robot.rotate.setPower(-gamepad2.right_stick_y / 2);
        robot.wrist.setPower((gamepad2.right_trigger - gamepad2.left_trigger) / 2);

        //// counter-rotate rotate to compensate for angle changes if lift is the only thing moving
        /* if (gamepad2.left_stick_y != 0 && gamepad2.right_stick_y == 0) {
            robot.rotate.setPower((gamepad2.left_stick_y) / 5);
        } */

        if (gamepad2.left_bumper) {
            robot.lGrab.setPosition(0);
            robot.rGrab.setPosition(0.5);
        } else if (gamepad2.right_bumper) {
            robot.lGrab.setPosition(1);
            robot.rGrab.setPosition(0.5);
        }

        /* if (gamepad2.b) {
            robot.drag.setPosition(0);
        } else if (gamepad2.a) {
            robot.drag.setPosition(1);
        } */
    }
}
