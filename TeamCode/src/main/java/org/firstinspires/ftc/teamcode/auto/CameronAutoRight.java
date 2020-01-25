package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import static org.firstinspires.ftc.teamcode.auto.ControllerCommand.Command.BACKWARD;
import static org.firstinspires.ftc.teamcode.auto.ControllerCommand.Command.FORWARD;

@Autonomous(name = "Cameron Right")
public class CameronAutoRight extends CameronAuto{
    @Override void go() {
        right(32 * (int) robot.wheels.ticksPerInch());
        sleep(1000);
        driveToLine(new ControllerCommand(FORWARD));
    }
}
