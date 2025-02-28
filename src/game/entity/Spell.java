package game.entity;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.List;

import nightingale.graph.animation.NAnimation;
import nightingale.graph.animation.NAnimator;
import nightingale.util.NCamera;

public abstract class Spell extends Entity{
	protected Monster target;
	private NAnimation animation;
	private NAnimator animator = null;
	
	// For moving
	private float angle = 0;
	private float speed = 6.5f;
	
	public Monster getTarget() { return target; }
	
	public boolean check() {
		if(target == null || this.getDistanceTo(target) < 4) 
			return true;
		return false;
	}
	
	public abstract void magic(List<Monster> list);
	
	@Override
	public void update() {
		if(animator != null) animator.update();
		//MOVE TO TARGET
		angle = (float)Math.toDegrees(Math.atan2(getCenterY()-target.getCenterY(), getCenterX()-target.getCenterX()));
		
		float _cx = (float)(getCenterX() - (speed*Math.cos(Math.PI*(angle)/180)));
		float _cy = (float)(getCenterY() - (speed*Math.sin(Math.PI*(angle)/180)));
		setCoordsByCenter(_cx, _cy);
		speed += 0.01f;
	}
	
	public Spell(Monster target, SpellType type, int x, int y) {
		animation = type.getAnimation();
		setNObjectAtributes(x, y, type.getWidth(), type.getHeight());
		this.target = target;
		if(animation!=null) animator = new NAnimator(animation, type.getAnimationSpeed());
		if(animator != null) animator.start();
	}
	
	@Override
	public void draw(Graphics2D g2d, NCamera cam) {
		g2d.drawRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
	}
	@Override
	public void draw(Graphics2D g2d, NCamera cam, AffineTransform at) {
		at = AffineTransform.getTranslateInstance(getCenterX(cam), getCenterY(cam));
		at.scale(cam.delta, cam.delta);
		at.rotate(Math.toRadians(angle-90));
		animator.draw(g2d, cam, at);
	}

}
