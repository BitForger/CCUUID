package io.cyb3rwarri0r8.ccuuid.common.animations.UUIDGenerator;

import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.IMCAnimatedEntity;
import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.animation.AnimationHandler;
import io.cyb3rwarri0r8.ccuuid.common.MCACommonLibrary.animation.Channel;

import java.util.HashMap;



public class AnimationHandlerUUIDGenerator extends AnimationHandler {
	/**
	 * Map with all the animations.
	 */
	public static HashMap<String, Channel> animChannels = new HashMap<String, Channel>();

	static {
	}

	public AnimationHandlerUUIDGenerator(IMCAnimatedEntity entity) {
		super(entity);
	}

	@Override
	public void activateAnimation(String name, float startingFrame) {
		super.activateAnimation(animChannels, name, startingFrame);
	}

	@Override
	public void stopAnimation(String name) {
		super.stopAnimation(animChannels, name);
	}

	@Override
	public void fireAnimationEventClientSide(Channel anim, float prevFrame, float frame) {

	}

	@Override
	public void fireAnimationEventServerSide(Channel anim, float prevFrame, float frame) {

	}

}