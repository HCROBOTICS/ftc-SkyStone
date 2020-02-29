package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.CameronRobot;
import org.firstinspires.ftc.teamcode.hardware.Odometer;

@Autonomous(name = "Cameron Auto 7678 and 16225", group = "Cameron")
public class CameronAuto7678 extends CameronAuto {
    @Override public void runOpMode() {
        robot = new CameronRobot(hardwareMap);
        robot.init();

        odometer = new Odometer(robot.wheels, telemetry);

        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);

        robot.wheels.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        backward(24);
        sleep(PAUSE);

        right(16);
        sleep(PAUSE);

        robot.stop();
    }
}
