package com.example.parqueadero.presenters

import com.example.parqueadero.clasesmock.TestViewMock
import com.example.parqueadero.interfaces.TestView
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*


class TestPresenterTest{

    @Test
     fun testShowView() {
        var testView=TestViewMock()
        var spy=spy(testView)
        var presenter=TestPresenter(spy)
        presenter.showView();
        verify(spy).show(anyString());
    }

}