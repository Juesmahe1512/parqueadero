package com.example.parqueadero.presenters

import com.example.parqueadero.clasesmock.TestViewMock
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.*


class TestPresenterTest{

    @Test
     fun testShowView() {
        //Arrange
        var testView=TestViewMock()
        var spy=spy(testView)
        var presenter=TestPresenter(spy)

        //Act
        presenter.showView();

        //Assert
        verify(spy).show(anyString())
     }

}