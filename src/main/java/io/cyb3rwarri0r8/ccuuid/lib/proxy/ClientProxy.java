package io.cyb3rwarri0r8.ccuuid.lib.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import io.cyb3rwarri0r8.ccuuid.render.RenderUUIDGenerator;
import io.cyb3rwarri0r8.ccuuid.tile.UUIDGenerator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

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
public class ClientProxy extends CommonProxy{

    TileEntitySpecialRenderer render1 = new RenderUUIDGenerator();


    @Override
    public void registerRenderers() {
        ClientRegistry.registerTileEntity(UUIDGenerator.class,"UUIDGenerator",render1);
    }

}
