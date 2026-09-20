# Design Pattern Factory — Logistics and GUI Application

## Project Purpose

This is a simple Java console application. It shows two design patterns working together:

- **Factory Method** — used to create a transport (`Truck` or `Ship`) for delivery.
- **Abstract Factory** — used to create a matching pair of UI components (`Button` and `Checkbox`) for Windows or macOS.

The user chooses a delivery mode (ROAD or SEA) and a UI platform (WINDOWS or MACOS). The program creates the correct transport and the correct UI family, and then shows the result in the console.

This project was made for the "Software Design Patterns" course assignment (Factory Method and Abstract Factory).

## Package Structure

```
src/
  logistics/
    Transport.java          - interface for delivery behavior
    Truck.java               - concrete transport (road)
    Ship.java                 - concrete transport (sea)
    Logistics.java           - abstract creator, has planDelivery()
    RoadLogistics.java       - concrete creator, creates Truck
    SeaLogistics.java        - concrete creator, creates Ship

  gui/
    Button.java               - interface for a button
    Checkbox.java             - interface for a checkbox
    WindowsButton.java       - Windows button
    MacOSButton.java         - macOS button
    WindowsCheckbox.java    - Windows checkbox
    MacOSCheckbox.java      - macOS checkbox
    GUIFactory.java           - abstract factory interface
    WindowsFactory.java     - creates Windows UI family
    MacOSFactory.java       - creates macOS UI family

  app/
    DeliveryApplication.java - client class, uses Logistics and GUIFactory
    Main.java                  - entry point, reads user input and starts the app
```

## Prerequisites

- **JDK 17** or newer
- Any Java IDE (this project was built with IntelliJ IDEA), or you can compile it manually with the `javac` command

## How to Build and Run

### Option 1: Using an IDE (recommended)

1. Open the project folder in IntelliJ IDEA (or another Java IDE).
2. Wait for the IDE to index the project.
3. Open `src/app/Main.java`.
4. Click the green "Run" button, or right-click the file and choose **Run 'Main.main()'**.

### Option 2: Using the terminal

From the project root folder, run:

```bash
# Compile all Java files
javac -d out src/logistics/*.java src/gui/*.java src/app/*.java

# Run the program
java -cp out app.Main
```

## Supported Input Values

The program asks for two inputs, one after another:

1. **Delivery mode**: `ROAD` or `SEA`
2. **UI platform**: `WINDOWS` or `MACOS`

Input is not case sensitive (`road`, `Road`, and `ROAD` all work). Extra spaces are also removed automatically.

If you type something else (for example `road123` or `LINUX`), the program will print a clear error message and stop. It will not use a default value and it will not crash.

## Sample Run

**Input:**
```
Enter delivery mode (ROAD/SEA): ROAD
Enter UI platform (WINDOWS/MACOS): WINDOWS
```

**Output:**
```
Producing Windows button
Producing Windows checkbox
Truck delivers building materials to BI Group Astana
```

## Author

- **Name:** Adilzhan Kuandykov
- **Group:** SE-2526
- **Course:** ShP-2216 Software Design Patterns
