package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;



/**
 * Created by neon_nights on 1/14/2017.
 */

@Autonomous(name="Wheel Test }", group="Neon Knights")
//@Disabled
public class WheelTest extends LinearOpMode {

    /* Declare OpMode members. */
    OmniWheel         robot   = new OmniWheel();   // Use a Pushbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way

        // Step 1:  Drive forward for 1 seconds
        robot.F_leftMotor.setPower(1);
        sleep(1000);
        robot.F_leftMotor.setPower(0);
        robot.F_rightMotor.setPower(1);
        sleep(1000);
        robot.F_rightMotor.setPower(0);
        robot.B_leftMotor.setPower(1);
        sleep(1000);
        robot.B_leftMotor.setPower(0);
        robot.B_rightMotor.setPower(1);
        sleep(1000);
        robot.B_rightMotor.setPower(0);
        }

    }

