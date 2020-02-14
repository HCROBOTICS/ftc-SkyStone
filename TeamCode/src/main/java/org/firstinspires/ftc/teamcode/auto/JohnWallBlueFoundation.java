package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "4. John Wall Blue Foundation", group = "John")
public class JohnWallBlueFoundation extends JohnAuto {

    @Override
    public void runOpMode() throws InterruptedException {
        initJohn();

        waitForStart();

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

        driveToLineStrafe(1);
    }
}




