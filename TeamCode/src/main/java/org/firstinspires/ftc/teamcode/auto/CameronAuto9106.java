package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.CameronRobot;
import org.firstinspires.ftc.teamcode.hardware.Odometer;

@Autonomous(name = "Cameron Auto 9106", group = "Cameron")
public class CameronAuto9106 extends CameronAuto {
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

        backward(2);
        sleep(PAUSE);

        left(16);
        sleep(PAUSE);

        forward(2);
        sleep(PAUSE);

        robot.stop();
    }
}
