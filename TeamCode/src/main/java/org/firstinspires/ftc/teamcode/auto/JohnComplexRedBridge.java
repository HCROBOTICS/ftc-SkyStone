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

            while (Math.abs(robot.rotate.getCurrentPosition()) < ROTATE_ROTATION) {
                robot.rotate.setPower(-0.5);
            }

            forward(INITIAL_FORWARD);
            turnRight(RIGHT_TURN);
            backward(1000);

            while (robot.color_sensor_side.red() > RED_SENSOR_VALUE) {
                robot.wheels.go(new ControllerCommand(ControllerCommand.Command.BACKWARD));
            }

            backward(150);
            turnLeft(LEFT_TURN);
            forward(100);

            grab_skystone();

            backward(100);
            turnRight(RIGHT_TURN);
            forward(3000);
            turnLeft(LEFT_TURN);

            release_skystone();

            backward(300);
            turnLeft(LEFT_TURN);

            driveToLine();

            break;
        }
    }
}
