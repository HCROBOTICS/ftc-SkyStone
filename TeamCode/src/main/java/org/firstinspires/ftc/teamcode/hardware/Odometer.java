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
    private Telemetry telemetry;

    private final double GO_SPEED_BOUND = 6;

    public Odometer(Wheels wheels, Telemetry telemetry) {
        this.wheels = wheels;
        this.telemetry = telemetry;
    }

    /* -X is left; +X is right */
    public double getDistanceX() {
        return wheels.encoderAverageX() / wheels.ticksPerInch();
    }

    /* -Y is forwards; +Y is backwards */
    public double getDistanceY() {
        return wheels.encoderAverageY() / wheels.ticksPerInch();
    }

    public void goTargetY(double target) {
        wheels.encoderReset();
        double distance, speed;
        while (true) {
            distance = target - getDistanceY();
            telemetry.addData("Distance", distance);
            speed = speed(abs(distance), abs(getDistanceY()));
            speed /= 2;

            if (speed == 0) break;
            else wheels.go(Wheels.Direction.FORWARDS, distance > 0? speed : -speed);
        }
        wheels.stop();
    }

    /*
     * Given a target distance and current progress (both positive), calculate the appropriate speed
     * for the motors. To avoid slipping, which causes the encoders (and thus the odometer) to lose
     * accuracy, the motors accelerate and decelerate into and out of their movements.
     */
    private double speed(double distance, double progress, double bound) {
        double accelerate = progress / bound, decelerate = distance / bound;

        telemetry.addData("Accelerate", accelerate);
        telemetry.addData("Decelerate", decelerate);

        if (accelerate < .5) accelerate = .5; /* the motors will never move otherwise */
        if (decelerate < .5) decelerate = 0;  /* the motors will stop too late otherwise */
        double power = min(accelerate, decelerate);

        telemetry.addData("Power", power);
        if (power > 1) power = 1;

        telemetry.update();
        return power;
    }

    /* This is so I don't have to constantly type GO_SPEED_BOUND, and I wanted to see if
     * polymorphism worked here.
     */
    private double speed(double distance, double progress) {
        return speed(distance, progress,  GO_SPEED_BOUND);
    }
}
