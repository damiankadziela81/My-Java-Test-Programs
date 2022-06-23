package org.example;

public class Tank {
    double lenght;
    double radius;
    double fluidLevel;
    double fluidVolume;
    Tank(double lenght, double radius, double fluidLevel,double fluidVolume){
        this.lenght = lenght;
        this.radius = radius;
        this.fluidLevel = fluidLevel;
        this.fluidVolume= fluidVolume;
    }



    void calculateVolume(){
        double a;
        double b;
        double c;
        if (fluidLevel <= radius) {
            a = 1;
            b = fluidLevel;
            c = 0;
        } else {
            a = -1;
            b = 2 * radius - fluidLevel;
            c = Math.PI * radius * radius * lenght;
        }
        this.fluidVolume = a * lenght * (radius * radius * Math.acos((radius - b) / radius) - (radius - b) * Math.sqrt(b * (2 * radius - b))) + c;
        System.out.println(this.fluidVolume);
        System.out.println("++++++++++++++++++++++++++++++++");

    }

}
