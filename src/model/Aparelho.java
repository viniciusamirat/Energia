/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Casa
 */
public class Aparelho {
    
    private int potencia;
    private double horas = 0d;
    private int minutos;
    private float preco;

    public Aparelho(int potencia, double horas, float preco) {
        this.potencia = potencia;
        this.horas = horas;
        this.preco = preco;
    }

    public Aparelho(int potencia, float preco, int minutos) {
        this.potencia = potencia;
        this.minutos = minutos;
        this.preco = preco;
    }
    

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(float horas) {
        this.horas = horas;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public double calcular() {
        if (this.horas != 0){//caso o cálculo seja com a hora
            double energia = (this.potencia * this.horas * 30) / 1000;
            double custo = energia * this.preco;
            
            return custo;
        } else {//caso ele seja com minutos
            
            double minutosD = (double) this.minutos;
            double potenciaD = (double) this.potencia;
            
            double horasFormulario = minutosD / 60d;
            
            double energia = (potenciaD * horasFormulario * 30d) / 1000d;
            double custo = energia * this.preco;
            
            return custo;
        }
    }
    
    
}
