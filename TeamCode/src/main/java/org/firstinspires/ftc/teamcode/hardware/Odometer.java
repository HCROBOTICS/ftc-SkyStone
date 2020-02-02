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

    public double goDistanceY(double target) {
        double distance = target - getDistanceY();

        return speed(distance, wheels.encoderAverageY());
    }

    /*
     * Given a target position and current progress, calculate the appropriate speed for the motors.
     * To avoid slipping, which causes the encoders (and thus the odometer) to lose accuracy, the
     * motors accelerate into their final
     */
    private double speed(double target, double progress, double bound) {
        return 0;
    }

    /* This is so I don't have to constantly type GO_SPEED_BOUND, and I wanted to see if
     * polymorphism worked here.
     */
    private double speed(double target, double progress) {
        return speed(target, progress,  GO_SPEED_BOUND);
    }
}
