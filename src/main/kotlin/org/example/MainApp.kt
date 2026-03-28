package org.example

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.stage.Stage
import javafx.stage.StageStyle

class MainApp : Application() {
    override fun start(stage: Stage) {
        val loader = FXMLLoader(javaClass.getResource("/org/example/launcher.fxml"))
        val root: VBox = loader.load()

        // Скругление углов через clip
        val clip = Rectangle(1700.0, 1100.0)
        clip.arcWidth = 20.0
        clip.arcHeight = 20.0
        root.clip = clip

        val scene = Scene(root, 1700.0, 1100.0)
        scene.fill = Color.TRANSPARENT  // чтобы прозрачность работала
        stage.initStyle(StageStyle.TRANSPARENT)
        stage.scene = scene

        // Окно фиксированного размера
        stage.isResizable = false
        stage.show()
    }
}

fun main() {
    Application.launch(MainApp::class.java)
}