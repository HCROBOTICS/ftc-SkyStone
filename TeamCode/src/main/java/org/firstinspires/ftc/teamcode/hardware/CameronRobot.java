package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class CameronRobot extends PushBot {
    public CameronRobot(HardwareMap hw) {
        super(hw);
    }

    @Override
    public void init() {
        super.init();

        wheels.lf.setDirection(DcMotorSimple.Direction.REVERSE);
        wheels.rf.setDirection(DcMotorSimple.Direction.FORWARD);
        wheels.lb.setDirection(DcMotorSimple.Direction.REVERSE);
        wheels.rb.setDirection(DcMotorSimple.Direction.FORWARD);
    }
}
