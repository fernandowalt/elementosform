package org.walter.pooclasesabstractas.elementos;


import org.walter.pooclasesabstractas.validador.Validador;
import org.walter.pooclasesabstractas.validador.mensaje.MensajeFormateable;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementosForm {

    protected String valor;
    protected String nombre;

    private List<Validador> validadores;
    private List<String> errores;

    ElementosForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }


    public ElementosForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public ElementosForm addValidador(Validador validador) {
        this.validadores.add(validador);
        return this;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setValor(String valor) {
        this.valor = valor;


    }

    public boolean esValido() {
        for (Validador v : this.validadores) {
            if (!v.esValido(this.valor)) {
                if (v instanceof MensajeFormateable) {
                    this.errores.add(((MensajeFormateable) v).getMensajeFormateado(nombre));
                } else {
                    this.errores.add(String.format(v.getMensaje(), nombre));
                }


            }
        }

        return this.errores.isEmpty();
    }

    public abstract String dibujarHtml();

}
