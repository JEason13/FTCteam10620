package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="Auton11769", group="pioneerMiddleSchool")
public class Auton11769 extends LinearOpMode {

    private DcMotor MotorLeft;
    private DcMotor MotorRight;
    private ElapsedTime     runtime;

    static final double FORWARD_SPEED = 0.6;
    static final double TURNING_SPEED = 0.5;


    @Override
    public void runOpMode() {
        MotorLeft = hardwareMap.dcMotor.get("MotorLeft");
        MotorRight = hardwareMap.dcMotor.get("MotorRight");
        runtime = new ElapsedTime();



        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        MotorLeft.setPower(FORWARD_SPEED);
        MotorRight.setPower(-FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.5)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }

}
