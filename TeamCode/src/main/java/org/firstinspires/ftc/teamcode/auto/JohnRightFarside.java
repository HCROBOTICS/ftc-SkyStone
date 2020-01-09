// eventually this class should be move until robot senses the color tape

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.JohnRobot;

import static org.firstinspires.ftc.teamcode.auto.ControllerCommand.Command.*;

@Autonomous (name = "John Right Farside")
public class JohnRightFarside extends JohnAuto {

    //this is the downward facing color sensor used to sense the field lines

    @Override public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();

        // Compensate for the fact that the motors all face a different direction.
        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();


        while (opModeIsActive()) {
            forward (1000);
            turnRight(RIGHT_TURN);
            driveToLine();
        }

        robot.stop();
    }
}

