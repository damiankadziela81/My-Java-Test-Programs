package org.example;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Tank tank1 = new Tank(0,0,0,0);
        Tank tank2 = new Tank(0,0,0,0);
        Tank tank3 = new Tank(0,0,0,0);
        Tank[] tankArray = {tank1,tank2,tank3};

        JOptionPane.showMessageDialog(null, "Obliczmy poziom cieczy w 3 zbiornikach (cysternach).");

        for (int i = 0; i < 3; i++) {
            double lenght;
            double radius;
            double fluidLevel;
            String tempString;

            // zbieranie danych i kontrola czy uzytkownik podal liczbe rzeczywista

            do {
                tempString = JOptionPane.showInputDialog("Podaj dlugosc zbiornika nr "+(i+1)+" [m]");
            } while (!verify(tempString));
            lenght = Double.parseDouble(tempString);

            do {
                tempString = JOptionPane.showInputDialog("Podaj srednice zbiornika nr "+(i+1)+" [m]");
            } while (!verify(tempString));
            radius = Double.parseDouble(tempString) / 2;

            do {
                do {
                    tempString = JOptionPane.showInputDialog("Podaj wysokosc cieczy w zbiorniku "+(i+1)+" [m]");
                } while (!verify(tempString));
                fluidLevel = Double.parseDouble(tempString);
                if (fluidLevel > (2 * radius)) {
                    JOptionPane.showMessageDialog(null, "Poziom nie moze przekraczac srednicy zbiornika.");
                }
            } while (fluidLevel > (2 * radius));

            tankArray[i].lenght = lenght;
            tankArray[i].radius = radius;
            tankArray[i].fluidLevel = fluidLevel;
        }

        // obliczenia pojemnosci plynu w cysternach
        double arrayVolume=0;
        for (int i = 0; i < 3; i++) {
            tankArray[i].calculateVolume();
            arrayVolume=arrayVolume+tankArray[i].fluidVolume;
            JOptionPane.showMessageDialog(null, "Dla L=" + tankArray[i].lenght + " R=" + tankArray[i].radius + " H=" + tankArray[i].fluidLevel + "\nObjetosc plynu w zbiorniku nr "+(i+1)+" to " + tankArray[i].fluidVolume + " m3");
        }

        JOptionPane.showMessageDialog(null, "Objetosc plynu w zbiornikach to " + arrayVolume + " m3");
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

        System.out.println("iterations: " + iteration);
        System.out.println("result: " + result);
        System.out.println("---------------");
        return result;
    }

}