// eventually this class should be move until robot senses the color tape

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Autonomous (name = "John Drive to Line")
public class JohnNearside extends JohnAuto {
    @Override public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();

        waitForStart();

        while (opModeIsActive()) {

            driveToLine();
            break;

        }

        robot.stop();
    }
}
