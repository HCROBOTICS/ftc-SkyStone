package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "2. John Start Right Farside", group = "John")
public class JohnRightFarside extends JohnAuto {

    @Override public void runOpMode() throws  InterruptedException{
        initJohn();

        waitForStart();

        forward(INITIAL_FORWARD);
        sleep(500);
        turnLeft(TURN);
        sleep(500);
        driveToLine();

    }
}
