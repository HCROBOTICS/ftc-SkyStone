package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class JohnRobot extends PushBot {
    public JohnLift lift;

    public JohnRobot(HardwareMap hw) {
        super(hw);

        lift = new JohnLift(hw.dcMotor.get("lift"));
    }

    @Override
    public void init() {
        super.init();

        lift.init();
    }
}
