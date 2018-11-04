package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "TeleOp10620", group = "PioneerMiddleSchool")
public class TeleOp10620 extends LinearOpMode
{

    private DcMotor motorLeftback;
    private DcMotor motorRightback;
    private DcMotor ABMotor;
    private DcMotor ALMotor;
    private Servo placeServo;
    private Servo nofallServo;
    private DcMotor BasketMotor;
    private DcMotor PullyMotor;


    //public TeleOp10620() {

    //}

    @Override
    public void runOpMode()
    {
        DcMotor motorLeftback = hardwareMap.dcMotor.get("motorLeftback");
        DcMotor motorRightback = hardwareMap.dcMotor.get("motorRightback");
        DcMotor ABMotor = hardwareMap.dcMotor.get("ABMotor");
        DcMotor ALMotor = hardwareMap.dcMotor.get("ALMotor");
        DcMotor BasketMotor = hardwareMap.dcMotor.get("BasketMotor");
        DcMotor PullyMotor = hardwareMap.dcMotor.get("PullyMotor");
        Servo placeServo = hardwareMap.servo.get("placeServo");
        Servo nofallServo = hardwareMap.servo.get("nofallServo");

        motorLeftback.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive())
        {

            double leftPower;
            double rightPower;


            double drive = gamepad1.left_stick_y * 0.8;
            double turn  =  gamepad1.right_stick_x * 0.5;


            leftPower    = drive + turn;
            rightPower   = drive - turn;
            double scale = Math.max(Math.abs(leftPower), Math.abs(rightPower));

            if (scale > 1) {
                scale = 1 / scale;
                leftPower *= scale;
                rightPower *= scale;
            }

            motorLeftback.setPower(leftPower);
            motorRightback.setPower(rightPower);

            ABMotor.setPower(gamepad2.left_stick_y * 0.5);
            ALMotor.setPower(gamepad2.right_stick_x * 0.65);
            BasketMotor.setPower(gamepad2.left_trigger * 0.8 -gamepad2.right_trigger *0.8);
            PullyMotor.setPower(gamepad1.left_trigger * 0.8 -gamepad1.right_trigger *0.8);
            if (gamepad2.a) {
                nofallServo.setPosition(0.5);
            }
            else if(gamepad2.b){
                nofallServo.setPosition(0);
            }
            else{
                nofallServo.setPosition(0);
            }
            idle();

        }

    }
}
