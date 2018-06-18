/*
Copyright (c) 2018 Vraiment

This software is provided 'as-is', without any express or implied
warranty. In no event will the authors be held liable for any damages
arising from the use of this software.

Permission is granted to anyone to use this software for any purpose,
including commercial applications, and to alter it and redistribute it
freely, subject to the following restrictions:

1. The origin of this software must not be misrepresented; you must not
   claim that you wrote the original software. If you use this software
   in a product, an acknowledgment in the product documentation would be
   appreciated but is not required.
2. Altered source versions must be plainly marked as such, and must not be
   misrepresented as being the original software.
3. This notice may not be removed or altered from any source distribution.
 */
package org.ksdl2

/**
 * Interface to represent a window.
 */
interface Window {
    /**
     * Get the size of a window's borders (decorations) around the client area.
     *
     * See [https://wiki.libsdl.org/SDL_GetWindowBordersSize] for further details.
     *
     * @throws SDLException If the getting the value fails.
     */
    val bordersSize: BordersSize

    /**
     * Gets and set the brightness (gamma multiplier) for the display that owns a given window.
     *
     * The value 0.0 is completely dark and 1.0 is normal brightness.
     *
     * See [https://wiki.libsdl.org/SDL_GetWindowBrightness] and [https://wiki.libsdl.org/SDL_SetWindowBrightness] for further details.
     *
     * @throws SDLException If the setting the value fails.
     */
    var brightness: Float

    /**
     * Gets the index of the display associated with a window.
     *
     * See [https://wiki.libsdl.org/SDL_GetWindowDisplayIndex] for further details.
     */
    val displayIndex: Int

    /**
     * Gets and set the title of a window.
     *
     * See [https://wiki.libsdl.org/SDL_GetWindowTitle] and [https://wiki.libsdl.org/SDL_SetWindowTitle] for further details.
     */
    var title: String

    /**
     * True if the window has been destroyed, false otherwise.
     *
     * See [https://wiki.libsdl.org/SDL_DestroyWindow] for further details.
     */
    val destroyed: Boolean

    /**
     * Destroys this window.
     *
     * See [https://wiki.libsdl.org/SDL_DestroyWindow] for further details.
     */
    fun destroy(): Unit

    /**
     * Copies the window surface to the screen.
     *
     * See [https://wiki.libsdl.org/SDL_UpdateWindowSurface] for further details.
     */
    fun updateSurface(): Unit

    /**
     * Copies areas of the window surface to the screen.
     *
     * See [https://wiki.libsdl.org/SDL_UpdateWindowSurfaceRects] for further details.
     *
     * @param rectangles An array of rectangles with areas of the surface to copy.
     */
    fun updateWindowSurfaceRects(rectangles: Array<Rectangle>): Unit

    /**
     * Creates a 2D rendering context for a window using the first driver supporting the requested flags.
     *
     * See [https://wiki.libsdl.org/SDL_CreateRenderer] for further details.
     *
     * @param flags A list of flags for the renderer.
     */
    fun createRenderer(vararg flags: Renderer.Flags): Renderer

    /**
     * Creates a 2D rendering context for a window.
     *
     * See [https://wiki.libsdl.org/SDL_CreateRenderer] for further details.
     *
     * @param index The index of the rendering driver to initialize, or -1 to initialize the first one supporting the requested flags.
     * @param flags A list of flags for the renderer.
     */
    fun createRenderer(index: Int, vararg flags: Renderer.Flags): Renderer

    /**
     * A enumeration of windows
     */
    enum class Flags {
        FULLSCREEN,
        FULLSCREEN_DESKTOP,
        OPENGL,
        HIDDEN,
        BORDERLESS,
        RESIZABLE,
        MINIMIZED,
        MAXIMIZED,
        INPUT_GRABBED,
        ALLOW_HIGH_DPI
    }

    /**
     * Class representing the borders of a window.
     *
     * @property top The size of the top border.
     * @property left The size of the left border.
     * @property bottom The size of the bottom border.
     * @property right The size of the right border.
     */
    data class BordersSize(val top: Int, val left: Int, val bottom: Int, val right: Int)
}

/**
 * Interface with functions to create windows.
 */
interface WindowFactory {
    /**
     * Creates a window with the given parameters.
     *
     * See [https://wiki.libsdl.org/SDL_CreateWindow] for further details.
     *
     * @param title The title of the window.
     * @param rectangle The rectangle representing the window.
     * @param flags The list of flags for the window.
     *
     * @return A window instance.
     */
    fun createWindow(title: String, rectangle: Rectangle, vararg flags: Window.Flags): Window

    /**
     * Creates a window with the given parameters in any position in the screen.
     *
     * See [https://wiki.libsdl.org/SDL_CreateWindow] with *SDL_WINDOWPOS_UNDEFINED*.
     *
     * @param title The title of the window.
     * @param width The width of the window.
     * @param height The height of the window.
     * @param flags The list of flags for the window.
     *
     * @return A window instance.
     */
    fun createWindow(title: String, width: Int, height: Int, vararg flags: Window.Flags): Window

    /**
     * Creates a window with the given parameters.
     *
     * See [https://wiki.libsdl.org/SDL_CreateWindow] for further details.
     *
     * @param title The title of the window.
     * @param x The x position of the window.
     * @param y The y position of the window.
     * @param width The width of the window.
     * @param height The height of the window.
     * @param flags The list of flags for the window.
     *
     * @return A window instance.
     */
    fun createWindow(title: String, x: Int, y: Int, width: Int, height: Int, vararg flags: Window.Flags): Window

    /**
     * Creates a centered window with the given parameters.
     *
     * See [https://wiki.libsdl.org/SDL_CreateWindow] for further details.
     *
     * @param title The title of the window.
     * @param width The width of the window.
     * @param height The height of the window.
     * @param flags The list of flags for the window.
     *
     * @return A window instance.
     */
    fun createCenteredWindow(title: String, width: Int, height: Int, vararg flags: Window.Flags): Window
}
