package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.hardware.PushBot;
import org.firstinspires.ftc.teamcode.hardware.Vuforia;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Enum.valueOf;
import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.YZX;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;
import static org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit.mmPerInch;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

@Autonomous(name = "Proto-Autonomous", group = "Joey")
@Disabled public class Auto extends LinearOpMode {
    private PushBot robot;
    protected Vuforia vuforia;

    @Override public void runOpMode() throws InterruptedException{
        /*
         * This can be used as a reference for how to use Vuforia.
         */
        /*
         * No it can't
         */

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