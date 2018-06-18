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
 * Interface representing a renderer.
 */
interface Renderer {
    /**
     * The color used for drawing operations.
     *
     * See [https://wiki.libsdl.org/SDL_GetRenderDrawColor] and [https://wiki.libsdl.org/SDL_SetRenderDrawColor].
     *
     * @throws SDLException If getting or setting the value fails.
     */
    var drawColor: Color

    /**
     * Clears the current rendering target.
     *
     * See [https://wiki.libsdl.org/SDL_RenderClear].
     *
     * @throws SDLException On failure.
     */
    fun clear(): Unit

    /**
     * Fills a rectangle on the current rendering target with the drawing color.
     *
     * See [https://wiki.libsdl.org/SDL_RenderFillRect].
     *
     * @throws SDLException On failure.
     */
    fun fillRect(rect: Rectangle): Unit

    /**
     * Updates the screen with any rendering performed since the previous call.
     *
     * See [https://wiki.libsdl.org/SDL_RenderPresent].
     *
     * @throws SDLException On failure.
     */
    fun present(): Unit

    /**
     * Flags used when creating a rendering context.
     */
    enum class Flags {
        /**
         * The renderer is a software fallback.
         */
        SOFTWARE,

        /**
         * The renderer uses hardware acceleration.
         */
        ACCELERATED,

        /**
         * Present is synchronized with the refresh rate.
         */
        PRESENT_VSYNC,

        /**
         * The renderer supports rendering to texture.
         */
        TARGET_TEXTURE
    }
}
