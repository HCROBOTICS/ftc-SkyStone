package org.firstinspires.ftc.teamcode.hardware;

import org.firstinspires.ftc.robotcore.external.navigation.Position;

public class Odometer {
    private Wheels wheels;
    private Position position;

    public Odometer(Wheels wheels, Position position) {
        this.wheels = wheels;
        this.position = position;
    }

    /* positive is forwards and negative is backwards. */
    public double getDistanceForward() {
        double r = (wheels.encoderAverageLeft() + wheels.encoderAverageRight()) / 2;
        r /= wheels.ticksPerInch();

        return r;
    }

    public void goDistanceForward(double inches) {
        int targetTicks = (int)(wheels.ticksPerInch() * inches);
    }

    /* positive is right and negative is left. */
    public double getDistanceRight() {
        double r = (wheels.encoderAverageFront() + wheels.encoderAverageBack()) / 2;
        r /= wheels.ticksPerInch();

        return r;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
