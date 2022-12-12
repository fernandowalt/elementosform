package org.walter.pooclasesabstractas.elementos;

public class TextAreaForm extends ElementosForm {
    private int filas;
    private int columnas;

    public TextAreaForm(String nombre) {
        super(nombre);

    }

    public TextAreaForm(String nombre, int filas, int columnas) {
        super(nombre);
        this.filas = filas;
        this.columnas = columnas;
    }


    public void setFilas(int filas) {
        this.filas = filas;

    }

    public int getFilas() {
        return filas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getColumnas() {
        return columnas;
    }


    @Override
    public String dibujarHtml() {
        return "<textarea name=" + this.nombre + " cols=" + this.columnas + " rows=" + this.filas + ">" + this.valor + "</textarea>";
    }
}
