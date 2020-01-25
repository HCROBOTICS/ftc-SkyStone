package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.matrices.VectorF;

public class ControllerCommand extends Gamepad {
    /*
     * This class can be instantiated to make fake gamepad inputs that you can give to the hardware
     * objects to make them work without an actual controller. It also just feels cooler to do this
     * instead of addressing the individual motors.
     */

    public enum Command {
        FORWARD, BACKWARD, TURN_LEFT, TURN_RIGHT, STRAFE_LEFT, STRAFE_RIGHT, BLANK,
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
            case STRAFE_LEFT:
                left_stick_x = 1;
                break;
            case STRAFE_RIGHT:
                left_stick_x = -1;
                break;
            case BLANK:
                break;
        }
    }

    public ControllerCommand(float left_stick_x,  float left_stick_y,
                             float right_stick_x, float right_stick_y) {
        this.left_stick_x = left_stick_x;
        this.left_stick_y = left_stick_y;
        this.right_stick_x = right_stick_x;
        this.right_stick_y = right_stick_y;
    }
}
