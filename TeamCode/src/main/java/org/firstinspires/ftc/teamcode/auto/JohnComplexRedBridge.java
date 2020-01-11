package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Disabled
@Autonomous (name = "John Complex Red Bridge")
public class JohnComplexRedBridge extends JohnAuto{

    @Override
    public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();

        waitForStart();

        while (opModeIsActive()) {
            forward(1000);
            turnRight(RIGHT_TURN);
            backward(1000);

            while (robot.color_sensor_side.red() > 127.5) {
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
