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

        while(opModeIsActive()) {
            resetRotate();

            while (Math.abs(robot.rotate.getCurrentPosition()) < ROTATE_ROTATION) {
                robot.rotate.setPower(-0.5);
            }

            forward(INITIAL_FORWARD);
            turnLeft(LEFT_TURN);
            driveToLine();
            break;
        }

        robot.stop();

    }
}
