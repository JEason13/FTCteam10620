package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "TeleOp10620", group = "PioneerMiddleSchool")
public class TeleOp10620 extends LinearOpMode
{

    private DcMotor motorLeftback;
    private DcMotor motorRightback;
    private DcMotor ABMotor;
    //private DcMotor PullMotor;
    private DcMotor ALMotor;


    //public TeleOp10620() {

    //}

    @Override
    public void runOpMode()
    {
        DcMotor motorLeftback = hardwareMap.dcMotor.get("motorLeftback");
        DcMotor motorRightback = hardwareMap.dcMotor.get("motorRightback");
        DcMotor ABMotor = hardwareMap.dcMotor.get("ABMotor");
        DcMotor ALMotor = hardwareMap.dcMotor.get("ALMotor");
        motorLeftback.setDirection(DcMotor.Direction.REVERSE);
       // motorLeftfront.setDirection(DcMotor.Direction.REVERSE);

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

/*            if(gamepad2.x){
                pullyServo.setPosition(360);
            }else if (gamepad2.b){
                pullyServo.setPosition(0);
            }
            else{
                pullyServo.setPosition(180);
            }
*/
            motorLeftback.setPower(leftPower);
            motorRightback.setPower(rightPower);

            ABMotor.setPower(gamepad2.left_stick_y);
            ALMotor.setPower(gamepad2.right_stick_x);

            idle();

        }

    }
}
