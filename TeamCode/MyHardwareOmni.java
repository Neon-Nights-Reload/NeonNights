package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
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
public class MyHardwareOmni
{
    /* Public OpMode members. */
    /* For test robot: comment out arm motor and servos*/
    public DcMotor  D1Motor   = null;
    public DcMotor  D2Motor  = null;
    public DcMotor  D3Motor  = null;
    public DcMotor  D4Motor  = null;
   // public DcMotor  launcher = null;
    //public Servo    lever    = null;

    public static final double MID_SERVO       =  0.5 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public MyHardwareOmni(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        //Ted: for test robot, comment out armMotor and servos
        D1Motor   = hwMap.dcMotor.get("D1");
        D2Motor  = hwMap.dcMotor.get("D2");;
        D3Motor  = hwMap.dcMotor.get("D3");
        D4Motor  = hwMap.dcMotor.get("D4");
        //launcher = hwMap.dcMotor.get("Lever");
        D1Motor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        D2Motor.setDirection(DcMotor.Direction.FORWARD);
        D3Motor.setDirection(DcMotor.Direction.REVERSE);
        D4Motor.setDirection(DcMotor.Direction.REVERSE);
        // Set to FORWARD if using AndyMark motors

        // Set all motors to zero power     tt
        D1Motor.setPower(0);
        D2Motor.setPower(0);
        D3Motor.setPower(0);
        D4Motor.setPower(0);
        //launcher.setPower(0);
        // Set all motors to run without encoders.
        // May want to use RUN_WITHOUT_ENCODER or RUN_USING_ENCODERS if encoders are installed.
        D3Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        D2Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        D3Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        D4Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //launcher.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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

