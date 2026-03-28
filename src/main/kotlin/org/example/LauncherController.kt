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

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.stage.Stage

class LauncherController {

    @FXML
    private lateinit var topBar: HBox

    @FXML
    private lateinit var closeBtn: Button

    @FXML
    private lateinit var minimizeBtn: Button

    private var xOffset = 0.0
    private var yOffset = 0.0

    @FXML
    fun initialize() {
        topBar.sceneProperty().addListener { _, _, scene ->
            scene?.windowProperty()?.addListener { _, _, window ->
                val stage = window as Stage

                closeBtn.setOnAction { stage.close() }
                minimizeBtn.setOnAction { stage.isIconified = true }

                // Перетаскивание окна
                topBar.setOnMousePressed {
                    xOffset = it.sceneX
                    yOffset = it.sceneY
                }

                topBar.setOnMouseDragged {
                    stage.x = it.screenX - xOffset
                    stage.y = it.screenY - yOffset
                }

                // Hover и Pressed эффекты для closeBtn
                closeBtn.setOnMouseEntered { closeBtn.style = "-fx-background-color: #a42211; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;" }
                closeBtn.setOnMouseExited { closeBtn.style = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;" }
                closeBtn.setOnMousePressed { closeBtn.style = "-fx-background-color: #771711; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;" }
                closeBtn.setOnMouseReleased { closeBtn.style = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;" }

                // Hover и Pressed эффекты для minimizeBtn
                minimizeBtn.setOnMouseEntered { minimizeBtn.style = "-fx-background-color: #333333; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;" }
                minimizeBtn.setOnMouseExited { minimizeBtn.style = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;" }
                minimizeBtn.setOnMousePressed { minimizeBtn.style = "-fx-background-color: #222222; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;" }
                minimizeBtn.setOnMouseReleased { minimizeBtn.style = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;" }
            }
        }
    }
}
