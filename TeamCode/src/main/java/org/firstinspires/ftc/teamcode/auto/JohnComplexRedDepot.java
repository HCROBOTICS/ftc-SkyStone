// waiting on values test

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Autonomous(name = "John Complex Red Depot")
public class JohnComplexRedDepot extends JohnAuto{

    @Override
    public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();
        resetRotate();

        waitForStart();

        while (opModeIsActive()) {

            initGrab();

            driveToLine();
            forward(250);
            sleep(SLEEP_TIME);
            turnRight(TURN);
            sleep(SLEEP_TIME);
            forward(INITIAL_FORWARD);
            sleep(SLEEP_TIME);
            turnRight(TURN);
            sleep(SLEEP_TIME);

            while (robot.color_sensor_side.red() > RED_SENSOR_VALUE) {
                robot.wheels.go(new ControllerCommand(ControllerCommand.Command.FORWARD));
            }

            forward(150);
            sleep(SLEEP_TIME);
            turnLeft(TURN);
            sleep(SLEEP_TIME);
            forward(100);
            sleep(SLEEP_TIME);

            grab_skystone();

            sleep(SLEEP_TIME);

            driveToLineReverse();
            backward(300);

            sleep(SLEEP_TIME);
            turnRight(TURN);

            // yes theres supposed to be three
            driveToLine();
            driveToLine();
            driveToLine();

            sleep(SLEEP_TIME);
            turnLeft(TURN);
            sleep(SLEEP_TIME);
            forward(1000);
            sleep(SLEEP_TIME);

            release_skystone();

            // drop drag mechanism

            sleep(SLEEP_TIME);
            driveToLineReverse();

            // raise drag mechanism

            sleep(SLEEP_TIME);
            turnRight(TURN);
            sleep(SLEEP_TIME);
            driveToLineReverse();

            break;
        }
    }
}
