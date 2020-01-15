// waiting on values test

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Autonomous (name = "John Complex Red Bridge")
public class JohnComplexRedBridge extends JohnAuto{

    @Override
    public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();
        resetRotate();

        waitForStart();

        while (opModeIsActive()) {

            initGrab();

            forward(INITIAL_FORWARD);
            sleep(SLEEP_TIME);
            turnRight(TURN);
            sleep(SLEEP_TIME);
            backward(1000);

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
            backward(100);
            sleep(SLEEP_TIME);
            turnRight(TURN);
            sleep(SLEEP_TIME);

            driveToLine();
            forward(4000);

            sleep(SLEEP_TIME);
            turnLeft(TURN);
            sleep(SLEEP_TIME);

            release_skystone();

            sleep(SLEEP_TIME);
            backward(300);
            sleep(SLEEP_TIME);
            turnLeft(TURN);
            sleep(SLEEP_TIME);

            driveToLine();

            break;
        }
    }
}
