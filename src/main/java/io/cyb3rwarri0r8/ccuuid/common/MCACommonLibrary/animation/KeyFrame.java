package io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.animation;

import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.math.Quaternion;
import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.math.Vector3f;

import java.util.ArrayList;
import java.util.HashMap;



public class KeyFrame {
	public HashMap<String, Quaternion> modelRenderersRotations = new HashMap<String, Quaternion>();
	public HashMap<String, Vector3f> modelRenderersTranslations = new HashMap<String, Vector3f>();
	
	public boolean useBoxInRotations(String boxName)
	{
		return modelRenderersRotations.get(boxName) != null;
	}
	
	public boolean useBoxInTranslations(String boxName)
	{
		return modelRenderersTranslations.get(boxName) != null;
	}
}