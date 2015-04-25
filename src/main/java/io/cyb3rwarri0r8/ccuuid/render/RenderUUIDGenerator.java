package io.cyb3rwarri0r8.ccuuid.render;

import io.cyb3rwarri0r8.ccuuid.blocks.BlockCCUUIDGenerator;
import io.cyb3rwarri0r8.ccuuid.client.ModelUUIDGenerator;
import io.cyb3rwarri0r8.ccuuid.lib.Reference;
import io.cyb3rwarri0r8.ccuuid.tile.UUIDGenerator;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

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
public class RenderUUIDGenerator extends TileEntitySpecialRenderer {

    ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/models/texture");

    private ModelUUIDGenerator modelUUIDGenerator;

    public RenderUUIDGenerator(){
        this.modelUUIDGenerator = new ModelUUIDGenerator();
        setTexture(texture);
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float par5) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);
        GL11.glPushMatrix();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
        this.bindTexture(texture);
        this.setTexture(texture);
        this.getTexture();

    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    public void setTexture(ResourceLocation texture) {
        this.texture = texture;
    }
}
