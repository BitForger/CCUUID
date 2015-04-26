package io.cyb3rwarri0r8.ccuuid.blocks;

import io.cyb3rwarri0r8.ccuuid.lib.Reference;
import io.cyb3rwarri0r8.ccuuid.tile.UUIDGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

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
public class BlockCCUUIDGenerator extends BlockContainer {

    public IIcon blockIcon;


    public BlockCCUUIDGenerator() {
        super(Material.rock);
        setCreativeTab(CreativeTabs.tabMisc);
        setBlockName("uuidGenerator");
        setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        maxX = 0.2;
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param p_149915_1_
     * @param p_149915_2_
     */
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new UUIDGenerator();
    }

    public int getRenderType(){
        return -1;
    }

    public boolean isOpaqueCube(){
        return false;
    }

    public boolean renderAsNormalBlock(){
        return false;
    }

    public Item getItemDropped(int par1, Random rand, int par3)
    {
        return Item.getItemFromBlock(ModBlocks.ccuuidGenerator);
    }

    public Item getItem(World world, int par2, int par3, int par4)
    {
        return Item.getItemFromBlock(ModBlocks.ccuuidGenerator);
    }

    private void direction(World world, int x, int y, int z) {
        if ( !world.isRemote )
        {
            Block direction = world.getBlock(x, y, z - 1);
            Block direction1 = world.getBlock(x, y, z + 1);
            Block direction2 = world.getBlock(x - 1, y, z);
            Block direction3 = world.getBlock(x + 1, y, z);

            byte byte0 = 3;

            if (direction.func_149730_j() && direction.func_149730_j())
            {
                byte0 = 3;
            }
            if (direction1.func_149730_j() && direction1.func_149730_j())
            {
                byte0 = 2;
            }
            if (direction2.func_149730_j() && direction2.func_149730_j())
            {
                byte0 = 5;
            }
            if (direction3.func_149730_j() && direction3.func_149730_j())
            {
                byte0 = 4;
            }
            world.setBlockMetadataWithNotify(x, y, z, byte0, 2);
        }
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
    {
        int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D ) & 3;

        if( direction == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);

        }
        if( direction == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if( direction == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);

        }
        if( direction == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);

        }
        if (itemStack.hasDisplayName())
        {
            ((UUIDGenerator) world.getTileEntity(x, y, z)).func_145976_a(itemStack.getDisplayName());
        }

        super.onBlockPlacedBy(world, x, y, z, entity, itemStack);
        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, ForgeDirection.getOrientation(l).getOpposite().ordinal(),1);
    }

//    public void registerIcons(IIconRegister icon) {
//        this.blockIcon = icon.registerIcon(null);
//    }
    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */

    public void func_149954_e(World p_149954_1_, int p_149954_2_, int p_149954_3_, int p_149954_4_)
    {
        if (!p_149954_1_.isRemote)
        {
            Block block = p_149954_1_.getBlock(p_149954_2_, p_149954_3_, p_149954_4_ - 1);
            Block block1 = p_149954_1_.getBlock(p_149954_2_, p_149954_3_, p_149954_4_ + 1);
            Block block2 = p_149954_1_.getBlock(p_149954_2_ - 1, p_149954_3_, p_149954_4_);
            Block block3 = p_149954_1_.getBlock(p_149954_2_ + 1, p_149954_3_, p_149954_4_);
            boolean flag = true;
            int l;
            Block block4;
            int i1;
            Block block5;
            boolean flag1;
            byte b0;
            int j1;

            if (block != this && block1 != this)
            {
                if (block2 != this && block3 != this)
                {
                    b0 = 3;

                    if (block.func_149730_j() && !block1.func_149730_j())
                    {
                        b0 = 3;
                    }

                    if (block1.func_149730_j() && !block.func_149730_j())
                    {
                        b0 = 2;
                    }

                    if (block2.func_149730_j() && !block3.func_149730_j())
                    {
                        b0 = 5;
                    }

                    if (block3.func_149730_j() && !block2.func_149730_j())
                    {
                        b0 = 4;
                    }
                }
                else
                {
                    l = block2 == this ? p_149954_2_ - 1 : p_149954_2_ + 1;
                    block4 = p_149954_1_.getBlock(l, p_149954_3_, p_149954_4_ - 1);
                    i1 = block2 == this ? p_149954_2_ - 1 : p_149954_2_ + 1;
                    block5 = p_149954_1_.getBlock(i1, p_149954_3_, p_149954_4_ + 1);
                    b0 = 3;
                    flag1 = true;

                    if (block2 == this)
                    {
                        j1 = p_149954_1_.getBlockMetadata(p_149954_2_ - 1, p_149954_3_, p_149954_4_);
                    }
                    else
                    {
                        j1 = p_149954_1_.getBlockMetadata(p_149954_2_ + 1, p_149954_3_, p_149954_4_);
                    }

                    if (j1 == 2)
                    {
                        b0 = 2;
                    }

                    if ((block.func_149730_j() || block4.func_149730_j()) && !block1.func_149730_j() && !block5.func_149730_j())
                    {
                        b0 = 3;
                    }

                    if ((block1.func_149730_j() || block5.func_149730_j()) && !block.func_149730_j() && !block4.func_149730_j())
                    {
                        b0 = 2;
                    }
                }
            }
            else
            {
                l = block == this ? p_149954_4_ - 1 : p_149954_4_ + 1;
                block4 = p_149954_1_.getBlock(p_149954_2_ - 1, p_149954_3_, l);
                i1 = block == this ? p_149954_4_ - 1 : p_149954_4_ + 1;
                block5 = p_149954_1_.getBlock(p_149954_2_ + 1, p_149954_3_, i1);
                b0 = 5;
                flag1 = true;

                if (block == this)
                {
                    j1 = p_149954_1_.getBlockMetadata(p_149954_2_, p_149954_3_, p_149954_4_ - 1);
                }
                else
                {
                    j1 = p_149954_1_.getBlockMetadata(p_149954_2_, p_149954_3_, p_149954_4_ + 1);
                }

                if (j1 == 4)
                {
                    b0 = 4;
                }

                if ((block2.func_149730_j() || block4.func_149730_j()) && !block3.func_149730_j() && !block5.func_149730_j())
                {
                    b0 = 5;
                }

                if ((block3.func_149730_j() || block5.func_149730_j()) && !block2.func_149730_j() && !block4.func_149730_j())
                {
                    b0 = 4;
                }
            }

            p_149954_1_.setBlockMetadataWithNotify(p_149954_2_, p_149954_3_, p_149954_4_, b0, 3);
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        register.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5));
    }
}
