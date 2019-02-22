package pl.damiankotynia.model;

import java.io.Serializable;
import java.util.Objects;

public class Request implements Serializable {
    private String function;
    private OptimizationType optimizationType;
    private OptimizationTarget optimizationTarget;
    private int particleAmmount;
    private double interia;
    private double c1;
    private double c2;
    private int iterations;


    public Request() {

    }



    public OptimizationType getOptimizationType() {
        return optimizationType;
    }

    public void setOptimizationType(OptimizationType optimizationType) {
        this.optimizationType = optimizationType;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public OptimizationTarget getOptimizationTarget() {
        return optimizationTarget;
    }

    public void setOptimizationTarget(OptimizationTarget optimizationTarget) {
        this.optimizationTarget = optimizationTarget;
    }

    public int getParticleAmmount() {
        return particleAmmount;
    }

    public void setParticleAmmount(int particleAmmount) {
        this.particleAmmount = particleAmmount;
    }

    public double getInteria() {
        return interia;
    }

    public void setInteria(double interia) {
        this.interia = interia;
    }

    public double getC1() {
        return c1;
    }

    public void setC1(double c1) {
        this.c1 = c1;
    }

    public double getC2() {
        return c2;
    }

    public void setC2(double c2) {
        this.c2 = c2;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return particleAmmount == request.particleAmmount &&
                Double.compare(request.interia, interia) == 0 &&
                Double.compare(request.c1, c1) == 0 &&
                Double.compare(request.c2, c2) == 0 &&
                Objects.equals(function, request.function) &&
                optimizationType == request.optimizationType &&
                optimizationTarget == request.optimizationTarget;
    }

    @Override
    public int hashCode() {

        return Objects.hash(function, optimizationType, optimizationTarget, particleAmmount, interia, c1, c2);
    }
}
