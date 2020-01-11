package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Autonomous(name = "John Complex Blue Depot")
public class JohnComplexBlueDepot extends JohnAuto{

    @Override
    public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();
        resetRotate();

        waitForStart();

        while (opModeIsActive()) {
            while (Math.abs(robot.rotate.getCurrentPosition()) < 100) {
                //move rotate so we fit under the bridge
            }

            forward(500);
            turnLeft(LEFT_TURN);
            forward(500);
            turnRight(RIGHT_TURN);

            while (robot.color_sensor_side.red() > 127.5) {
                robot.wheels.go(new ControllerCommand(ControllerCommand.Command.BACKWARD));
            }

            backward(150);
            turnLeft(LEFT_TURN);
            forward(100);

            grab_skystone();

            backward(600);

            turnLeft(LEFT_TURN);
            forward(4000);
            turnRight(RIGHT_TURN);
            forward(1000);

            release_skystone();

            // drop drag mechanism

            backward(1050);

            turnRight(RIGHT_TURN);
            driveToLine();

            break;
        }
    }
}
