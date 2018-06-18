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
 * Class representing a color.
 *
 * @property red The red component between 0 and 255.
 * @property green The green component between 0 and 255.
 * @property blue The blue component between 0 and 255.
 * @property alpha The alpha component between 0 and 255.
 */
data class Color(
    val red: Short,
    val green: Short,
    val blue: Short,
    val alpha: Short
) {
    // TODO: Move to extensions project
    companion object {
        /**
         * Value representing an [alpha] completely transparent.
         */
        const val TRANSPARENT: Short = 0x00

        /**
         * Value representing an [alpha] completely opaque.
         */
        const val OPAQUE: Short = 0xFF

        /**
         * The color black.
         */
        val BLACK: Color = Color(
            red = 0x00,
            green = 0x00,
            blue = 0x00,
            alpha = OPAQUE
        )

        /**
         * The color red.
         */
        val RED: Color = BLACK.copy(red = 0xFF)

        /**
         * The color green.
         */
        val GREEN: Color = BLACK.copy(green = 0x00)

        /**
         * The color blue.
         */
        val BLUE: Color = BLACK.copy(blue = 0x00)

        /**
         * The color white.
         */
        val WHITE: Color = Color(
            red = 0xFF,
            green = 0xFF,
            blue = 0xFF,
            alpha = OPAQUE
        )

        /**
         * The color cyan.
         */
        val CYAN: Color = WHITE.copy(red = 0x00)

        /**
         * The color cyan.
         */
        val YELLOW: Color = WHITE.copy(blue = 0x00)

        /**
         * The color cyan.
         */
        val MAGENTA: Color = WHITE.copy(green = 0x00)
    }
}

/**
 * Interface containing pixel information.
 */
interface PixelFormat