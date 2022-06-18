package org.example;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String tempString;
        double L;
        double R;
        double H;

        JOptionPane.showMessageDialog(null, "Obliczmy poziom cieczy w zbiorniku (cysterna).");
        // zbieranie danych i kontrola czy uzytkownik podal liczbe rzeczywista

        do {
            tempString = JOptionPane.showInputDialog("Podaj dlugosc zbiornika [m]");
        } while (!verify(tempString));
        L = Double.parseDouble(tempString);

        do {
            tempString = JOptionPane.showInputDialog("Podaj srednice zbiornika [m]");
        } while (!verify(tempString));
        R = Double.parseDouble(tempString) / 2;

        do {
            do {
                tempString = JOptionPane.showInputDialog("Podaj wysokosc cieczy w zbiorniku [m]");
            } while (!verify(tempString));
            H = Double.parseDouble(tempString);
            if (H > (2 * R)) {
                JOptionPane.showMessageDialog(null, "Poziom nie moze przekraczac srednicy zbiornika.");
            }
        } while (H > (2 * R));


        // obliczenia pojemnosci plynu w cysternie
        double V;
        double a;
        double b;
        double c;
        if (H <= R) {
            a = 1;
            b = H;
            c = 0;
        } else {
            a = -1;
            b = 2 * R - H;
            c = Math.PI * R * R * L;
        }
        V = a * L * (R * R * Math.acos((R - b) / R) - (R - b) * Math.sqrt(b * (2 * R - b))) + c;
        JOptionPane.showMessageDialog(null, "Dla L=" + L + " R=" + R + " H=" + H + "\nObjetosc plynu w zbiorniku to " + V + " m3");
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