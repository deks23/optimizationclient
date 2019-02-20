package pl.damiankotynia.optimizationclient;

import pl.damiankotynia.model.OptimizationTarget;
import pl.damiankotynia.model.OptimizationType;
import pl.damiankotynia.model.Request;
import pl.damiankotynia.optimizationclient.connector.OutboundConnection;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        OutboundConnection outboundConnection = null;
        try {
            outboundConnection = new OutboundConnection(4444, "localhost");
        } catch (IOException e) {
            e.printStackTrace();
        }
        outboundConnection.run();

        Request request = new Request();
        request.setC1(0.5);
        request.setC2(0.2);
        request.setInteria(0.5);
        request.setOptimizationTarget(OptimizationTarget.MIN);
        request.setParticleAmmount(100);
        request.setOptimizationType(OptimizationType.PARTACLE_SWARM);
        request.setFunction("f(x, y) = (1 - x)^2 + 100 *  (y-x*x)^2");


        Request request1 = new Request();
        request1.setC1(0.5);
        request1.setC2(0.2);
        request1.setInteria(0.5);
        request1.setOptimizationTarget(OptimizationTarget.MIN);
        request1.setParticleAmmount(100);
        request1.setOptimizationType(OptimizationType.DIFFERENTIAL_EVOLUTION);
        request1.setFunction("f(x, y) = (1 - x)^2 + 100 *  (y-x*x)^2");

        outboundConnection.writeObject(request);
        while(true){

        }
    }
}
