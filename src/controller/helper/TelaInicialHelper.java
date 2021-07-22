/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;


import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JTextField;
import model.Aparelho;
import view.TelaInicial;

/**
 *
 * @author Casa
 */
public class TelaInicialHelper {
    
    private final TelaInicial view;

    public TelaInicialHelper(TelaInicial view) {
        this.view = view;
    }

    public Aparelho obterModelo() {//busca os valores de todos os campos
        String potenciaString = view.getTxtKW().getText();
        String horasString = view.getTxtHoras().getText();
        String minutosString = view.getTxtMinutos().getText();
        String precoString = view.getTxtCusto().getText();
        
        //Trocando a , por .
        precoString = precoString.replace(",", ".");
        horasString = horasString.replace(",", ".");
        
        //Verifica se todos os campos necessários foram preenchidos
        if ((!"".equals(potenciaString)) && (!"".equals(precoString)) && (!"".equals(horasString) || !"".equals(minutosString))){
            
            if (!"".equals(horasString)){//Caso a conta seja feita com a hora
                int potencia = Integer.parseInt(potenciaString);
                float horas = Float.parseFloat(horasString);
                float preco = Float.parseFloat(precoString);

                Aparelho aparelho = new Aparelho(potencia, horas, preco);

                return aparelho;
            } else {//caso seja com os minutos
                int potencia = Integer.parseInt(potenciaString);
                int minutos = Integer.parseInt(minutosString);
                float preco = Float.parseFloat(precoString);

                Aparelho aparelho = new Aparelho(potencia, preco, minutos);
                
                return aparelho;
            }
            
        } else {
            return null;
        }
        
        
    }

    public void exibirResultado(double custo) {
        
        //Define o país da moeda
        Locale ptBr = new Locale("pt", "BR");
        //Converte o valor em float pra reais
        String custoF = NumberFormat.getCurrencyInstance(ptBr).format(custo);
        
        this.view.getLblResult().setText("Custo Mensal:");
        this.view.getLblValor().setText(custoF);
        
        this.view.getLblErro().setText("");
        
    }

    public void limpa() {
        
        this.view.getLblResult().setText("");
        this.view.getLblValor().setText("");
        this.view.getTxtKW().setText("");
        this.view.getTxtHoras().setText("");
        this.view.getTxtMinutos().setText("");
        this.view.getTxtCusto().setText("");
        this.view.getLblErro().setText("");
    }

    public void erroFormulario() {
        this.view.getLblErro().setText("Preencha todos os campos.");
    }

    //Usado para limpar os campos de horas ou minutos
    public void limpaCampo(JTextField campo) {
        campo.setText("");
    }

    
    
}
