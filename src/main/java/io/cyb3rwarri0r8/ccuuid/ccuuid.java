package io.cyb3rwarri0r8.ccuuid;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import io.cyb3rwarri0r8.ccuuid.blocks.ModBlocks;
import io.cyb3rwarri0r8.ccuuid.lib.Reference;
import io.cyb3rwarri0r8.ccuuid.lib.proxy.CommonProxy;
import io.cyb3rwarri0r8.ccuuid.tile.UUIDGenerator;

@Mod(modid = Reference.MODID, version = Reference.VERSION, dependencies = "required-after:ComputerCraft")
public class ccuuid
{
    @SidedProxy(clientSide=Reference.CLIENT_PROXY, serverSide=Reference.COMMON_PROXY)
    public static CommonProxy proxy;

    @Mod.Instance
    public ccuuid instance;



    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModBlocks.init();


        LanguageRegistry.addName(ModBlocks.ccuuidGenerator, "UUID Generator");

        proxy.registerRenderers();
        proxy.registerTileEntities();
    }


}
