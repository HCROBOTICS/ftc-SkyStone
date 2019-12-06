package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;
import org.firstinspires.ftc.teamcode.hardware.PushBot;
import org.firstinspires.ftc.teamcode.hardware.Vuforia;

import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;
import static org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit.mmPerInch;

import static org.firstinspires.ftc.teamcode.auto.ControlCommand.Command.*;

@Autonomous (name = "JohnBasicAuto")
public class JohnAuto extends Auto {
    private JohnRobot robot;

    @Override public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();

        waitForStart();

        while (!isStopRequested()) {
            robot.wheels.goJoystick(new ControlCommand(FORWARD));
        }

        vuforia.stop();
    }
}
