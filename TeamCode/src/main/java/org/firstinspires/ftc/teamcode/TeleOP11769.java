package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "TeleOp11769", group = "PioneerMiddleSchool")
public class TeleOp11769 extends LinearOpMode
{

    private DcMotor MotorLeft = null;
    private DcMotor MotorRight = null;
    private DcMotor flipMotor = null;
    private DcMotor sweepMotor = null;

    //public TeleOp11769() {

    //}

    @Override
    public void runOpMode()
    {
        DcMotor MotorLeft = hardwareMap.dcMotor.get("MotorLeft");
        DcMotor MotorRight = hardwareMap.dcMotor.get("MotorRight");
        DcMotor flipMotor = hardwareMap.dcMotor.get("flipMotor");
        DcMotor sweepMotor = hardwareMap.dcMotor.get("sweepMotor");

        MotorLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive())
        {

            double leftPower;
            double rightPower;

            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;

            leftPower    = drive + turn;
            rightPower   = drive - turn;
            double scale = Math.max(Math.abs(leftPower), Math.abs(rightPower));

            if (scale > 1) {
                scale = 1 / scale;
                leftPower *= scale;
                rightPower *= scale;
            }

            MotorLeft.setPower(leftPower);
            MotorRight.setPower(rightPower);

            flipMotor.setPower(gamepad2.left_stick_y);
            sweepMotor.setPower(gamepad2.right_stick_x);

            idle();

        }

    }
}
