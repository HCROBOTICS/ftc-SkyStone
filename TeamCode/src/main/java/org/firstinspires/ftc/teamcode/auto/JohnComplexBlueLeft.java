package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Disabled
@Autonomous (name = "John Complex Blue Left")
public class JohnComplexBlueLeft extends JohnAuto{

    private static int SKYSTONE_POSITION = 0;

    @Override public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        initWheels();

        waitForStart();

        //lower the motor named rotate

        forward(1200);
        turnRight(RIGHT_TURN);
        forward(700);

        find_skystone();

        backward(SKYSTONE_POSITION);
        turnLeft(LEFT_TURN);
        backward(100);
        turnRight(RIGHT_TURN);
        forward(SKYSTONE_POSITION);
        turnLeft(LEFT_TURN);

        grab_skystone();
    }

    private void grab_skystone() {
        forward(100);

    }

    private void find_skystone() {
        robot.wheels.encoderReset();
        while (robot.color_sensor_side.alpha() > 500) {
            robot.wheels.go(new ControllerCommand(ControllerCommand.Command.FORWARD));
        }
        SKYSTONE_POSITION = robot.wheels.encoderAverageLeft();
    }

    private void initWheels() {
        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);
    }
}
