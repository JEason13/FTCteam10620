package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "TeleOp10262", group = "PioneerMiddleSchool")
public class TeleOp10262 extends LinearOpMode
{

    private DcMotor motorLeft;
    private DcMotor motorRight;
//    private Servo gripServo;
    private DcMotor AFMotor;


    //public TeleOp10262() {

    //}



    @Override
    public void runOpMode()
    {
        DcMotor motorLeft = hardwareMap.dcMotor.get("motorLeft");
        DcMotor motorRight = hardwareMap.dcMotor.get("motorRight");
        DcMotor AFMotor = hardwareMap.dcMotor.get("AFMotor");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
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

            motorLeft.setPower(0.75 * leftPower);
            motorRight.setPower(rightPower);

            AFMotor.setPower(gamepad2.left_stick_x);

            idle();

        }

    }
}
