package io.cyb3rwarri0r8.ccuuid;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import io.cyb3rwarri0r8.ccuuid.blocks.BlockCCUUIDGenerator;
import io.cyb3rwarri0r8.ccuuid.blocks.ModBlocks;
import io.cyb3rwarri0r8.ccuuid.lib.Reference;
import io.cyb3rwarri0r8.ccuuid.tile.UUIDGenerator;
import net.minecraft.init.Blocks;

@Mod(modid = Reference.MODID, version = Reference.VERSION, dependencies = "required-after:ComputerCraft")
public class ccuuid
{

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModBlocks.init();

        GameRegistry.registerBlock(ModBlocks.ccuuidGenerator, "uuidGenerator");
        GameRegistry.registerTileEntity(UUIDGenerator.class, "uuidGenerator");
        LanguageRegistry.addName(ModBlocks.ccuuidGenerator,"UUID Generator");
    }
}
