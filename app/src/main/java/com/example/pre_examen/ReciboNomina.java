package com.example.pre_examen;

import java.text.DecimalFormat;

public class ReciboNomina {




   public int numRecibo;
    public String nombre;
    public double horasTrabajadas;
    public double horasExtras;
    public int puesto;
    public double impuestoPor;


    public ReciboNomina(int numRecibo, String nombre, double horasTrabajadas, double horasExtras, int puesto, double impuestoPor) {
        this.numRecibo = numRecibo;
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtras = horasExtras;
        this.puesto = puesto;
        this.impuestoPor = impuestoPor;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getImpuestoPor() {
        return impuestoPor;
    }

    public void setImpuestoPor(double impuestoPor) {
        this.impuestoPor = impuestoPor;
    }

    public int getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(int numRecibo) {
        this.numRecibo = numRecibo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }



    public float calcularSubtotal()
    {
        double resultado=0.0;
        double pagoBase=200;
        double pagoPorHoras=0.0;

            if(this.getPuesto()==1)
            {
                pagoPorHoras=pagoBase+(pagoBase*0.2);
            } else if (this.getPuesto()==2) {
                pagoPorHoras=pagoBase+(pagoBase*0.5);

            } else if (this.getPuesto()==3) {
                pagoPorHoras=pagoBase+(pagoBase*1.0);

            }

            resultado= (pagoBase*this.getHorasTrabajadas())+(this.getHorasExtras()*pagoPorHoras*2);

            return (float) resultado;




    }

    public float calcularImpuesto()
    {
        double resultado=0.0;

        resultado=this.calcularSubtotal()*0.16;
        return (float) resultado;
    }

    public float calcularTotalPagar()
    {
        double pagar=0.0;

        pagar=this.calcularSubtotal()-this.calcularImpuesto();

        return (float) pagar;
    }





}
