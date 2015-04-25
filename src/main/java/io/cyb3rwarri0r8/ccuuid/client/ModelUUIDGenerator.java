package io.cyb3rwarri0r8.ccuuid.client;

import java.util.HashMap;

import io.cyb3rwarri0r8.ccuuid.client.MCAClientLibrary.MCAModelRenderer;
import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.IMCAnimatedEntity;
import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.MCAVersionChecker;
import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.animation.AnimationHandler;
import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.math.Matrix4f;
import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.math.Quaternion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;


public class ModelUUIDGenerator extends ModelBase {
public final int MCA_MIN_REQUESTED_VERSION = 5;
public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();

MCAModelRenderer backSide;
MCAModelRenderer frontSide;
MCAModelRenderer leftSide;
MCAModelRenderer rightSide;
MCAModelRenderer topSide;
MCAModelRenderer bottomSide;

public ModelUUIDGenerator()
{
MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

textureWidth = 16;
textureHeight = 16;

backSide = new MCAModelRenderer(this, "backSide", 0, 0);
backSide.mirror = false;
backSide.addBox(0.0F, 0.0F, 0.0F, 4, 16, 0);
backSide.setInitialRotationPoint(1.0F, 1.0F, 1.0F);
backSide.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
backSide.setTextureSize(16, 16);
parts.put(backSide.boxName, backSide);

frontSide = new MCAModelRenderer(this, "frontSide", 0, 0);
frontSide.mirror = false;
frontSide.addBox(0.0F, 0.0F, 0.0F, 4, 16, 1);
frontSide.setInitialRotationPoint(1.0F, 1.0F, 16.0F);
frontSide.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
frontSide.setTextureSize(16, 16);
parts.put(frontSide.boxName, frontSide);

leftSide = new MCAModelRenderer(this, "leftSide", 0, 0);
leftSide.mirror = false;
leftSide.addBox(0.0F, 0.0F, 0.0F, 1, 16, 16);
leftSide.setInitialRotationPoint(1.0F, 1.0F, 1.0F);
leftSide.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
leftSide.setTextureSize(16, 16);
parts.put(leftSide.boxName, leftSide);

rightSide = new MCAModelRenderer(this, "rightSide", 0, 0);
rightSide.mirror = false;
rightSide.addBox(0.0F, 0.0F, 0.0F, 1, 16, 16);
rightSide.setInitialRotationPoint(4.0F, 1.0F, 4.0F);
rightSide.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
rightSide.setTextureSize(16, 16);
parts.put(rightSide.boxName, rightSide);

topSide = new MCAModelRenderer(this, "topSide", 0, 0);
topSide.mirror = false;
topSide.addBox(0.0F, 0.0F, 0.0F, 4, 0, 16);
topSide.setInitialRotationPoint(1.0F, 17.0F, 0.0F);
topSide.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
topSide.setTextureSize(16, 16);
parts.put(topSide.boxName, topSide);

bottomSide = new MCAModelRenderer(this, "bottomSide", 0, 0);
bottomSide.mirror = false;
bottomSide.addBox(0.0F, 0.0F, 0.0F, 4, 0, 16);
bottomSide.setInitialRotationPoint(1.0F, 0.0F, 0.0F);
bottomSide.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bottomSide.setTextureSize(16, 16);
parts.put(bottomSide.boxName, bottomSide);

}

@Override
public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) 
{
Entity entity =  par1Entity;

AnimationHandler.performAnimationInModel(parts, (IMCAnimatedEntity) entity);

//Render every non-child part
backSide.render(par7);
frontSide.render(par7);
leftSide.render(par7);
rightSide.render(par7);
topSide.render(par7);
bottomSide.render(par7);
}
@Override
public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {}

public MCAModelRenderer getModelRendererFromName(String name)
{
return parts.get(name);
}
}