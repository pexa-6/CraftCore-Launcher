/*
 * CraftCore Launcher
 * Copyright (C) 2026 Pexa-6, Flack1050.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * See the LICENSE file for more details.
*/

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
