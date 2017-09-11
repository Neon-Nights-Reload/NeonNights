package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

/**
 * Created by neon_nights on 1/14/2017.
 */

@Autonomous(name="choose this program }", group="Neon Knights")
//@Disabled
public class MyOmniAutoDriveByTime extends LinearOpMode{

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
        robot.D1Motor.setPower(.7);
        robot.D3Motor.setPower(.7);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.05)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            idle();
        }


//stops robot
        robot.D1Motor.setPower(0);
        robot.D3Motor.setPower(0);

        //drives right toward beacons
        robot.D2Motor.setPower(-.7);
        robot.D4Motor.setPower(-.7);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.50)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            idle();
        }

        robot.D2Motor.setPower(0);
        robot.D4Motor.setPower(0);




/*drives foreward for 50 milliseconds
        robot.D1Motor.setPower(.m
        +7);
        robot.D3Motor.setPower(.7);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.50)) {
        telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
        telemetry.update();
        idle();
        }*/


        robot.D1Motor.setPower(0);
        robot.D3Motor.setPower(0);


//drives right and captures beacon

        /*robot.D2Motor.setPower(.9);
        robot.D4Motor.setPower(.9);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < .75)) {
        telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
        telemetry.update();
        idle();
        }


        robot.D2Motor.setPower(0);
        robot.D4Motor.setPower(0);

        //drive right to capture beacon


            robot.D2Motor.setPower(.9);
            robot.D4Motor.setPower(.9);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 1.25)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                    idle();
            }

/*drives left and hits ball
        robot.D1Motor.setPower(0);
        robot.D3Motor.setPower(0);

        robot.D2Motor.setPower(-.9);
        robot.D4Motor.setPower(-.9);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.90)) {
        telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
        telemetry.update();
        idle();
        }*/
        }
        }
