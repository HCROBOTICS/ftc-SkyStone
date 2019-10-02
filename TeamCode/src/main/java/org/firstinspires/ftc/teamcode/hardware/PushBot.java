package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class PushBot {
    private HardwareMap hw;
    public Wheels wheels;

    public PushBot(HardwareMap hw) {
        this.hw = hw;
    }

    public void init() {
        wheels = new Wheels(hw.dcMotor.get("rf"), hw.dcMotor.get("lf"), hw.dcMotor.get("rb"), hw.dcMotor.get("lb"));
        wheels.init();
        wheels.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void stop() {
        wheels.stop();
    }
}
