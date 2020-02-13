package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "6. John Bridge Blue Foundation", group = "John")
public class JohnBridgeBlueFoundation extends JohnAuto {

    @Override
    public void runOpMode() throws InterruptedException {
        initJohn();

        waitForStart();

        turnRight(100);
        sleep(SLEEP_TIME);
        forward(250);
        sleep(SLEEP_TIME);
        turnLeft(100);
        sleep(SLEEP_TIME);

        driveToLine();

        sleep(SLEEP_TIME);
        backward(500);

        sleep(SLEEP_TIME);
        turnRight(TURN + 500);

        sleep(SLEEP_TIME);

        forward(4500);
        sleep(SLEEP_TIME);

        robot.drag.setPosition(DRAG_DOWN);
        sleep(SLEEP_TIME);

        backward(5000);
        sleep(SLEEP_TIME);

        robot.drag.setPosition(DRAG_UP);
        sleep(SLEEP_TIME);

        JohnStrafe(2000, 1);
        sleep(SLEEP_TIME);

        forward(INITIAL_FORWARD);
        sleep(SLEEP_TIME);

        turnRight(TURN);
        sleep(SLEEP_TIME);

        driveToLine();
    }
}




