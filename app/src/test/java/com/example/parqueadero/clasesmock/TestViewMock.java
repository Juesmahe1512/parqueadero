package com.example.parqueadero.clasesmock;

import com.example.parqueadero.interfaces.TestView;


public class TestViewMock implements TestView {

    @Override
    public void show(String text) {
        System.out.println(text);
    }

}
