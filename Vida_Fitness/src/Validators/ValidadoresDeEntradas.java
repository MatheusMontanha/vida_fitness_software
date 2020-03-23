/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validators;

/**
 *
 * @author mathe
 */
public class ValidadoresDeEntradas {

    private final String regexNumero = "[0-9]+";

    public boolean entradaDeTelefone(String text) {
        return text.matches(regexNumero);
    }

    public String separarNumeros(String texto) {
        int numero;
        String textoSemEspaco = texto.trim();
        String textoComNumeros = "";
        for (int i = 0; i < textoSemEspaco.length(); i++) {
            try {
                numero = Integer.parseInt("" + textoSemEspaco.charAt(i));
                textoComNumeros += "" + numero;
            } catch (NumberFormatException e) {
            }
        }
        return textoComNumeros;
    }
}
