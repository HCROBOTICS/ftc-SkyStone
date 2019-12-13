package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.hardware.Gamepad;

public class ControllerCommand extends Gamepad {
    enum Command {
        FORWARD, BACKWARD,
        STOP
    }

    public ControllerCommand(Command cmd) {
        switch (cmd) {
            case FORWARD:
                left_stick_y = -1;
                break;
            case BACKWARD:
                left_stick_y = 1;
            case STOP:
                break;
        }
    }
}
