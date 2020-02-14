package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.PushBot;
import org.firstinspires.ftc.teamcode.hardware.Vuforia;

@Disabled public class Auto extends LinearOpMode {
    private PushBot robot;
    protected Vuforia vuforia;

    @Override public void runOpMode() throws InterruptedException{
        robot = new PushBot(hardwareMap);
        robot.init();

        vuforia = new Vuforia(hardwareMap);
        vuforia.init();

        waitForStart();

        vuforia.start();

        while (!isStopRequested()) {

        }

        vuforia.stop();
    }
}