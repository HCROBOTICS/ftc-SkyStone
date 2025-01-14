package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class JohnLift {
    DcMotor motor;

    public JohnLift(DcMotor motor) {
        this.motor = motor;
    }

    public void init() {
        motor.setPower(0);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void go(double power) {
        motor.setPower(power);
    }
}
