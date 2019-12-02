package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class JohnRobot extends PushBot {
    public JohnLift lift;

    public DcMotor rotate;
    public Servo grab;
    public Servo wrist;

    public JohnRobot(HardwareMap hw) {
        super(hw);

        lift = new JohnLift(hw.dcMotor.get("lift"));
        rotate = hw.dcMotor.get("rotate");

        grab = hw.servo.get("grab");
        wrist = hw.servo.get("wrist");
    }

    @Override
    public void init() {
        super.init();

        wheels.lf.setDirection(DcMotorSimple.Direction.FORWARD);
        wheels.rf.setDirection(DcMotorSimple.Direction.FORWARD);
        wheels.lb.setDirection(DcMotorSimple.Direction.FORWARD);
        wheels.rb.setDirection(DcMotorSimple.Direction.FORWARD);

        lift.init();
        rotate.setPower(0);
        rotate.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
