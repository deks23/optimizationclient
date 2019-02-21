package pl.damiankotynia.optimizationclient;

import pl.damiankotynia.model.OptimizationTarget;
import pl.damiankotynia.model.OptimizationType;
import pl.damiankotynia.model.Request;
import pl.damiankotynia.optimizationclient.connector.OutboundConnection;
import pl.damiankotynia.optimizationclient.service.InputService;
import pl.damiankotynia.optimizationclient.view.Cli;

import java.io.IOException;

public class Main {
    public static boolean wait = false;

    public static void main(String[] args) {
        OutboundConnection outboundConnection = null;
        InputService inputService = new InputService();
        boolean exit = false;

        try {
            outboundConnection = new OutboundConnection(4444, "localhost");
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (!exit) {
            while (!wait){
                Cli.printMainMenu();
                switch (inputService.getMainMenuInput(3)) {
                    case 1:
                        Request req = new Request();
                        insertRequestCommonData(inputService, req);
                        if(req.getOptimizationType().equals(OptimizationType.PARTACLE_SWARM)){
                            setPSOData(inputService, req);
                        }else {
                            setDEData(inputService, req);
                        }
                        outboundConnection.writeObject(req);
                        wait = true;
                        break;

                    case 2:
                        System.out.println("\nZakończyć działanie programu? ");
                        exit = inputService.getAreYouSure();
                        break;


                }
            }
        }

        outboundConnection.kill();
    }

    private static void setDEData(InputService inputService, Request req) {
        Cli.printEnterCr();
        req.setC1(inputService.getDouble());
        Cli.printEnterF();
        req.setC2(inputService.getDouble());
    }

    private static void setPSOData(InputService inputService, Request req) {
        Cli.printEnterC1();
        req.setC1(inputService.getDouble());
        Cli.printEnterC2();
        req.setC2(inputService.getDouble());
        Cli.printEnterInteria();
        req.setInteria(inputService.getDouble());
    }

    private static void insertRequestCommonData(InputService inputService, Request req) {
        Cli.printOptimizationType();
        if(inputService.getMainMenuInput(2)==1)
            req.setOptimizationType(OptimizationType.PARTACLE_SWARM);
        else
            req.setOptimizationType(OptimizationType.DIFFERENTIAL_EVOLUTION);

        Cli.printOptimizationTarget();
        if(inputService.getMainMenuInput(2)==1)
            req.setOptimizationTarget(OptimizationTarget.MIN);
        else
            req.setOptimizationTarget(OptimizationTarget.MAX);
        Cli.printParticleAmmount();
        req.setParticleAmmount(inputService.getInteger());
        Cli.printEnterFunction();
        req.setFunction(inputService.getFunctionString());
    }
}
