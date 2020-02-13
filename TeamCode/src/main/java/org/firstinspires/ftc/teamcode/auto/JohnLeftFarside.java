package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

import static java.lang.Math.min;

@Autonomous (name = "3. John Start Left Farside", group = "John")
public class JohnLeftFarside extends JohnAuto {

    @Override public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();

        waitForStart();

        while (opModeIsActive()) {
            initGrab();

            forward(INITIAL_FORWARD);
            sleep(500);
            turnRight(TURN);
            sleep(500);
            driveToLine();
            break;
        }

        robot.stop();

    }
}


/*
            while (opModeIsActive()) {
                double current = -robot.odometer.getDistanceY();
                if (Math.abs(current) < .2) current = 0;
                double target = 30;
                double distanceFromTarget = target - current;

                double speed_down = distanceFromTarget / 6; // as it slows down near the target
                double speed_up  = -current            / 6; // as it speeds up from the start
                double speed = min(speed_down, speed_up);
                if (speed < -1) speed = -1;

                telemetry.addData("Current", current);
                telemetry.addData("Target", target);
                telemetry.addData("distanceFromTarget", distanceFromTarget);
                telemetry.addData("Speed", speed);
                telemetry.update();
                robot.wheels.go(gamepad1);
            }
            */