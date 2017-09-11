/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

//Neon Knights: Run the Particle Collector / Accelerator Robot

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;


/**
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 * The code is structured as a LinearOpMode
 *
 * This particular OpMode executes a POV Game style Teleop for a PushBot
 * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="MecanumWheel_4", group="Neon Knights")
//@Disabled

public class OmniWheelDrive extends LinearOpMode {


    OmniWheel robot           = new OmniWheel();   // Use Neon Knights HW class


    /* Declare OpMode members. */                  // Servo mid position

    @Override
    public void runOpMode() throws InterruptedException {
        double F_left;
        double F_right;
        double B_left;
        double B_right;
        double max;
        double max2;
        double max1;
        //double launch_power = 0.1;

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Run wheels in POV mode (note: The joystick goes negative when pushed forwards, so negate it)
            // In this mode the Left stick moves the robot fwd and back, the Right stick turns left and right.
            F_left  = gamepad1.left_stick_y+gamepad1.left_stick_x+gamepad1.right_stick_x;
            F_right = gamepad1.left_stick_y-gamepad1.left_stick_x-gamepad1.right_stick_x;
            B_left  = gamepad1.left_stick_y+gamepad1.left_stick_x-gamepad1.right_stick_x;
            B_right = gamepad1.left_stick_y-gamepad1.left_stick_x+gamepad1.right_stick_x;

            // Normalize the values so neither exceed +/- 1.0
            max2 = Math.max(Math.abs(F_left), Math.abs(F_right));
            max1 = Math.max(Math.abs(B_left), Math.abs(B_right));
            max = Math.max(Math.abs(max1), Math.abs(max2));
             if (max > 1.0)
            {
                F_left /= max;
                F_right /= max;
                B_left /= max;
                B_right /= max;
            }

            robot.F_leftMotor.setPower(F_left);
            robot.F_rightMotor.setPower(F_right);
            robot.B_leftMotor.setPower(B_left);
            robot.B_rightMotor.setPower(B_right);

            // Use gamepad buttons to move arm up (Y) and down (A)
            /*if (gamepad2.a){
                if(robot.launcher.getPower() > 0.05){
                    robot.launcher.setPower(0);
                    sleep(200);}
                else{
                    robot.launcher.setPower(launch_power);
                    sleep(200);}
            }

            if (gamepad2.x){
                launch_power = launch_power - 0.01;
                robot.launcher.setPower(launch_power);
                sleep(200);}
            if (gamepad2.b){
                launch_power = launch_power +0.01;
                if (launch_power > .15)
                    launch_power = .15;
                robot.launcher.setPower(launch_power);
                sleep(200);}

            if (gamepad2.y)
                robot.Collect_L.setPower(-.3);
            else {
                robot.Collect_L.setPower(gamepad2.right_trigger);
                robot.Collect_U.setPower(0.5 * gamepad2.left_trigger);
            }

            if (gamepad1.a)
                robot.lever.setPosition(.5);
            else
                robot.lever.setPosition(0);
*/
            // Send telemetry message to signify robot running;

           // telemetry.addData("launcher motor speed",  "%.2f", launch_power);
            telemetry.update();

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
        }
    }
}
