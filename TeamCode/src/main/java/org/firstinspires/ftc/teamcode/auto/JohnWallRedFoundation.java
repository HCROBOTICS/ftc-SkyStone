package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "5. John Wall Red Foundation", group = "John")
public class JohnWallRedFoundation extends JohnAuto {

    @Override
    public void runOpMode() throws InterruptedException {
        initJohn();

        waitForStart();

        turnLeft(100);
        sleep(SLEEP_TIME);
        forward(250);
        sleep(SLEEP_TIME);
        turnRight(100);
        sleep(SLEEP_TIME);

        driveToLine();

        sleep(SLEEP_TIME);
        backward(500);

        sleep(SLEEP_TIME);
        turnLeft(TURN + 500);

        sleep(SLEEP_TIME);

        forward(4500);
        sleep(SLEEP_TIME);

        robot.drag.setPosition(DRAG_DOWN);
        sleep(SLEEP_TIME);

        backward(5000);
        sleep(SLEEP_TIME);

        robot.drag.setPosition(DRAG_UP);
        sleep(SLEEP_TIME);

        driveToLineStrafe(-1);
    }
}




