package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class CameronArm {
    private HardwareMap hw;
    DcMotor rightPivot;
    DcMotor leftPivot;
    DcMotor rightLift;
    DcMotor leftLift;

    public CameronArm(HardwareMap hw) {
        this.hw = hw;
    }

    public void init() {
        rightPivot = hw.dcMotor.get("rightpivot");
        leftPivot = hw.dcMotor.get("leftpivot");
        rightLift = hw.dcMotor.get("rightlift");
        leftLift = hw.dcMotor.get("leftlift");

        rightPivot.setPower(0);
        leftPivot.setPower(0);
        rightLift.setPower(0);
        leftLift.setPower(0);
    }

    public void go(Gamepad gamepad) {
        double power = 0;
        if (gamepad.dpad_up) power = -1;
        else if (gamepad.dpad_down) power = 1;

        rightPivot.setPower(power);
        leftPivot.setPower(power);
    }

    public void stop() {
        rightPivot.setPower(0);
        leftPivot.setPower(0);
        rightLift.setPower(0);
        leftLift.setPower(0);
    }
}
