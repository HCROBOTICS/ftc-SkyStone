package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.teamcode.auto.ControllerCommand;

import static java.lang.Math.min;

public class Odometer {
    private Wheels wheels;
    private Position position;

    private final double GO_SPEED_BOUND = 3;

    public Odometer(Wheels wheels, Position position) {
        this.wheels = wheels;
        this.position = position;
    }

    /* -X is left; +X is right */
    public double getDistanceX() {
        return wheels.encoderAverageX() / wheels.ticksPerInch();
    }

    /* -Y is forwards; +Y is backwards */
    public double getDistanceY() {
        return wheels.encoderAverageY() / wheels.ticksPerInch();
    }

    public void goY(double inches) {
        double toGo = getDistanceY() - inches;
    }

    /* This stuff will be used later. */
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
