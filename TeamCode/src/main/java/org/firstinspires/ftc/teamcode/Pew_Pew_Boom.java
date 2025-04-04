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
private DcMotorEx missleLaucher;
private CRServo liftBoom;
private DcMotorEx sampleExplosion;
private DcMotorEx sampleExplosion2;
private Servo holdBoom;
private CRServo armBoom;

private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init(){
        missleLaucher = hardwareMap.get(DcMotorEx.class, "missleLaucher");
        liftBoom = hardwareMap.get(CRServo.class, "liftBoom");
        sampleExplosion = hardwareMap.get(DcMotorEx.class, "sampleExplosion");
        sampleExplosion2 = hardwareMap.get(DcMotorEx.class, "sampleExplosion2");
        holdBoom = hardwareMap.get(Servo.class, "holdBoom");
        armBoom = hardwareMap.get(CRServo.class, "armBoom");

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
            holdBoom.setPosition(1);
            runtime.reset();

        }
        if (runtime.seconds() > 0.3){
            holdBoom.setPosition(0);
        }
    }

    public void MoveMissle(){
        double x = -gamepad1.left_stick_x;
        double speedmod = 1.5;

        missleLaucher.setPower(x*speedmod);
    }

    public void MissleAim(){
        if (gamepad1.dpad_up){
            liftBoom.setPower(0.01);
            armBoom.setPower(0.01);
        } else if (gamepad1.dpad_down) {
            liftBoom.setPower(-0.01);
            armBoom.setPower(-0.01);
        }
        else if (gamepad1.dpad_left){
            liftBoom.setPower(0);
       armBoom.setPower(0);
        }


    }





}

