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
 * Exception representing a failure in the SDL library.
 */
class SDLException : RuntimeException {
    /**
     * Constructs an instance of the exception.
     */
    constructor() : super()

    /**
     * Constructs an instance of the exception with an optional message.
     *
     * @param message The message of the exception.
     */
    constructor(message: String?) : super(message)

    /**
     * Constructs an instance of the exception with an optional message and optional cause.
     *
     * @param message The message of the exception.
     * @param cause The cause of the exception.
     */
    constructor(message: String?, cause: Throwable?) : super(message, cause)

    /**
     * Constructs an instance of the exception with an optional cause.
     *
     * @param cause The cause of the exception.
     */
    constructor(cause: Throwable?) : super(cause)
}
