package com.example

import org.hexworks.zircon.api.AppConfigs
import org.hexworks.zircon.api.CP437TilesetResources
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.Layers
import org.hexworks.zircon.api.Positions
import org.hexworks.zircon.api.Screens
import org.hexworks.zircon.api.Sizes
import org.hexworks.zircon.api.SwingApplications
import org.hexworks.zircon.api.Tiles
import org.hexworks.zircon.api.resource.GraphicalTilesetResource

fun main(args: Array<String>) {
    val tileGrid = SwingApplications.startTileGrid(
            AppConfigs.newConfig()
                    .withSize(Sizes.create(60, 30))
                    .withDefaultTileset(CP437TilesetResources.rexPaint16x16())
                    .build())

    val screen = Screens.createScreenFor(tileGrid)

    val label = Components.label()
            .withText("Hello, Zircon!")
            .withPosition(23, 10)
            .build()

    screen.addComponent(label)

    screen.addComponent(Components.label()
            .withText("Here are some graphical tiles:")
            .withPosition(15, 12)
            .build())

    val graphicalTileset = GraphicalTilesetResource(32, 32, "src/main/resources/tetris_32x32.zip")
    val layer = Layers.newBuilder()
            .withTileset(graphicalTileset)
            .withOffset(Positions.create(13, 7))
            .withSize(Sizes.create(3, 1))
            .build().apply {
                setTileAt(Positions.create(0, 0), Tiles.newBuilder()
                        .withTileset(graphicalTileset)
                        .withName("BlueSquare")
                        .buildGraphicTile())
                setTileAt(Positions.create(1, 0), Tiles.newBuilder()
                        .withTileset(graphicalTileset)
                        .withName("Yellow")
                        .buildGraphicTile())
                setTileAt(Positions.create(2, 0), Tiles.newBuilder()
                        .withTileset(graphicalTileset)
                        .withName("Lime")
                        .buildGraphicTile())
            }

    screen.display()
    screen.applyColorTheme(ColorThemes.arc())
    screen.pushLayer(layer)
}
