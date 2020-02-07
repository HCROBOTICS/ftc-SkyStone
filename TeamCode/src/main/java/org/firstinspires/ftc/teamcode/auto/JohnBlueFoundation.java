package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;
import org.firstinspires.ftc.teamcode.hardware.Wheels;

import static org.firstinspires.ftc.teamcode.auto.ControllerCommand.Command.FORWARD;

@Autonomous (name = "John Blue Foundation", group = "John")
public class JohnBlueFoundation extends JohnAuto {

    public static final int MODIFIER = 10;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new JohnRobot(hardwareMap);
        robot.init();
        wheelsInit();
        resetRotate();

        waitForStart();

        driveToLine(0.1);

        sleep(SLEEP_TIME * MODIFIER);
        backward(500);

        sleep(SLEEP_TIME * MODIFIER);
        turnRight(TURN + 300);

        sleep(SLEEP_TIME * MODIFIER);


    }
}
