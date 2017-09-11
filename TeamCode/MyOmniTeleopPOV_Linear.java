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

@TeleOp(name="Particle Accelerator Omni v4", group="Neon Knights")
//@Disabled

public class MyOmniTeleopPOV_Linear extends LinearOpMode {


    MyHardwareOmni robot           = new MyHardwareOmni();   // Use Neon Knights HW class


    /* Declare OpMode members. */                  // Servo mid position

    @Override
    public void runOpMode() throws InterruptedException {
        double d1;
        double d2;
        double d3;
        double d4;
        double max;
        double maxa;
        double maxb;

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Omni Driver");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Run wheels in POV mode (note: The joystick goes negative when pushed forwards, so negate it)  v
            // In this mode the Left stick moves the robot fwd and back, the Right stick turns left and right.

            d1  = gamepad1.left_stick_y + gamepad1.right_stick_x + gamepad1.right_trigger - gamepad1.left_trigger;
            d2 = -gamepad1.left_stick_x + gamepad1.right_stick_x + gamepad1.right_trigger - gamepad1.left_trigger;
            d3 = gamepad1.left_stick_y - gamepad1.right_stick_x - gamepad1.right_trigger + gamepad1.left_trigger;
            d4 = -gamepad1.left_stick_x - gamepad1.right_stick_x - gamepad1.right_trigger + gamepad1.left_trigger;

            // Normalize the values so neither exceed +/- 1.0
            maxa = Math.max(Math.abs(d1), Math.abs(d2));
            maxb = Math.max(Math.abs(d2), Math.abs(d4));
            max = Math.max(Math.abs(maxa), Math.abs(maxb));
            if (max > 1.0)
            {
                d1 /= max;
                d2 /= max;
                d3 /= max;
                d4 /= max;
            }

            robot.D1Motor.setPower(d1);
            robot.D2Motor.setPower(d2);
            robot.D3Motor.setPower(d3);
            robot.D4Motor.setPower(d4);

            // Use gamepad buttons to move arm up (Y) and down (A)
           /* if (gamepad1.a)
                robot.lever.setPosition(.5);
            else
                robot.lever.setPosition(0.0);

            */
             //Send telemetry message to signify robot running;

            telemetry.update();

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
        }
    }
}
