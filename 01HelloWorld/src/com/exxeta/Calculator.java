package com.exxeta;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("calculatorBean")
@Getter
@Setter
public class Calculator {
    private int a;
    private int b;
    private int erg;

    public void addAction(){
        erg = a + b;
    }

}
