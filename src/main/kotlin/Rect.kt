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
 * A structure that defines a constant two dimensional point.
 *
 * See [https://wiki.libsdl.org/SDL_Point] for further details.
 */
interface Point {
    /**
     * The x coordinate of the point.
     */
    val x: Int

    /**
     * The y coordinate of the point.
     */
    val y: Int

    /**
     * Checks if the point resides inside a rectangle.
     *
     * See [https://wiki.libsdl.org/SDL_PointInRect] for further details.
     *
     * @param rect The rectangle to check.
     *
     * @return True if the point resides inside rectangle or false if not.
     */
    fun inRectangle(rect: Rectangle): Boolean

    /**
     * Indicates if this point is equals to another.
     *
     * @param other The other object to compare.
     *
     * @return True of this point is equals to another, false otherwise.
     */
    override fun equals(other: Any?): Boolean
}

/**
 * A structure that defines a two dimensional point.
 *
 * See [https://wiki.libsdl.org/SDL_Point] for further details.
 */
interface MutablePoint : Point {
    /**
     * The x coordinate of the point.
     */
    override var x: Int

    /**
     * The y coordinate of the point.
     */
    override var y: Int
}

/**
 * A structure that contains the definition of a constant rectangle, with the origin at the upper left.
 *
 * See [https://wiki.libsdl.org/SDL_Rect] for further details.
 */
interface Rectangle {
    /**
     * The x location of the rectangle's upper left corner.
     */
    val x: Int

    /**
     * The y location of the rectangle's upper left corner.
     */
    val y: Int

    /**
     * The width of the rectangle.
     */
    val width: Int

    /**
     * The height of the rectangle.
     */
    val height: Int

    /**
     * Checks whether a rectangle has no area.
     *
     * See [https://wiki.libsdl.org/SDL_RectEmpty] for further details.
     */
    val empty: Boolean

    /**
     * Calculate the intersection of this rectangle with another one.
     *
     * See [https://wiki.libsdl.org/SDL_IntersectRect] for further details.
     *
     * @param other The other rectangle to check for intersection.
     *
     * @return Returns a rectangle with the intersection or null if there is none.
     */
    fun intersectsWith(other: Rectangle): Rectangle?

    /**
     * Calculates the intersection of a rectangle and line segment.
     *
     * See [https://wiki.libsdl.org/SDL_IntersectRectAndLine] for further details.
     *
     * @param start The starting point of the line.
     * @param end The end point of the line.
     *
     * @return True if there is an intersection, false otherwise.
     */
    fun intersectsWith(start: Point, end: Point): Boolean

    /**
     * Calculates the union of this rectangle with another one.
     *
     * See [https://wiki.libsdl.org/SDL_UnionRect] for further details.
     *
     * @param other The other rectangle.
     *
     * @return A rectangle containing this and the other.
     */
    fun union(other: Rectangle): Rectangle

    /**
     * Indicates if this rectangle is equals to another.
     *
     * See [https://wiki.libsdl.org/SDL_UnionRect] for further details.
     *
     * @param other The other object to compare.
     *
     * @return True of this point is equals to another, false otherwise.
     */
    override fun equals(other: Any?): Boolean
}

/**
 * A structure that contains the definition of a constant rectangle, with the origin at the upper left.
 *
 * See [https://wiki.libsdl.org/SDL_Rect] for further details.
 */
interface MutableRectangle : Rectangle {
    /**
     * The x location of the rectangle's upper left corner.
     */
    override var x: Int

    /**
     * The y location of the rectangle's upper left corner.
     */
    override var y: Int

    /**
     * The width of the rectangle.
     */
    override var width: Int

    /**
     * The height of the rectangle.
     */
    override var height: Int
}

/**
 * Interface with utility functions for the [Rectangle] interface.
 */
interface RectangleUtils {
    /**
     * Calculates the minimal rectangle enclosing a set of points.
     *
     * See [https://wiki.libsdl.org/SDL_EnclosePoints] for further details.
     *
     * @param points The points to be enclosed.
     *
     * @return The minimal rectangle enclosing the set of points.
     */
    fun enclosePoints(points: Array<Point>): Rectangle

    /**
     * Calculates the minimal rectangle enclosing a set of points inside a clipping rectangle.
     *
     * See [https://wiki.libsdl.org/SDL_EnclosePoints] for further details.
     *
     * @param points The points to be enclosed.
     * @param clip The clipping rectangle.
     *
     * @return The minimal rectangle enclosing the set of points or null if all of the points are outside the clipping
     * rectangle.
     */
    fun enclosePoints(points: Array<Point>, clip: Rectangle): Rectangle?
}
