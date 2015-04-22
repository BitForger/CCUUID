package io.cyb3rwarri0r8.ccuuid.tile;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.UUID;

/**
 * CommuMod - A Minecraft Modification
 * Copyright (C) 2015 Cyb3rWarri0r8
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class UUIDGenerator extends TileEntity implements IPeripheral {

    public UUIDGenerator(World world)
    {
        super();
    }

    /**
     * Should return a string that uniquely identifies this type of peripheral.
     * This can be queried from lua by calling peripheral.getType()
     *
     * @return A string identifying the type of peripheral.
     */
    @Override
    public String getType() {
        return "UUIDGenerator";
    }

    /**
     * Should return an array of strings that identify the methods that this
     * peripheral exposes to Lua. This will be called once before each attachment,
     * and should not change when called multiple times.
     *
     * @return An array of strings representing method names.
     * @see #callMethod
     */
    @Override
    public String[] getMethodNames() {
        String[] string = new String[1];
        string[1] = "generateUUID";
        return string;
    }

    /**
     * This is called when a lua program on an attached computercraft calls peripheral.call() with
     * one of the methods exposed by getMethodNames().<br>
     * <br>
     * Be aware that this will be called from the ComputerCraft Lua thread, and must be thread-safe
     * when interacting with minecraft objects.
     *
     * @param computer The interface to the computercraft that is making the call. Remember that multiple
     *                 computers can be attached to a peripheral at once.
     * @return An array of objects, representing values you wish to return to the lua program.<br>
     * Integers, Doubles, Floats, Strings, Booleans and null be converted to their corresponding lua type.<br>
     * All other types will be converted to nil.<br>
     * You may return null to indicate no values should be returned.
     * @param    context        The context of the currently running lua thread. This can be used to wait for events
     * or otherwise yield.
     * @param    method        An integer identifying which of the methods from getMethodNames() the computercraft
     * wishes to call. The integer indicates the index into the getMethodNames() table
     * that corresponds to the string passed into peripheral.call()
     * @param    arguments    An array of objects, representing the arguments passed into peripheral.call().<br>
     * Lua values of type "string" will be represented by Object type String.<br>
     * Lua values of type "number" will be represented by Object type Double.<br>
     * Lua values of type "boolean" will be represented by Object type Boolean.<br>
     * Lua values of any other type will be represented by a null object.<br>
     * This array will be empty if no arguments are passed.
     * @throws Exception    If you throw any exception from this function, a lua error will be raised with the
     * same message as your exception. Use this to throw appropriate errors if the wrong
     * arguments are supplied to your method.
     * @see #getMethodNames
     */
    @Override
    public Object[] callMethod(IComputerAccess computer, ILuaContext context, int method, Object[] arguments) throws LuaException, InterruptedException {

        switch (method) {
            case 0:
                UUID uuid = UUID.randomUUID();
                return new Object[]{uuid};
            default:
                return null;

        }
    }

    /**
     * Is called when canAttachToSide has returned true, and a computercraft is attaching to the peripheral.
     * This will occur when a peripheral is placed next to an active computercraft, when a computercraft is turned on next to a peripheral,
     * or when a turtle travels into a square next to a peripheral.
     * Between calls to attach() and detach(), the attached computercraft can make method calls on the peripheral using peripheral.call().
     * This method can be used to keep track of which computers are attached to the peripheral, or to take action when attachment
     * occurs.<br>
     * <br>
     * Be aware that this will be called from the ComputerCraft Lua thread, and must be thread-safe
     * when interacting with minecraft objects.
     *
     * @param computer The interface to the computercraft that is being attached. Remember that multiple
     *                 computers can be attached to a peripheral at once.
     * @see        #detach
     */
    @Override
    public void attach(IComputerAccess computer) {

    }

    /**
     * Is called when a computercraft is detaching from the peripheral.
     * This will occur when a computercraft shuts down, when the peripheral is removed while attached to computers,
     * or when a turtle moves away from a square attached to a peripheral.
     * This method can be used to keep track of which computers are attached to the peripheral, or to take action when detachment
     * occurs.<br>
     * <br>
     * Be aware that this will be called from the ComputerCraft Lua thread, and must be thread-safe
     * when interacting with minecraft objects.
     *
     * @param computer The interface to the computercraft that is being detached. Remember that multiple
     *                 computers can be attached to a peripheral at once.
     * @see        #detach
     */
    @Override
    public void detach(IComputerAccess computer) {

    }

    /**
     * TODO: Document me
     *
     * @param other
     */
    @Override
    public boolean equals(IPeripheral other) {
        return false;
    }
}
