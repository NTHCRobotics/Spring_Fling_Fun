package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Pew_Pew_Sample_Goes_Boom", group = "Sample_Goes_Boom")
public class Pew_Pew_Boom extends OpMode {
private DcMotorEx wheel;
private CRServo liftServo1;
private DcMotorEx sampleExplosion;
private DcMotorEx sampleExplosion2;
private Servo pusher;
private CRServo liftServo2;

private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init(){
        wheel = hardwareMap.get(DcMotorEx.class, "white");
        liftServo1 = hardwareMap.get(CRServo.class, "liftservo1");
        sampleExplosion = hardwareMap.get(DcMotorEx.class, "sampleExplosion");
        sampleExplosion2 = hardwareMap.get(DcMotorEx.class, "sampleExplosion2");
        pusher = hardwareMap.get(Servo.class, "pusher");
        liftServo2 = hardwareMap.get(CRServo.class, "liftservo2");

        sampleExplosion.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        sampleExplosion2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        sampleExplosion.setDirection(DcMotorSimple.Direction.REVERSE);
        sampleExplosion2.setDirection(DcMotorSimple.Direction.FORWARD);

    }
    @Override
    public void start (){

    }

    @Override
    public void loop(){
    Kaboom();
    MoveMissle();
    HoldKaboom();
    MissleAim();



    }


    public void Kaboom(){
        if(gamepad1.left_trigger >0 ){
            sampleExplosion.setVelocity(10000);
            sampleExplosion2.setVelocity(10000);
        }else{
            sampleExplosion.setPower(0);
            sampleExplosion2.setPower(0);
        }


    }

    public void HoldKaboom(){
        if (gamepad1.right_bumper) {
            pusher.setPosition(1);
            runtime.reset();

        }
        if (runtime.seconds() > 0.3){
            pusher.setPosition(0);
        }
    }

    public void MoveMissle(){
        double x = -gamepad1.left_stick_x;
        double speedmod = 1.5;

        wheel.setPower(x*speedmod);
    }

    public void MissleAim(){
        if (gamepad1.dpad_up){
            liftServo1.setPower(0.01);
            liftServo2.setPower(0.01);
        } else if (gamepad1.dpad_down) {
            liftServo1.setPower(-0.01);
            liftServo2.setPower(-0.01);
        }
        else if (gamepad1.dpad_left){
            liftServo1.setPower(0);
       liftServo2.setPower(0);
        }


    }





}

