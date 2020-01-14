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
            forward (FARSIDE_FORWARD);
            turnRight(RIGHT_TURN);
            driveToLine();
            break;
        }

        robot.stop();

    }
}
