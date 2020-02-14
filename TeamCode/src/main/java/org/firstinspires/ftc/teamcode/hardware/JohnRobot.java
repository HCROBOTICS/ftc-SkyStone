package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class JohnRobot extends PushBot {
    public JohnLift lift;

    public DcMotor rotate;
    public DcMotor wrist;
    public Servo lGrab;
    public Servo rGrab;
    public Servo drag;

    public ColorSensor color_sensor_down;
    public ColorSensor color_sensor_side;

    public JohnRobot(HardwareMap hw) {
        super(hw);
        color_sensor_down = hw.colorSensor.get("downColor");
        color_sensor_side = hw.colorSensor.get("sideColor");
        lift = new JohnLift(hw.dcMotor.get("lift"));
        rotate = hw.dcMotor.get("rotate");
        lGrab = hw.servo.get("lGrab");
        rGrab = hw.servo.get("rGrab");
        wrist = hw.dcMotor.get("wrist");
        drag = hw.servo.get("drag");

    }

    @Override public void init() {
        super.init();

        wheels.lf.setDirection(DcMotorSimple.Direction.FORWARD);
        wheels.rf.setDirection(DcMotorSimple.Direction.FORWARD);
        wheels.lb.setDirection(DcMotorSimple.Direction.FORWARD);
        wheels.rb.setDirection(DcMotorSimple.Direction.FORWARD);

        wheels.lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        wheels.rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        wheels.lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        wheels.rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lift.init();

        wrist.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rotate.setPower(0);
        rotate.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rotate.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override public void go(Gamepad gamepad1, Gamepad gamepad2) {
        super.go(gamepad1, gamepad2); // go the wheels
    }
}
