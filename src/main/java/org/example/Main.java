package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int numberOfTanks = DataInput.readNumberOfTanks();

        ArrayList<Tank> tankArrayList = new ArrayList<>();
        for (int i = 0; i < numberOfTanks; i++) {
            Tank tank = new Tank(0,0,0,0);
            tankArrayList.add(tank);
        }
        System.out.println("ArrayList " + tankArrayList);
        System.out.println("size of arryList " + tankArrayList.size());

        JOptionPane.showMessageDialog(null, "Obliczmy poziom cieczy w " + tankArrayList.size() + " zbiornikach (cysternach).");

        DataInput.readData(tankArrayList);

        // obliczenia pojemnosci plynu w cysternach
        double arrayVolume=0;
        for (int i = 0; i < tankArrayList.size(); i++) {
            Tank tank;
            tank = tankArrayList.get(i);
            tank.calculateVolume();
            arrayVolume=arrayVolume+tank.fluidVolume;
            JOptionPane.showMessageDialog(null, "Dla zbiornika nr"+(i+1)+" L=" + tank.lenght + " R=" +
                    tank.radius + " H=" + tank.fluidLevel + "\nObjetosc plynu wynosi: " + tank.fluidVolume + " m3");

        }

        JOptionPane.showMessageDialog(null, "Objetosc plynu w zbiornikach to " + arrayVolume + " m3");
    }
}