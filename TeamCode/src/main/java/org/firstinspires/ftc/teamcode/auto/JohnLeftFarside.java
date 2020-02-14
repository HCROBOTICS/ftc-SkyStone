package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "3. John Start Left Farside", group = "John")
public class JohnLeftFarside extends JohnAuto {

    @Override public void runOpMode() throws InterruptedException{
        initJohn();

        waitForStart();

        forward(INITIAL_FORWARD);
        sleep(500);
        turnRight(TURN);
        sleep(500);
        driveToLine();

    }
}
