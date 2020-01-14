package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Autonomous (name = "John Start Left Farside")
public class JohnLeftFarside extends JohnAuto {

    @Override public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();

        waitForStart();

        while (opModeIsActive()) {
            initGrab();

            forward (INITIAL_FORWARD);
            sleep(500);
            turnRight(RIGHT_TURN);
            sleep(500);
            driveToLine();
            break;
        }

        robot.stop();

    }
}
