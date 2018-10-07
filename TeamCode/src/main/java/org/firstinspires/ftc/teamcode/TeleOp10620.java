package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp (name = "TeleOp10620", group = "PioneerMiddleSchool")
public class TeleOp10620 extends LinearOpMode
{

    private DcMotor motorLeft;
    private DcMotor motorRight;
    private DcMotor hexMotor;

    //public TeleOp10620() {

    //}

    @Override
    public void runOpMode()
    {
        DcMotor motorLeft = hardwareMap.dcMotor.get("motorLeft");
        DcMotor motorRight = hardwareMap.dcMotor.get("motorRight");
        DcMotor hexMotor = hardwareMap.dcMotor.get("hexMotor");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        while(opModeIsActive())
        {

            double leftPower;
            double rightPower;


            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            if (gamepad1.a) {
                motorLeft.setPower(0);
                motorRight.setPower(0);
            }

            if (gamepad1.y) {
                motorLeft.setPower(1.0);
                motorRight.setPower(1.0);
            }

            if(gamepad2.left_bumper){
                hexMotor.setPower(1.0);
            }

            if(gamepad2.right_bumper){
                hexMotor.setPower(-1.0);
            }


            idle();

        }

    }
}
