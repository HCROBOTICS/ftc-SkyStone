package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class CameronRobot extends PushBot {
    public CameronArm arm;

    public Servo s0;
    public Servo s1;

    public CameronRobot(HardwareMap hw) {
        super(hw);

        arm = new CameronArm(hw);
        s0 = hw.servo.get("S0");
        s1 = hw.servo.get("S1");
    }

    @Override public void init() {
        super.init();

        arm.init();

        wheels.lf.setDirection(DcMotorSimple.Direction.REVERSE);
        wheels.rf.setDirection(DcMotorSimple.Direction.FORWARD);
        wheels.lb.setDirection(DcMotorSimple.Direction.REVERSE);
        wheels.rb.setDirection(DcMotorSimple.Direction.FORWARD);


    }

    @Override public void go(Gamepad gamepad1, Gamepad gamepad2) {
        wheels.go(gamepad1);
        arm.go(gamepad2);
    }
}
