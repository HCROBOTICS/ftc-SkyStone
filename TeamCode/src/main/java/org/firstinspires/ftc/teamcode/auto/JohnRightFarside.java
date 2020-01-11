package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Autonomous (name = "John Right Farside")
public class JohnRightFarside extends JohnAuto {

    @Override public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();

        waitForStart();

        while(opModeIsActive()) {
            forward(1000);
            turnRight(RIGHT_TURN);
            driveToLine();
            break;
        }

        robot.stop();

    }
}
