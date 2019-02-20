package pl.damiankotynia.optimizationclient.view;

public class Cli {
    public static void printMainMenu(){
        System.out.println("1. Podaj funkcję do optymalizacji.");
        System.out.println("2. Zakończ działanie.\n");
    }

    public static void printOptimizationType(){
        System.out.println("Wybierz algorytm optymalizacji:");
        System.out.println("1. Algorytm PSO");
        System.out.println("2. Algorytm DE\n");
    }

    public static void printOptimizationTarget(){
        System.out.println("Wybierz cel optymalizacji:");
        System.out.println("1. Minimalizacja");
        System.out.println("2. Maksymalizacja \n");
    }

    public static void printParticleAmmount(){
        System.out.println("Podaj liczę cząstek: \n");
    }

    public static void  printEnterC1(){
        System.out.println("Podaj parametr c1: \n");
    }

    public static void  printEnterC2(){
        System.out.println("Podaj parametr c2: \n");
    }


    public static void printInteria(){
        System.out.println("Podaj parametr bezwladnosci: \n");
    }


    public static void  printEnterCr(){
        System.out.println("Podaj parametr Cr: \n");
    }


    public static void  printEnterF(){
        System.out.println("Podaj parametr F: \n");
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
    public static void clearDisplay(){
        System.out.flush();
    }




}
