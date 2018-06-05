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
 * The list of available subsystems in SDL.
 */
enum class SubSystem {
    /**
     * Timer subsystem.
     */
    TIMER,

    /**
     * Audio subsystem.
     */
    AUDIO,

    /**
     * Video subsystem, automatically initializes the events subsystem.
     */
    VIDEO,

    /**
     * Joystick subsystem, automatically initializes the events subsystem.
     */
    JOYSTICK,

    /**
     * Haptic (force feedback) subsystem.
     */
    HAPTIC,

    /**
     * Controller subsystem, automatically initializes the joystick subsystem.
     */
    GAMECONTROLLER,

    /**
     * Events subsystem.
     */
    EVENTS,

    /**
     * All the other subsystems.
     */
    EVERYTHING
}

/**
 * Interface with functions to manage the SDL subsystems.
 */
interface SubSystemsFunctions {
    /**
     * Use this function to initialize the SDL library. This must be called before using most other SDL functions.
     *
     * See [https://wiki.libsdl.org/SDL_Init] for further details.
     *
     * @param subSystems The list of subsystems to initialize, if empty all subsystems are initialized.
     *
     * @throws SDLException If there was a failure initializing the subsystems.
     */
    fun init(vararg subSystems: SubSystem): Unit

    /**
     * Use this function to initialize specific SDL subsystems.
     *
     * See [https://wiki.libsdl.org/SDL_InitSubSystem] for further details.
     *
     * @param subSystems The list of subsystems to initialize.
     *
     * @throws SDLException If there was a failure initializing the subsystems.
     */
    fun initSubSystem(vararg subSystems: SubSystem): Unit

    /**
     * Use this function to get a map of the specified subsystems which have previously been initialized.
     *
     * See [https://wiki.libsdl.org/SDL_WasInit] for further details.
     *
     * @param subSystems The list of subsystem to check, if empty the a check for all subsystems is done.
     */
    fun wasInit(vararg subSystems: SubSystem): Map<SubSystem, Boolean>

    /**
     * Use this function to clean up all initialized subsystems. You should call it upon all exit conditions.
     *
     * See [https://wiki.libsdl.org/SDL_Quit] for further details.
     */
    fun quit(): Unit

    /**
     * Use this function to shut down specific SDL subsystems.
     *
     * See [https://wiki.libsdl.org/SDL_QuitSubSystem] for further details.
     *
     * @param subSystems The list of subsystems to shut down, if empty then all subsystems are shutdown.
     */
    fun quitSubSystems(vararg subSystems: SubSystem): Unit
}
