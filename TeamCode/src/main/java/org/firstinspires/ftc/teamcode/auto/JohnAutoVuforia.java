//john's attempt at making an odometry

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.teamcode.hardware.JohnRobot;
import org.firstinspires.ftc.teamcode.hardware.Vuforia;
import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;
import static org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit.mmPerInch;

@Autonomous (name = "John Vuforia / Odometry")
public class JohnAutoVuforia extends Auto {
    private JohnRobot robot;
    protected Vuforia vuforia;

    // number of encoder tics per degree of rotation / inch of movementk
    public int tics_per_degree = 0;
    public int tics_per_revolution = 1680;
    public double wheel_circumference = 2 * Math.PI * (49 / mmPerInch); // circumference in INCHES
    public double tics_per_inch = tics_per_revolution / wheel_circumference;
    // private double inches_travelled = tics_per_inch * (number of tics we've moved)

    @Override public void runOpMode() {
        robot = new JohnRobot(hardwareMap);
        robot.init();

        vuforia = new Vuforia(hardwareMap);
        vuforia.init();

        waitForStart();

        vuforia.start();

        while (opModeIsActive()) {
            VuforiaTrackable look = vuforia.look();
            if (look != null) {
                // express position (translation) of robot in inches.
                VectorF translation = vuforia.getLastLocation().getTranslation();
                telemetry.addData("Pos (in)", "{X, Y, Z} = %.1f, %.1f, %.1f",
                        translation.get(0) / mmPerInch, translation.get(1) / mmPerInch, translation.get(2) / mmPerInch);

                // express the rotation of the robot in degrees.
                Orientation rotation = Orientation.getOrientation(vuforia.getLastLocation(), EXTRINSIC, XYZ, DEGREES);
                telemetry.addData("Rot (deg)", "{Roll, Pitch, Heading} = %.0f, %.0f, %.0f", rotation.firstAngle, rotation.secondAngle, rotation.thirdAngle);
            } else {
                telemetry.addData("Visible Target", "none");
            }

            /*
             Use the last seen location as a reference for the robot's current location. When a new
             VuMark is seen, update our current location. Store <r,theta> in a 2D array (magnitude,
             direction).

             current position is
               reference position x + (how far we've moved) * cos angle
               reference position y + (how far we've moved) * sin angle

             if (we see another picture) {
               update reference position
              }

             while (current_angle < desired_angle) {
                turn;
             }
             while (current_angle > desired_angle) {
                turn;
             }
             while (how_far_its_moved < how_far_it_should_move) {
                move;
             }

             */






        } //end: while OpMode is active


    }


}
