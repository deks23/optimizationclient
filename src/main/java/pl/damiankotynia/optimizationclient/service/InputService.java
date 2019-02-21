package pl.damiankotynia.optimizationclient.service;



import org.mariuszgromada.math.mxparser.Function;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class InputService {

    private Scanner input;

    public InputService(){
        input = new Scanner(System.in);
    }

    public String getString(){
        String returnValue = input.nextLine();
        return returnValue;
    }

    public long getLong(){
        boolean isCorrect = false;
        long returnValue = 0;
        while(!isCorrect){
            String value = input.nextLine();
            try{
                returnValue = Long.parseLong(value);
                isCorrect = true;
            }catch (NumberFormatException e){
                System.out.println("Podana wartosc jest niepoprawna");
            }
        }
        return returnValue;
    }

    public int getMainMenuInput(int max){
        boolean isCorrect = false;
        int returnValue = 0;
        while(!isCorrect){
            String value = input.nextLine();
            try{
                returnValue = Integer.parseInt(value);
                if(returnValue>=0 && returnValue<max)
                    isCorrect = true;
                else
                    System.out.println("Podana wartosc jest niepoprawna");
            }catch (NumberFormatException e){
                System.out.println("Podana wartosc jest niepoprawna");
            }
        }
        return returnValue;
    }

    public boolean getAreYouSure(){
        while (true){
            System.out.println("Czy napewno? (T/N)");
            String value = input.nextLine();
            if(value.length()==1){
                if(value.equals("T")||value.equals("t"))
                    return true;
                else if(value.equals("N")||value.equals("n"))
                    return false;
            }
            System.out.println("Podano niepoprawny symbol");
        }
    }


    public int getInteger(){
        boolean isCorrect = false;
        int returnValue = 0;
        while(!isCorrect){
            String value = input.nextLine();
            try{
                returnValue = Integer.parseInt(value);
                isCorrect = true;
            }catch (NumberFormatException e){
                System.out.println("Podana wartosc jest niepoprawna");
            }
        }
        return returnValue;
    }

    public double getDouble(){
        boolean isCorrect = false;
        double returnValue = 0;
        while(!isCorrect){
            String value = input.nextLine();
            try{
                returnValue = Double.parseDouble(value);
                isCorrect = true;
            }catch (NumberFormatException e){
                System.out.println("Podana wartosc jest niepoprawna");
            }
        }
        return returnValue;
    }

    public int getIndex(int max){
        boolean isCorrect = false;
        int returnValue = 0;
        while(!isCorrect){
            returnValue = getInteger();
            if(returnValue<=max)
                isCorrect = !isCorrect;
            else
                System.out.println("Wartość minimalna wartość to 0 a maksymalna to " + max);
        }
        return returnValue;
    }

    public String getFunctionString(){
        boolean isCorrect = false;
        String returnValue = null;
        while(!isCorrect){
            returnValue = getString();
            Function function = new Function(returnValue);
            if(function.checkSyntax())
                isCorrect = true;
            else
                System.out.println("Podano niepoprawna funkcje");
        }
        return returnValue;
    }



}
