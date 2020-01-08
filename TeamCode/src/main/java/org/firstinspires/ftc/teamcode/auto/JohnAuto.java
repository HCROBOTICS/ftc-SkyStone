package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.PushBot;

@Autonomous (name = "John Auto")
public class JohnAuto extends Auto {
    private PushBot robot;

    @Override public void runOpMode() {
        robot = new PushBot(hardwareMap);
        robot.init();

        // Compensate for the fact that the motors all face a different direction.
        robot.wheels.lf.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rf.setDirection(DcMotor.Direction.FORWARD);
        robot.wheels.lb.setDirection(DcMotor.Direction.REVERSE);
        robot.wheels.rb.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {
            /*
            switch (task) {
                case START:
                    robot.wheels.encoderReset();
                    robot.wheels.go(new ControllerCommand(Command.FORWARD));
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

             */


            forward(3000);
            break;
        }







        //vuforia.stop();
    }

    public void forward (long time) {
        robot.wheels.lf.setPower(1);
        robot.wheels.rf.setPower(1);
        robot.wheels.lb.setPower(1);
        robot.wheels.rb.setPower(1);
        sleep(time);
        robot.wheels.lf.setPower(0);
        robot.wheels.rf.setPower(0);
        robot.wheels.lb.setPower(0);
        robot.wheels.rb.setPower(0);
    }

    public void backward (long time) {
        robot.wheels.lf.setPower(-1);
        robot.wheels.rf.setPower(-1);
        robot.wheels.lb.setPower(-1);
        robot.wheels.rb.setPower(-1);
        sleep(time);
        robot.wheels.lf.setPower(0);
        robot.wheels.rf.setPower(0);
        robot.wheels.lb.setPower(0);
        robot.wheels.rb.setPower(0);
    }

    public void right (long time) {
        robot.wheels.lf.setPower(-1);
        robot.wheels.rf.setPower(1);
        robot.wheels.lb.setPower(-1);
        robot.wheels.rb.setPower(1);
        sleep(time);
        robot.wheels.lf.setPower(0);
        robot.wheels.rf.setPower(0);
        robot.wheels.lb.setPower(0);
        robot.wheels.rb.setPower(0);
    }

    public void left (long time) {
        robot.wheels.lf.setPower(1);
        robot.wheels.rf.setPower(-1);
        robot.wheels.lb.setPower(1);
        robot.wheels.rb.setPower(-1);
        sleep(time);
        robot.wheels.lf.setPower(0);
        robot.wheels.rf.setPower(0);
        robot.wheels.lb.setPower(0);
        robot.wheels.rb.setPower(0);
    }

    public void end() {
        robot.wheels.lf.setPower(0);
        robot.wheels.rf.setPower(0);
        robot.wheels.lb.setPower(0);
        robot.wheels.rb.setPower(0);
    }

}
