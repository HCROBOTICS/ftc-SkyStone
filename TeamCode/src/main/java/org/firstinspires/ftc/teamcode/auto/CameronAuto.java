package org.firstinspires.ftc.teamcode.auto;
import org.firstinspires.ftc.teamcode.hardware.PushBot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "Cameron Auto")
public class CameronAuto extends Auto {
    private PushBot robot;

    @Override public void runOpMode() {
        robot = new PushBot(hardwareMap);
        robot.init();

        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {
            forward(3000);
            break;
        }
    }

    public void forward (long time) {
        robot.wheels.lf.setPower(1);
        robot.wheels.rf.setPower(1);
        robot.wheels.lb.setPower(1);
        robot.wheels.rb.setPower(1);
        sleep(time);
        robot.stop();
    }
}
