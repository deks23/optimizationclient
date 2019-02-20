package pl.damiankotynia.optimizationclient.connector;


import pl.damiankotynia.model.ChartGeneratorResponse;
import pl.damiankotynia.model.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.Buffer;

import static pl.damiankotynia.optimizationclient.service.Utils.INBOUND_CONNECTION_LOGGER;

public class ResponseListener implements Runnable {
    private ObjectInputStream inputStream;
    private boolean isRunning;

    public ResponseListener(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
        this.isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            Response responseObject = null;

            try {

                Object obj = inputStream.readObject();
                responseObject = (Response)obj;

                //TODO spięcie responsa na sztywno
                ChartGeneratorResponse qwe = (ChartGeneratorResponse)responseObject;

                BufferedImage image = qwe.getImage();
                JLabel picLabel = new JLabel(new ImageIcon(image));

                JPanel jPanel = new JPanel();
                jPanel.add(picLabel);
                JFrame f = new JFrame();

                f.setSize(new Dimension(image.getWidth(), image.getHeight()));
                f.add(jPanel);
                f.setVisible(true);

                System.out.println(INBOUND_CONNECTION_LOGGER + " recieved object ");

            } catch (IOException e) {
                System.out.println("\n Błąd serwera. Kończę działanie aplikacji \n");
                isRunning ^= true;
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("\n Niepoprawna odpowiedź serwera. Kończę działanie aplikacji \n");
                isRunning ^= true;
            }
        }
    }


}



