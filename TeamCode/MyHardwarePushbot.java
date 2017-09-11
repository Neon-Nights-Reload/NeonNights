package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left motor"
 * Motor channel:  Right drive motor:        "right motor"
 * Motor channel:  Manipulator drive motor:  "arm motor"
 * Servo channel:  Servo to open left claw:  "left claw"
 * Servo channel:  Servo to open right claw: "right claw"
 */
public class MyHardwarePushbot
{
    /* Public OpMode members. */
    /* For test robot: comment out arm motor and servos*/
    public DcMotor  F_leftMotor   = null;
    public DcMotor  F_rightMotor  = null;
    public DcMotor  B_leftMotor   = null;
    public DcMotor  B_rightMotor  = null;
    public DcMotor  Collect_L    = null;
    public DcMotor  Collect_U = null;
    public DcMotor  launcher = null;
    public Servo    lever    = null;

    public static final double MID_SERVO       =  0.5 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public MyHardwarePushbot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        //Ted: for test robot, comment out armMotor and servos
        F_leftMotor   = hwMap.dcMotor.get("F_L");
        F_rightMotor  = hwMap.dcMotor.get("F_R");
        B_leftMotor   = hwMap.dcMotor.get("B_L");
        B_rightMotor  = hwMap.dcMotor.get("B_R");
        //Collect_L    = hwMap.dcMotor.get("Collect_L");
        //Collect_U = hwMap.dcMotor.get("Collect_U");
        //launcher = hwMap.dcMotor.get("Launcher");
        //Collect_U.setDirection(DcMotor.Direction.REVERSE);
        F_leftMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        F_rightMotor.setDirection(DcMotor.Direction.REVERSE);
        B_leftMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        B_rightMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
//
        // Set all motors to zero power
        F_leftMotor.setPower(0);
        F_rightMotor.setPower(0);
        B_leftMotor.setPower(0);
        B_rightMotor.setPower(0);
        //Collect_L.setPower(0);
        //Collect_U.setPower(0);
        //launcher.setPower(0);
        // Set all motors to run without encoders.
        // May want to use RUN_WITHOUT_ENCODER or RUN_USING_ENCODERS if encoders are installed.
        F_leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        F_rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        B_leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        B_rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //Collect_L.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //Collect_U.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //launcher.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize ALL installed servos.
        //leftClaw = hwMap.servo.get("Claw_Left");
        //rightClaw = hwMap.servo.get("Claw_Right");
        //leftClaw.setPosition(MID_SERVO);
        //lever    = hwMap.servo.get("Lever");
        //lever.setPosition(0.0);
        hwMap.logDevices();

    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     * @throws InterruptedException
     */
    public void waitForTick(long periodMs) throws InterruptedException {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}

