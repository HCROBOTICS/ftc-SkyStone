package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class CameronRobot extends PushBot {
    public Servo s0;
    public Servo s1;

    public ColorSensor color;
    public DcMotor arm;

    public CameronRobot(HardwareMap hw) {
        super(hw);

        s0 = hw.servo.get("S0");
        s1 = hw.servo.get("S1");

        color = hw.colorSensor.get("color");

        arm = hw.dcMotor.get("arm");
    }

    @Override public void init() {
        super.init();

        wheels.lf.setDirection(DcMotorSimple.Direction.REVERSE);
        wheels.rf.setDirection(DcMotorSimple.Direction.FORWARD);
        wheels.lb.setDirection(DcMotorSimple.Direction.REVERSE);
        wheels.rb.setDirection(DcMotorSimple.Direction.FORWARD);

        servosUp();

        arm.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override public void go(Gamepad gamepad1, Gamepad gamepad2) {
        wheels.go(gamepad1);
    }

    public void servosDown() {
        s0.setPosition(0);
        s1.setPosition(1);
    }

    public void servosUp() {
        s0.setPosition(1);
        s1.setPosition(0);
    }
}
