package org.walter.pooclasesabstractas;

import org.walter.pooclasesabstractas.elementos.*;
import org.walter.pooclasesabstractas.select.Opcion;
import org.walter.pooclasesabstractas.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploAbstractas {
    public static void main(String[] args) {

        InputForm userName = new InputForm("username");
        userName.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador()).addValidador(new LargoValidador(6, 12));


        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador()).addValidador(new EmailValidador());


        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador()).addValidador(new RequeridoValidador());

        TextAreaForm experiencia = new TextAreaForm("experiencia", 5, 9);

        SelectForm lenguaje = new SelectForm("Lenguaje");
        lenguaje.addValidador(new NoNuloValidador());
        Opcion java = new Opcion("1", "java");
        Opcion javascript = new Opcion("2", "javascript");
        Opcion php = new Opcion("3", "php");
        Opcion python = new Opcion("4", "python").setSelected();

        lenguaje.addOpcion(java)
                .addOpcion(javascript)
                .addOpcion(php)
                .addOpcion(python);

        ElementosForm saludar = new ElementosForm("Saludo") {

            @Override
            public String dibujarHtml() {
                return "<input disabled name='" + this.nombre + "' value=\"" + this.valor + "\">";
            }
        };

        saludar.setValor("Hola que tal este campo esta deshabilitado");
        userName.setValor("walter");
        password.setValor("d4");
        email.setValor("jhon.do@gmail.com");
        edad.setValor("28");
        experiencia.setValor("mas de 10 años de experiencia");


        List<ElementosForm> elementos = Arrays.asList(userName, password, email, edad, experiencia, lenguaje, saludar);

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e -> {
            if (!e.esValido()) {
                e.getErrores().forEach(System.out::println);
            }
        });


    }
}
