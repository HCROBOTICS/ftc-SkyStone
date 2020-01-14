package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Autonomous (name = "John Complex Blue Bridge")
public class JohnComplexBlueBridge extends JohnAuto {

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
            sleep(100);
            turnRight(RIGHT_TURN);
            sleep(100);
            forward(1000);
            sleep(100);
            while (robot.color_sensor_side.red() > RED_SENSOR_VALUE) {
                robot.wheels.go(new ControllerCommand(ControllerCommand.Command.FORWARD));
            }
            sleep(100);
            forward(150);
            sleep(100);
            turnLeft(LEFT_TURN);
            sleep(100);
            forward(100);

            grab_skystone();

            backward(100);
            sleep(25);
            turnLeft(LEFT_TURN);
            sleep(25);
            forward(3000);
            sleep(25);
            turnRight(RIGHT_TURN);
            sleep(25);
            release_skystone();
            sleep(25);
            backward(300);
            sleep(25);
            turnRight(RIGHT_TURN);
            sleep(25);

            driveToLine();

            break;
        }
    }
}
