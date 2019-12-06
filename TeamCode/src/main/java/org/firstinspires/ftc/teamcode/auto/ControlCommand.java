package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.hardware.Gamepad;

public class ControlCommand extends Gamepad {
    enum Command {
        FORWARD, BACKWARD,
        STOP
    }

    public ControlCommand(Command cmd) {
        switch (cmd) {
            case FORWARD:
                left_stick_y = -1;
                break;
            case BACKWARD:
                left_stick_y = 1;
            default:
                break;
        }
    }
}
