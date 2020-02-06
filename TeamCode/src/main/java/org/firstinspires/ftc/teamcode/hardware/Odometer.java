package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.teamcode.auto.ControllerCommand;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Odometer {
    private Wheels wheels;

    private final double GO_SPEED_BOUND = 3;

    public Odometer(Wheels wheels) {
        this.wheels = wheels;
    }

    /* -X is left; +X is right */
    public double getDistanceX() {
        return wheels.encoderAverageX() / wheels.ticksPerInch();
    }

    /* -Y is forwards; +Y is backwards */
    public double getDistanceY() {
        return wheels.encoderAverageY() / wheels.ticksPerInch();
    }

    public double goTargetY(double target) {
        double distance = target - getDistanceY();
        double speed = speed(distance, getDistanceY());
        Wheels.Direction direction;
        if (distance < 0) direction = Wheels.Direction.FORWARDS;

        return speed(abs(distance), abs(wheels.encoderAverageY()));
    }

    /*
     * Given a target distance and current progress (both positive), calculate the appropriate speed
     * for the motors. To avoid slipping, which causes the encoders (and thus the odometer) to lose
     * accuracy, the motors accelerate and decelerate into and out of their movements.
     */
    private double speed(double distance, double progress, double bound) {
        double accelerate = progress / bound, decelerate = distance / bound;
        if (accelerate < .2) accelerate = .2; /* the motors will never move otherwise */
        if (decelerate > .2) decelerate = 0; /* the motors will stop too late otherwise */

        double power = min(accelerate, decelerate);
        return power;
    }

    /* This is so I don't have to constantly type GO_SPEED_BOUND, and I wanted to see if
     * polymorphism worked here.
     */
    private double speed(double distance, double progress) {
        return speed(distance, progress,  GO_SPEED_BOUND);
    }
}
