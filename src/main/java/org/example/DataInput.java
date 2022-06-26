package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class DataInput {

    static int readNumberOfTanks(){
        int numberOfTanks=100;
        String tempString;

        while (numberOfTanks > 9) {
            do {
                tempString = JOptionPane.showInputDialog("Podaj ilosc zbiornikow (1-9).");
            } while (!DataInput.verify(tempString));
            numberOfTanks = Integer.parseInt(tempString);
        }
        return(numberOfTanks);
    }

    static void readData(ArrayList arrayList){

        System.out.println("ilosc zbiornikow " + arrayList.size());
        String tempString;
        int tankNumber = 1;

        for (int i = 0; i < arrayList.size(); i++) {
            Tank tank = new Tank(0,0,0,0);
            do {
                tempString = JOptionPane.showInputDialog("Podaj dlugosc zbiornika nr " + tankNumber + " [m]");
            } while (!verify(tempString));
            tank.lenght = Double.parseDouble(tempString);

            do {
                tempString = JOptionPane.showInputDialog("Podaj srednice zbiornika nr " + tankNumber + " [m]");
            } while (!verify(tempString));
            tank.radius = Double.parseDouble(tempString) / 2;

            do {
                do {
                    tempString = JOptionPane.showInputDialog("Podaj wysokosc cieczy w zbiorniku " + tankNumber + " [m]");
                } while (!verify(tempString));
                tank.fluidLevel = Double.parseDouble(tempString);

                if (tank.fluidLevel > (2 * tank.radius)) {
                    JOptionPane.showMessageDialog(null, "Poziom nie moze przekraczac srednicy zbiornika.");
                }
            } while (tank.fluidLevel > (2 * tank.radius));
            arrayList.set(i, tank);
            tankNumber++;
            System.out.println(arrayList);
        }
    }

    //funkcja weryfikujaca czy string to liczba rzeczywista dodatnia
    static boolean verify(String potenialNumber) {

        String trimmedNumber = potenialNumber.trim();
        int stringLenght = trimmedNumber.length();
        boolean result = false;
        int iteration = 0;

        for (int i = 0; i < stringLenght; i++) {
            //usuniecie zbednych spacji
            char individualChar = trimmedNumber.charAt(i);
            System.out.println(individualChar);
            //sprawdzenie czy w stringu sa liczby - kody ASCII 48-57 lub znak . ale nie na 1-szej lub ostatniej pozycji
            if ((individualChar >= 48 && individualChar <= 57) || (i > 0 && i < stringLenght - 1 && individualChar == '.')) {
                result = true;
                iteration = i;
            } else {
                result = false;
                iteration = i;
                break;
            }

        }
        //debug info
        System.out.println("iterations: " + iteration);
        System.out.println("result: " + result);
        System.out.println("---------------");
        return result;
    }
}
