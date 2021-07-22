/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.helper.TelaInicialHelper;
import javax.swing.JTextField;
import model.Aparelho;
import view.TelaInicial;

/**
 *
 * @author Casa
 */
public class TelaInicialController {
    
    private final TelaInicialHelper helper;

    public TelaInicialController(TelaInicial view) {
        this.helper = new TelaInicialHelper(view);
    }
    
    public void calcularGastos() {
        Aparelho aparelho = helper.obterModelo();
        
        if (aparelho == null){
            this.helper.erroFormulario();
        } else {
            double custo = aparelho.calcular();
        
            this.helper.exibirResultado(custo);
        }
        
    }

    public void limparTela() {
        this.helper.limpa();
    }

    public void limparCampo(JTextField campo) {
        this.helper.limpaCampo(campo);
    }

    
}
