package app;

import gui.GUIFactory;
import gui.WindowsFactory;
import gui.macOSFactory;
import logistics.Logistics;
import logistics.RoadLogistics;
import logistics.SeaLogistics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter delivery mode (ROAD/SEA): ");
        String deliveryInput = scanner.nextLine().trim().toUpperCase();

        Logistics logistics = createLogistics(deliveryInput);
        if (logistics == null) {
            System.out.println("Error: unsupported delivery mode '" + deliveryInput + "'. Expected ROAD or SEA.");
            return;
        }

        System.out.print("Enter UI platform (WINDOWS/MACOS): ");
        String platformInput = scanner.nextLine().trim().toUpperCase();

        GUIFactory guiFactory = createGUIFactory(platformInput);
        if (guiFactory == null) {
            System.out.println("Error: unsupported platform '" + platformInput + "'. Expected WINDOWS or MACOS.");
            return;
        }

        DeliveryApplication application = new DeliveryApplication(guiFactory, logistics);
        application.run("laboratory equipment", "UMC Astana");
    }

    private static Logistics createLogistics(String mode) {
        return switch (mode) {
            case "ROAD" -> new RoadLogistics();
            case "SEA" -> new SeaLogistics();
            default -> null;
        };
    }

    private static GUIFactory createGUIFactory(String platform) {
        return switch (platform) {
            case "WINDOWS" -> new WindowsFactory();
            case "MACOS" -> new macOSFactory();
            default -> null;
        };
    }
}