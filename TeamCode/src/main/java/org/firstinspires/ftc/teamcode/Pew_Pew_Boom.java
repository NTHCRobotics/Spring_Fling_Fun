package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="Pew_Pew_Monkey_Goes_Boom", group = "Monkey_Goes_Boom")
public class Pew_Pew_Boom extends OpMode {
private DcMotorEx spinBoom;
private DcMotorEx liftBoom;
private DcMotorEx sampleExplosion;
private DcMotorEx sampleExplosion2;
private Servo holdBoom;
private Servo armBoom;


    @Override
    public void init(){
        spinBoom = hardwareMap.get(DcMotorEx.class, "spinBoom");
        liftBoom = hardwareMap.get(DcMotorEx.class, "liftBoom");
        sampleExplosion = hardwareMap.get(DcMotorEx.class, "sampleExplosion");
        sampleExplosion2 = hardwareMap.get(DcMotorEx.class, "sampleExplosion2");
        holdBoom = hardwareMap.get(Servo.class, "holdBoom");
        armBoom = hardwareMap.get(Servo.class, "armBoom");

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
    }


    public void Kaboom(){
        if(gamepad1.right_trigger >0 ){
            sampleExplosion.setPower(gamepad1.right_trigger);
            sampleExplosion2.setPower(gamepad1.right_trigger);
        }else{
            sampleExplosion.setPower(0);
            sampleExplosion2.setPower(0);
        }
    }
}
