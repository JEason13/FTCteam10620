package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name="Auton10620", group="pioneerMiddleSchool")
public class Auton10620 extends LinearOpMode {

    /* Declare OpMode members. */
    private DcMotor ABMotor;
    private DcMotor ALMotor;
    private Servo nofallServo;
    private DcMotor motorLeftback;
    private DcMotor motorRightback;
    private ElapsedTime     runtime;

    static final double     RELEASE_SPEED = 0.35;
    static final double     NO_FALL_POSITION = 0.5;
    static final double     DRIVE_SPEED = -0.45;
    static final double     TURN_SPEED = 0.7;
    static final double     ARM_POWER = 0.25;

    @Override
    public void runOpMode() {
        ABMotor = hardwareMap.dcMotor.get("ABMotor");
        nofallServo = hardwareMap.servo.get("nofallServo");
        motorRightback = hardwareMap.dcMotor.get("motorRightback");
        motorLeftback = hardwareMap.dcMotor.get("motorLeftback");
        ALMotor = hardwareMap.dcMotor.get("ALMotor");
        runtime = new ElapsedTime();


        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        ABMotor.setPower(RELEASE_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.2)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        motorLeftback.setPower(TURN_SPEED);
        motorRightback.setPower(-TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.8)) {
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        motorRightback.setPower(DRIVE_SPEED);
        motorLeftback.setPower(-DRIVE_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.47)) {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        ABMotor.setPower(-RELEASE_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.2)) {
            telemetry.addData("Path", "Leg 4: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        motorRightback.setPower(-DRIVE_SPEED);
        motorLeftback.setPower(-DRIVE_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.15)) {
            telemetry.addData("Path", "Leg 5: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        motorRightback.setPower(0);
        motorLeftback.setPower(0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.2)) {
            telemetry.addData("Path", "Leg 6: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        nofallServo.setPosition(NO_FALL_POSITION);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0)) {
            telemetry.addData("Path", "Leg 7: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        ALMotor.setPower(ARM_POWER);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 8: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
