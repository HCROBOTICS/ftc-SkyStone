package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

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
import static org.firstinspires.ftc.teamcode.auto.ControlCommand.*;

@Autonomous (name = "John Auto")
public class JohnAuto extends Auto {
    private JohnRobot robot;

    enum Task {
        START, MOVING, STOP, DONE
    }

    Task task = Task.START;

    @Override public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();

        // Compensate for the fact that the motors all face a different direction.
        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        robot.grab.setPosition(1);

        while (!isStopRequested()) {
            switch (task) {
                case START:
                    robot.wheels.encoderReset();
                    robot.wheels.goJoystick(new ControlCommand(Command.FORWARD));
                    task = Task.MOVING;
                    break;
                case MOVING:
                    if (robot.wheels.rb.getCurrentPosition() > 2000)
                        task = Task.STOP;
                case STOP:
                    robot.wheels.stop();
                    task = Task.DONE;
                    break;
                default: break;
            }
        }

        vuforia.stop();
    }
}
