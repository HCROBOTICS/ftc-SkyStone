package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Wheels {
    public enum Motor {
        NEVEREST_60(1680); // from AndyMark's website

        public int ticksPerRevolution;

        Motor(int ticksPerRevolution) {
            this.ticksPerRevolution = ticksPerRevolution;
        }
    }

    public enum Wheel {
        MAX_MECANUM(3.858268); // Pitsco's website says that its diameter is 98 mm.

        Wheel(double diameter) {
            this.diameter = diameter;
        }

        public double diameter; // in inches

        private double circumference() {
            return diameter * Math.PI;
        }
    }

    public enum Direction {

    }

    public Wheel wheel;
    public Motor motor;

    public HardwareMap hw;
    public DcMotor rf;
    public DcMotor lf;
    public DcMotor rb;
    public DcMotor lb;

    public Wheels(HardwareMap hw) {
        wheel = Wheel.MAX_MECANUM;
        motor = Motor.NEVEREST_60;
        this.hw = hw;
    }

    public void init() {
        // Assign every DcMotor to a motor in the hardware map.
        rf = hw.dcMotor.get("rf");
        lf = hw.dcMotor.get("lf");
        rb = hw.dcMotor.get("rb");
        lb = hw.dcMotor.get("lb");
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
        // Compensate for the fact that the motors all face a different direction.
        lf.setDirection(DcMotor.Direction.REVERSE);
        rf.setDirection(DcMotor.Direction.FORWARD);
        lb.setDirection(DcMotor.Direction.REVERSE);
        rb.setDirection(DcMotor.Direction.FORWARD);
    }

    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior mode) {
        lf.setZeroPowerBehavior(mode);
        rf.setZeroPowerBehavior(mode);
        lb.setZeroPowerBehavior(mode);
        rb.setZeroPowerBehavior(mode);
    }

    public void go(Gamepad gamepad) {
        /* This is evil. Don't change it without understanding it first. */
        lf.setPower(-gamepad.left_stick_y + gamepad.right_stick_x - gamepad.left_stick_x);
        rf.setPower(-gamepad.left_stick_y - gamepad.right_stick_x + gamepad.left_stick_x);
        lb.setPower(-gamepad.left_stick_y + gamepad.right_stick_x + gamepad.left_stick_x);
        rb.setPower(-gamepad.left_stick_y - gamepad.right_stick_x - gamepad.left_stick_x);
    }

    public void encoderReset() {
        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void stop() {
        lf.setPower(0);
        rf.setPower(0);
        lb.setPower(0);
        rb.setPower(0);
    }

    public double ticksPerInch() {
        return motor.ticksPerRevolution / wheel.circumference();
    }

    /* John likes working with absolute values. */
    public int encoderAverageJohn() {
        return Math.abs(lf.getCurrentPosition() + lb.getCurrentPosition()) / 2;
    }

    public int encoderAverageLeft() {
        return (lf.getCurrentPosition() + lb.getCurrentPosition()) / 2;
    }

    public int encoderAverageRight() {
        return (rf.getCurrentPosition() + rb.getCurrentPosition()) / 2;
    }

    public int encoderAverageFront() {
        return (lf.getCurrentPosition() + rf.getCurrentPosition()) / 2;
    }

    public int encoderAverageBack() {
        return (lb.getCurrentPosition() + rb.getCurrentPosition()) / 2;
    }

    /* -X is left; +X is right */
    public int encoderAverageX() {
        int diagonal1 = (lf.getCurrentPosition() + rb.getCurrentPosition()) / 2;
        int diagonal2 = (rf.getCurrentPosition() + lb.getCurrentPosition()) / 2;

        return (diagonal1 - diagonal2) / 2;
    }

    /* -Y is forwards; +Y is backwards */
    public int encoderAverageY() {
        return (encoderAverageLeft() + encoderAverageRight());
    }
}