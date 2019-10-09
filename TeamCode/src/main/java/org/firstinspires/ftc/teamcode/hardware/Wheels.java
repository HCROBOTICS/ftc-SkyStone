package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Wheels {
    private DcMotor rf;
    private DcMotor lf;
    private DcMotor rb;
    private DcMotor lb;

    public Wheels(DcMotor rf, DcMotor lf, DcMotor rb, DcMotor lb) {
        this.rf = rf;
        this.lf = lf;
        this.rb = rb;
        this.lb = lb;
    }

    public void init() {
        // Compensate for the fact that the motors all face a different direction.
        lf.setDirection(DcMotor.Direction.FORWARD);
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.REVERSE);
        // Stop all motors.
        lf.setPower(0);
        rf.setPower(0);
        lb.setPower(0);
        rb.setPower(0);
        // Set all motors to run with/without encoders.
        lf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior mode) {
        lf.setZeroPowerBehavior(mode);
        rf.setZeroPowerBehavior(mode);
        lb.setZeroPowerBehavior(mode);
        rb.setZeroPowerBehavior(mode);
    }

    public void goJoystick(Gamepad gamepad) {
        lf.setPower(gamepad.left_stick_y - gamepad.right_stick_x - gamepad.left_stick_x);
        rf.setPower(gamepad.left_stick_y + gamepad.right_stick_x + gamepad.left_stick_x);
        lb.setPower(gamepad.left_stick_y - gamepad.right_stick_x + gamepad.left_stick_x);
        rb.setPower(gamepad.left_stick_y + gamepad.right_stick_x - gamepad.left_stick_x);
    }

    public void stop() {
        lf.setPower(0);
        rf.setPower(0);
        lb.setPower(0);
        rb.setPower(0);
    }
}
