package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

@Autonomous(name = "John Red Foundation", group = "John")
public class JohnRedFoundation extends JohnAuto{

    DigitalChannel digitalTouch;

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();
        resetRotate();

        waitForStart();

        forward(250);
        sleep(SLEEP_TIME);
        turnRight(TURN);
        sleep(SLEEP_TIME);
        driveToLine();
        sleep(SLEEP_TIME / 2);
        backward(250);
        sleep(SLEEP_TIME);
        turnLeft(TURN);
        sleep(SLEEP_TIME);

        while(digitalTouch.getState() == true /* true = not pressed */ ) {
            robot.wheels.go(new ControllerCommand(ControllerCommand.Command.FORWARD));
        }

        robot.drag.setPosition(0);
        sleep(SLEEP_TIME / 2);
        backward(3000);
        robot.drag.setPosition(1);

        sleep(SLEEP_TIME / 2);
        turnRight(TURN);
        sleep(SLEEP_TIME);
        driveToLineReverse();
    }
}
