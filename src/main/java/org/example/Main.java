package org.example;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String tempString;
        Tank tank = new Tank();

        JOptionPane.showMessageDialog(null, "Obliczmy poziom cieczy w zbiorniku (cysterna).");
        // zbieranie danych i kontrola czy uzytkownik podal liczbe rzeczywista

        do {
            tempString = JOptionPane.showInputDialog("Podaj dlugosc zbiornika [m]");
        } while (!verify(tempString));
        tank.lenght = Double.parseDouble(tempString);

        do {
            tempString = JOptionPane.showInputDialog("Podaj srednice zbiornika [m]");
        } while (!verify(tempString));
        tank.radius = Double.parseDouble(tempString) / 2;

        do {
            do {
                tempString = JOptionPane.showInputDialog("Podaj wysokosc cieczy w zbiorniku [m]");
            } while (!verify(tempString));
            tank.fluidLevel = Double.parseDouble(tempString);
            if (tank.fluidLevel > (2 * tank.radius)) {
                JOptionPane.showMessageDialog(null, "Poziom nie moze przekraczac srednicy zbiornika.");
            }
        } while (tank.fluidLevel > (2 * tank.radius));


        // obliczenia pojemnosci plynu w cysternie
        double volume;
        volume=calculateVolume(tank.lenght, tank.radius, tank.fluidLevel);
        JOptionPane.showMessageDialog(null, "Dla L=" + tank.lenght + " R=" + tank.radius + " H=" + tank.fluidLevel + "\nObjetosc plynu w zbiorniku to " + volume + " m3");
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

    static double calculateVolume (double lenght,double radius, double level){
        double a;
        double b;
        double c;
        if (level <= radius) {
            a = 1;
            b = level;
            c = 0;
        } else {
            a = -1;
            b = 2 * radius - level;
            c = Math.PI * radius * radius * lenght;
        }
        return a * lenght * (radius * radius * Math.acos((radius - b) / radius) - (radius - b) * Math.sqrt(b * (2 * radius - b))) + c;
        }

}