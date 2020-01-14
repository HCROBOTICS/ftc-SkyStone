package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Autonomous (name = "John Start Right Farside")
public class JohnRightFarside extends JohnAuto {

    @Override public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();

        waitForStart();

        while (opModeIsActive()) {
            initGrab();

            forward(INITIAL_FORWARD);
            sleep(500);
            turnLeft(LEFT_TURN);
            sleep(500);
            driveToLine();
            break;
        }

        robot.stop();

    }
}
