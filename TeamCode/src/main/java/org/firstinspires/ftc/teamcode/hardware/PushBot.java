package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Position;

public class PushBot {
    private HardwareMap hw;
    public Wheels wheels;
    public Odometer odometer;

    public PushBot(HardwareMap hw) {
        this.hw = hw;
        wheels = new Wheels(hw);
    }

    public void init() {
        wheels.init();
        wheels.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void go(Gamepad gamepad1, Gamepad gamepad2) {
        wheels.go(gamepad1);
    }

    public void stop() {
        wheels.stop();
    }
}
