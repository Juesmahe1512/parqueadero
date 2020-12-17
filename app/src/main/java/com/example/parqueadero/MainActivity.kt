package com.example.parqueadero

import android.appwidget.AppWidgetProviderInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.parqueadero.di.component.DaggerTestComponent
import com.example.parqueadero.di.modules.TestModule
import com.example.parqueadero.interfaces.TestView
import com.example.parqueadero.presenters.TestPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), TestView {

    @Inject
    lateinit var presenter: TestPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerTestComponent
            .builder()
            .testModule(TestModule(this))
            .build()
            .inject(this)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.buttonTest)
        btn.setOnClickListener{
            presenter.showView()
        }
    }

    override fun show(text: String) {
        println(text)
    }


}