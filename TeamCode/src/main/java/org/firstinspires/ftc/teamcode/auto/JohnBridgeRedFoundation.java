package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;
import org.firstinspires.ftc.teamcode.hardware.Wheels;

import static org.firstinspires.ftc.teamcode.auto.ControllerCommand.Command.FORWARD;

@Autonomous (name = "7. John Bridge Red Foundation", group = "John")
public class JohnBridgeRedFoundation extends JohnAuto {

    public static final int MODIFIER = 10;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();
        resetRotate();

        waitForStart();

        turnLeft(100);
        sleep(SLEEP_TIME * MODIFIER);
        forward(250);
        sleep(SLEEP_TIME * MODIFIER);
        turnRight(100);
        sleep(SLEEP_TIME * MODIFIER);

        driveToLine();

        sleep(SLEEP_TIME * MODIFIER);
        backward(500);

        sleep(SLEEP_TIME * MODIFIER);
        turnLeft(TURN + 500);

        sleep(SLEEP_TIME * MODIFIER);

        forward(4500);
        sleep(SLEEP_TIME);

        robot.drag.setPosition(DRAG_DOWN);
        sleep(SLEEP_TIME * MODIFIER);

        backward(5000);
        sleep(SLEEP_TIME);

        robot.drag.setPosition(DRAG_UP);
        sleep(SLEEP_TIME * MODIFIER);

        JohnStrafe(2000, -1);
        sleep(SLEEP_TIME * MODIFIER);

        forward(INITIAL_FORWARD);
        sleep(SLEEP_TIME * MODIFIER);

        turnLeft(TURN);
        sleep(SLEEP_TIME * MODIFIER);

        driveToLine();
    }
}




