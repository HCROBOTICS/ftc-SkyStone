package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Autonomous (name = "John Complex Blue Bridge")
@Disabled public class JohnComplexBlueBridge extends JohnAuto {

    @Override
    public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();

        waitForStart();

        while (opModeIsActive()) {
            while (Math.abs(robot.rotate.getCurrentPosition()) < 100) {
                //move rotate so we fit under the bridge
            }

            forward(1000);
            turnRight(RIGHT_TURN);
            forward(1000);

            while (robot.color_sensor_side.red() > 127.5) {
                robot.wheels.go(new ControllerCommand(ControllerCommand.Command.FORWARD));
            }

            forward(150);
            turnLeft(LEFT_TURN);
            forward(100);

            grab_skystone();

            backward(100);
            turnLeft(LEFT_TURN);
            forward(3000);
            turnRight(RIGHT_TURN);

            release_skystone();

            backward(300);
            turnRight(RIGHT_TURN);

            driveToLine();

            break;
        }
    }
}
