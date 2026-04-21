package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    JavaSingleton singleton = JavaSingleton.getInstance();



    static void main() {

        JavaSingleton singleton = JavaSingleton.getInstance();

        DemoBlazeStore dbs = new DemoBlazeStore();
        dbs.E2ETest();

        //valores iniciales para logearse
        singleton.setUsername("toymaru_101");
        singleton.setPassword("pass1234");

        dbs.Login(singleton.getUsername(),singleton.getPassword()); //log in antes de empezar a comprar
        dbs.AddCart();  //añade en este caso dos articulos para comprar
        dbs.initCustomer(); //inicializa datos del cliente antes de llnar el formulario de compra
        dbs.CheckCart(); //se revisa la compra
        dbs.FillForm(); //se llena el formulario con los datos del cliente
    }

}
