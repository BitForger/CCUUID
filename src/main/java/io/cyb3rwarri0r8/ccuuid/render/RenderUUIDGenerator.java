package io.cyb3rwarri0r8.ccuuid.render;

import io.cyb3rwarri0r8.ccuuid.client.ModelUUIDGenerator;
import io.cyb3rwarri0r8.ccuuid.tile.UUIDGenerator;
import net.minecraft.client.Minecraft;
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



    private final ModelUUIDGenerator model;



    public RenderUUIDGenerator(ModelUUIDGenerator model){
        this.model = new ModelUUIDGenerator();


    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float par5) {
        /*GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);
        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
*/
        UUIDGenerator generator = (UUIDGenerator) tileEntity;
        //The PushMatrix tells the renderer to "start" doing something.
        GL11.glPushMatrix();
            //This is setting the initial location.
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

            ResourceLocation textures = (new ResourceLocation("ccuuid:textures/blocks/texture.png"));

            Minecraft.getMinecraft().renderEngine.bindTexture(textures);

            //This rotation part is very important! Without it, your model will render upside-down! And for some reason you DO need PushMatrix again!
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            int placing = (generator.getFacing()+1) * 90;
            GL11.glPopMatrix();
            GL11.glRotatef(placing, 0, 1, 0);
        GL11.glPopMatrix();

    }


}
