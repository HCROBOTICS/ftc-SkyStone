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
    }

    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior mode) {
        lf.setZeroPowerBehavior(mode);
        rf.setZeroPowerBehavior(mode);
        lb.setZeroPowerBehavior(mode);
        rb.setZeroPowerBehavior(mode);
    }

    public void goJoystick(Gamepad gamepad) {
        /* This is evil. Don't change it without understanding it first. */
        lf.setPower(-gamepad.left_stick_y + gamepad.right_stick_x + gamepad.left_stick_x);
        rf.setPower(-gamepad.left_stick_y - gamepad.right_stick_x - gamepad.left_stick_x);
        lb.setPower(-gamepad.left_stick_y + gamepad.right_stick_x - gamepad.left_stick_x);
        rb.setPower(-gamepad.left_stick_y - gamepad.right_stick_x + gamepad.left_stick_x);
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
}