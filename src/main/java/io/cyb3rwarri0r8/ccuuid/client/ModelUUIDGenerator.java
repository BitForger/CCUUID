package io.cyb3rwarri0r8.ccuuid.client;

import io.cyb3rwarri0r8.ccuuid.client.MCAClientLibrary.MCAModelRenderer;
import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.MCAVersionChecker;
import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.math.Matrix4f;
import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.math.Quaternion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

import java.util.HashMap;


public class ModelUUIDGenerator extends ModelBase {
    public final int MCA_MIN_REQUESTED_VERSION = 5;
    public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();


    MCAModelRenderer uuid;

    public ModelUUIDGenerator()
    {
        MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

        textureWidth = 16;
        textureHeight = 16;

        uuid = new MCAModelRenderer(this, "uuid", 0, 0);
        uuid.mirror = false;
        uuid.addBox(-8.0F, 12.0F, -4.0F, 16, 16, 4);

        uuid.setInitialRotationPoint(0.0F, -4.0F, -4.0F);
        uuid.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
        uuid.setTextureSize(16, 16);
        parts.put(uuid.boxName, uuid);

    }

    @Override
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {


//Render every non-child part
        uuid.render(par7);
    }
    @Override
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {}

    public MCAModelRenderer getModelRendererFromName(String name)
    {
        return parts.get(name);
    }
}
