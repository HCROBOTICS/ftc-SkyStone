package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "1. John Drive to Line", group = "John")
public class JohnNearside extends JohnAuto {

    @Override
    public void runOpMode() throws InterruptedException {
        initJohn();

        waitForStart();

        driveToLine();
    }
}
