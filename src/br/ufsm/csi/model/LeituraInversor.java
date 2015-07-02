package br.ufsm.csi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by politecnico on 08/06/2015.
 */
@Entity
@Table(name = "LEITURAS")
public class LeituraInversor {

    @Id
    @GeneratedValue
    private Long id;
    private Integer tempModulos;
    private Integer tempAmbiente;
    private Integer irradiancia;
    private Integer vento;
    private double energiaDia;
    private double acFrequency;
    private double acCurrent;
    private double dcCurrent;
    private double potencia;
    private double energiaTotal;
    private double acVoltage;
    private double dcVoltage;
    private double energiaAnual;
    private Date dataHoraLeitura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTempModulos(Integer tempModulos) { this.tempModulos = tempModulos; }

    public Date getDataHoraLeitura() { return dataHoraLeitura; }

    public void setDataHoraLeitura(Date dataHoraLeitura) { this.dataHoraLeitura = dataHoraLeitura; }

    public Integer getTempModulos() { return tempModulos; }

    public Integer getTempAmbiente() { return tempAmbiente; }

    public void setTempAmbiente(Integer temAmbiente) { this.tempAmbiente = temAmbiente; }

    public Integer getIrradiancia() { return irradiancia; }

    public void setIrradiancia(Integer irradiancia) { this.irradiancia = irradiancia; }

    public Integer getVento() { return vento; }

    public void setVento(Integer vento) { this.vento = vento; }

    public double getEnergiaDia() { return energiaDia; }

    public void setEnergiaDia(double energiaDia) { this.energiaDia = energiaDia; }

    public double getAcFrequency() { return acFrequency; }

    public void setAcFrequency(double acFrequency) { this.acFrequency = acFrequency; }

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

    public double getPotencia() { return potencia; }

    public void setPotencia(double potencia) { this.potencia = potencia; }

    public double getEnergiaTotal() { return energiaTotal; }

    public void setEnergiaTotal(double energiaTotal) { this.energiaTotal = energiaTotal / 100; }

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
        this.energiaAnual = energiaAnual / 100;
    }
}
