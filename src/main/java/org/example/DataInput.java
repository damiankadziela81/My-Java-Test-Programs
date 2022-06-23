package org.example;

import javax.swing.*;

public class DataInput {

    static void readData(Tank[] tankArray){
        System.out.println("ilosc zbiornikow " + tankArray.length);
        String tempString;
        int i = 1;
        for (Tank x : tankArray) {
            do {
                tempString = JOptionPane.showInputDialog("Podaj dlugosc zbiornika nr "+i+" [m]");
            } while (!verify(tempString));
            x.lenght = Double.parseDouble(tempString);

            do {
                tempString = JOptionPane.showInputDialog("Podaj srednice zbiornika nr "+i+" [m]");
            } while (!verify(tempString));
            x.radius = Double.parseDouble(tempString) / 2;

            do {
                do {
                    tempString = JOptionPane.showInputDialog("Podaj wysokosc cieczy w zbiorniku "+i+" [m]");
                } while (!verify(tempString));
                x.fluidLevel = Double.parseDouble(tempString);
                if (x.fluidLevel > (2 * x.radius)) {
                    JOptionPane.showMessageDialog(null, "Poziom nie moze przekraczac srednicy zbiornika.");
                }
            } while (x.fluidLevel > (2 * x.radius));
            i++;

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
