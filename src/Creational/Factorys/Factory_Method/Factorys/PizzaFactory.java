package Creational.Factorys.Factory_Method.Factorys;

import Creational.Factorys.Factory_Method.Products.Pizza;

public abstract class PizzaFactory {

  public Pizza orderPizza() {
    Pizza pizza;

    pizza = makePizza();

    //do work with product
    pizza.prepare();
    pizza.bake();
    pizza.cut();

    return pizza;
  }

  //create kind of pizza
  protected abstract Pizza makePizza();

}
