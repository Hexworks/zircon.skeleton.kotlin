package com.example

import org.hexworks.zircon.api.*

fun main(args: Array<String>) {
    val tileGrid = SwingApplications.startTileGrid(
            AppConfigs.newConfig()
                    .withSize(Sizes.create(60, 30))
                    .withDefaultTileset(CP437TilesetResources.rexPaint16x16())
                    .build())

    val screen = Screens.createScreenFor(tileGrid)

    val label = Components.label()
            .withText("Hello, Zircon!")
            .withPosition(Positions.create(23, 10))
            .build()

    screen.addComponent(label)

    screen.display()
    screen.applyColorTheme(ColorThemes.arc())
}
