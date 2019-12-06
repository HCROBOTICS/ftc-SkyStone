package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class CameronRobot extends PushBot {
    public CameronArm arm;

    public CameronRobot(HardwareMap hw) {
        super(hw);

        arm = new CameronArm(hw);
    }

    @Override
    public void init() {
        super.init();

        arm.init();

        wheels.lf.setDirection(DcMotorSimple.Direction.REVERSE);
        wheels.rf.setDirection(DcMotorSimple.Direction.FORWARD);
        wheels.lb.setDirection(DcMotorSimple.Direction.REVERSE);
        wheels.rb.setDirection(DcMotorSimple.Direction.FORWARD);
    }
}
