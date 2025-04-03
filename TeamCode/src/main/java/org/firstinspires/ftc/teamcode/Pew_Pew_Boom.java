package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.sun.tools.javac.jvm.CRTFlags;


@TeleOp(name="Pew_Pew_Monkey_Goes_Boom", group = "Monkey_Goes_Boom")
public class Pew_Pew_Boom extends OpMode {
private DcMotorEx missleLaucher;
private CRServo liftBoom;
private DcMotorEx sampleExplosion;
private DcMotorEx sampleExplosion2;
private Servo holdBoom;
private CRServo armBoom;


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
        sampleExplosion.setDirection(DcMotorSimple.Direction.FORWARD);
        sampleExplosion2.setDirection(DcMotorSimple.Direction.FORWARD);

    }
    @Override
    public void start (){

    }

    @Override
    public void loop(){
    Kaboom();
    MoveMissle();
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
        if (gamepad1.right_trigger > 0) {
            holdBoom.setPosition(1);
        }
        else{
            holdBoom.setPosition(0);
        }
    }

    public void MoveMissle(){
        double x = -gamepad1.left_stick_x;

        missleLaucher.setPower(x);
    }

    public void MissleAim(){
        if (gamepad1.dpad_up){
            liftBoom.setPower(1);
            armBoom.setPower(1);
        } else if (gamepad1.dpad_down) {
            liftBoom.setPower(-1);
            armBoom.setPower(-1);
        }
        else {
            liftBoom.setPower(0);
            armBoom.setPower(0);
        }
    }





}

