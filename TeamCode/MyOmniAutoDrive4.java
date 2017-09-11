package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

/**
 * Created by neon_nights on 1/14/2017.
 */

@Autonomous(name="Omni:wrong program }", group="Neon Knights")
//@Disabled
public class MyOmniAutoDrive4 extends LinearOpMode{

    /* Declare OpMode members. */
    MyHardwareOmni         robot   = new MyHardwareOmni();   // Use a Pushbot's hardware
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
        robot.D1Motor.setPower(-.7);
        robot.D3Motor.setPower(-.7);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.00)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            idle();
        }



//stops robot
        robot.D1Motor.setPower(0);
        robot.D3Motor.setPower(0);

        //drives left toward beacons
        robot.D2Motor.setPower(.7);
        robot.D4Motor.setPower(.7);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.00)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            idle();
        }

        robot.D2Motor.setPower(0);
        robot.D4Motor.setPower(0);

//drives left for 50 milliseconds
        robot.D1Motor.setPower(.7);
        robot.D3Motor.setPower(.7);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.50)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            idle();
        }


        robot.D1Motor.setPower(0);
        robot.D3Motor.setPower(0);


//drives foreward

        robot.D1Motor.setPower(-.9);
        robot.D3Motor.setPower(-.9);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.00)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            idle();
        }


        robot.D1Motor.setPower(0);
        robot.D3Motor.setPower(0);

        //drive left to capture beacon


        robot.D2Motor.setPower(.9);
        robot.D4Motor.setPower(.9);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.25)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            idle();
        }

//drives right and hits ball
        robot.D1Motor.setPower(0);
        robot.D3Motor.setPower(0);

        robot.D2Motor.setPower(.9);
        robot.D4Motor.setPower(.9);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.50)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            idle();
        }
//backs up to move ball
        robot.D2Motor.setPower(-.9);
        robot.D4Motor.setPower(-.9);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < .50)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            idle();
        }

    }
}
