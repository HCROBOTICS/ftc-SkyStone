package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.hardware.Gamepad;

public class ControllerCommand extends Gamepad {
    /*
     * This class can be instantiated to make fake gamepad inputs that you can give to the hardware
     * objects to make them work without an actual controller. It also just feels cooler to do this
     * instead of addressing the individual motors.
     */

    enum Command {
        FORWARD, BACKWARD, TURN_LEFT, TURN_RIGHT, STOP
    }

    public ControllerCommand(Command cmd) {
        switch (cmd) {
            case FORWARD:
                left_stick_y = -1;
                break;
            case BACKWARD:
                left_stick_y = 1;
                break;
            case TURN_LEFT:
                right_stick_x = -1;
                break;
            case TURN_RIGHT:
                right_stick_x = 1;
                break;
            case STOP:
                break;
        }
    }
}
