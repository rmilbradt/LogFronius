package br.ufsm.csi.model;

import javax.json.JsonNumber;

/**
 * Created by politecnico on 08/06/2015.
 */
public class LeituraInversor {
    private double temperatura1;
    private double temperatura2;
    private double energiaDia;
    private double acFrequency;
    private double acCurrent;
    private double dcCurrent;
    private double energiaAtual;
    private double energiaTotal;
    private double acVoltage;
    private double dcVoltage;
    private double energiaAnual;

    public double getTemperatura1() {
        return temperatura1;
    }

    public void setTemperatura1(double temperatura1) {
        this.temperatura1 = temperatura1;
    }

    public double getTemperatura2() {
        return temperatura2;
    }

    public void setTemperatura2(double temperatura2) {
        this.temperatura2 = temperatura2;
    }

    public double getEnergiaDia() {
        return energiaDia;
    }

    public void setEnergiaDia(double energiaDia) {
        this.energiaDia = energiaDia;
    }

    public double getAcFrequency() {
        return acFrequency;
    }

    public void setAcFrequency(double acFrequency) {
        this.acFrequency = acFrequency;
    }

    public double getAcCurrent() {
        return acCurrent;
    }

    public void setAcCurrent(double acCurrent) {
        this.acCurrent = acCurrent;
    }

    public double getDcCurrent() {
        return dcCurrent;
    }

    public void setDcCurrent(double dcCurrent) {
        this.dcCurrent = dcCurrent;
    }

    public double getEnergiaAtual() {
        return energiaAtual;
    }

    public void setEnergiaAtual(double energiaAtual) {
        this.energiaAtual = energiaAtual;
    }

    public double getEnergiaTotal() {
        return energiaTotal;
    }

    public void setEnergiaTotal(double energiaTotal) {
        this.energiaTotal = energiaTotal;
    }

    public double getAcVoltage() {
        return acVoltage;
    }

    public void setAcVoltage(double acVoltage) {
        this.acVoltage = acVoltage;
    }

    public double getDcVoltage() {
        return dcVoltage;
    }

    public void setDcVoltage(double dcVoltage) {
        this.dcVoltage = dcVoltage;
    }

    public double getEnergiaAnual() {
        return energiaAnual;
    }

    public void setEnergiaAnual(double energiaAnual) {
        this.energiaAnual = energiaAnual;
    }
}
