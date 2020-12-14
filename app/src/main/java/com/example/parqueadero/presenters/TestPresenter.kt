package com.example.parqueadero.presenters

import com.example.parqueadero.interfaces.TestView

public class TestPresenter(var view: TestView) {

    fun showView() {
        view.show("ole")
    }


}