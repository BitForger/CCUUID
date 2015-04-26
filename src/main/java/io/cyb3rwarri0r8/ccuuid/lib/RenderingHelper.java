package io.cyb3rwarri0r8.ccuuid.lib;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import io.cyb3rwarri0r8.ccuuid.blocks.ModBlocks;
import io.cyb3rwarri0r8.ccuuid.ccuuid;
import io.cyb3rwarri0r8.ccuuid.tile.UUIDGenerator;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * CCUUID - A Minecraft Modification
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
public class RenderingHelper implements ISimpleBlockRenderingHandler{

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID,
                                     RenderBlocks renderer) {
        GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        if (block == ModBlocks.ccuuidGenerator) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(
                    new UUIDGenerator(), 0.0D, 0.0D, 0.0D, 0.0F
            );
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
                                    Block block, int modelId, RenderBlocks renderer) {
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return ccuuid.renderID;
    }
}
