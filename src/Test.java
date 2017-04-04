/**
 * Created by mbenndorf on 04.04.2017.
 */

import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        DifferentialPilot pilot = new DifferentialPilot(5.5, 11, Motor.A, Motor.B);

        pilot.setAcceleration(20);
        pilot.setTravelSpeed(20);

//        nikolaus(pilot);
        kroete(pilot);
    }

    private static void kroete(final DifferentialPilot pilot) {
        TouchSensor rechts = new TouchSensor(SensorPort.S1);
        TouchSensor links = new TouchSensor(SensorPort.S3);

        boolean lastDir = true;
        while (!Button.ESCAPE.isDown()) {
            System.out.println("RUN");
            if (rechts.isPressed()) {
                lastDir = true;
                System.out.println("RIGHT");
                pilot.stop();
                System.out.println("stopped");
                if (links.isPressed()) {
                    pilot.travel(-15);
                    pilot.rotate(-30);
                } else {
                    pilot.travel(-7);
                    pilot.rotate(-17);
                }
            } else if (links.isPressed()) {
                lastDir = false;
                System.out.println("LEFT");
                pilot.stop();
                System.out.println("stopped");
                if (rechts.isPressed()) {
                    pilot.travel(-15);
                    pilot.rotate(30);
                } else {
                    pilot.travel(-4);
                    pilot.rotate(17);
                }
            }

            if (lastDir) {
                System.out.println("ARC +");
                pilot.arcForward(150);
            } else {
                System.out.println("ARC -");
                pilot.arcForward(-150);
            }
        }
    }

    private static void nikolaus(DifferentialPilot pilot) throws InterruptedException {
        pilot.travel(50);
        pilot.rotate(90 + 45);
        System.out.print("Das ");
        pilot.travel(70.7106781187);
        pilot.rotate(-(90 + 45));
        System.out.print("ist ");
        pilot.travel(50);
        pilot.rotate(-45);
        System.out.print("das ");
        pilot.travel(35.35533905932737622004221810524245196424179688442370182941);
        pilot.rotate(-90);
        System.out.print("Haus ");
        pilot.travel(35.35533905932737622004221810524245196424179688442370182941);
        pilot.rotate(-(45 + 90));
        System.out.print("des \n");
        pilot.travel(50);
        pilot.rotate(45 + 90);
        System.out.print("Ni");
        pilot.travel(70.7106781187);
        pilot.rotate(-(45 + 90));
        System.out.print("ko");
        pilot.travel(50);
        pilot.rotate(180);
        System.out.print("laus");
        pilot.travel(50);
        pilot.rotate(90);
        System.out.print("!");
        Sound.beep();
        Thread.sleep(1000);
    }
}
