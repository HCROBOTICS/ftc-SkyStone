// waiting on values test

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Disabled
@Autonomous(name = "John Complex Blue Depot", group = "John")
public class JohnComplexBlueDepot extends JohnAuto{

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
            turnLeft(TURN);
            sleep(SLEEP_TIME);
            forward(INITIAL_FORWARD);
            sleep(SLEEP_TIME);
            turnRight(TURN);
            sleep(SLEEP_TIME);

            while (robot.color_sensor_side.red() > RED_SENSOR_VALUE) {
                robot.wheels.go(new ControllerCommand(ControllerCommand.Command.BACKWARD));
            }

            backward(150);
            sleep(SLEEP_TIME);
            turnLeft(TURN);
            sleep(SLEEP_TIME);
            forward(100);
            sleep(SLEEP_TIME);

            grab_skystone();

            sleep(SLEEP_TIME);

            driveToLineReverse();

            sleep(SLEEP_TIME);
            turnLeft(TURN);
            sleep(SLEEP_TIME);

            // yes, there's supposed to be three
            driveToLine();
            driveToLine();
            driveToLine();

            sleep(SLEEP_TIME);
            turnRight(TURN);
            sleep(SLEEP_TIME);
            forward(1000);
            sleep(SLEEP_TIME);

            release_skystone();

            // drop drag mechanism

            sleep(SLEEP_TIME);
            driveToLineReverse();

            // raise drag mechanism

            turnRight(TURN);
            sleep(SLEEP_TIME);
            driveToLine();

            break;
        }
    }
}
