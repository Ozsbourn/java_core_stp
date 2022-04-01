package com.stp2;

import java.util.Scanner;
import com.stp2.CarPackage;

public class Main {

    public static void main(String[] args) {
        mainLoop();
    }

    public static void mainLoop(){
        Scanner in = new Scanner(System.in);
        CarPackage cp = new CarPackage();

        while (true) {
            System.out.println("\n1. Add car\n2. Modify car\n3. Delete car\n4. Read from File\n5. Write to file\n6. Show cars\n7. Exit\n");
            System.out.print("Input a number of command: ");

            switch (in.nextInt()) {
                case 1: {
                    String name = in.next();
                    String strParams = in.nextLine();
                    String[] params = strParams.split(" ");
                    cp.addCar(name, params);
                    System.out.println("Car added!\n");
                    break;
                }
                case 2: {
                    String name = in.next();
                    String oldValue = in.next();
                    String newValue = in.next();
                    boolean flag = cp.modifyCar(name, oldValue, newValue);

                    if (flag == true) {

                    } else {
                        System.out.println("Car wasn't successfully modify!");
                    }

                    break;
                }
                case 3: {
                    String name = in.next();
                    boolean flag = cp.deleteCar(name);

                    if (flag == true) {
                        System.out.println("Car was successfully delete!");
                    } else {
                        System.out.println("Car wasn't successfully delete!");
                    }

                    break;
                }
                case 4: {
                    cp.readFromFile();
                    break;
                }
                case 5: {
                    cp.writeToFile();
                }
                case 6: {
                    cp.showCarPackage();
                    break;
                }
                case 7: {
                    return;
                }
                default:
                    System.out.println("Enter the correct operation!\n");
            }
        }
    }
}