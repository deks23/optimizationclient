package pl.damiankotynia.optimizationclient.connector;


import pl.damiankotynia.model.ChartGeneratorResponse;
import pl.damiankotynia.model.Response;
import pl.damiankotynia.model.ResponseType;
import pl.damiankotynia.optimizationclient.view.ChartView;
import pl.damiankotynia.optimizationclient.view.Cli;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.Buffer;

import static pl.damiankotynia.optimizationclient.service.Utils.INBOUND_CONNECTION_LOGGER;
import static pl.damiankotynia.optimizationclient.service.Utils.isEmpty;

public class ResponseListener implements Runnable {
    final private ObjectInputStream inputStream;
    private boolean isRunning;
    private ChartView chartView;

    public ResponseListener(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
        this.isRunning = true;
        this.chartView = new ChartView();
    }

    @Override
    public void run() {
        while (isRunning) {
            Response responseObject = null;

            try{

                Object obj = inputStream.readObject();
                responseObject = (Response)obj;

                //TODO spięcie responsa na sztywno

                if(!isEmpty(responseObject.getMessage()) && responseObject.getResponseType().equals(ResponseType.FINISHED)){
                    Cli.printMessage(responseObject.getMessage());
                    Cli.clearDisplay();
                    Cli.printMainMenu();
                }

                if( responseObject.getResponseType().equals(ResponseType.IMAGE)){
                    ChartGeneratorResponse chartGeneratorResponse = (ChartGeneratorResponse)responseObject;
                    BufferedImage image = chartGeneratorResponse.getImage();
                    chartView.showImage(image);

                }
            } catch (IOException e) {
                System.out.println("\n Błąd serwera. Kończę działanie aplikacji \n");
                isRunning ^= true;
            } catch (ClassNotFoundException e) {
                System.out.println("\n Niepoprawna odpowiedź serwera. Kończę działanie aplikacji \n");
                isRunning ^= true;
            }
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void kill(){
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        isRunning = false;
    }


}



