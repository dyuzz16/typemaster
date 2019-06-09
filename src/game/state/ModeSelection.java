package game.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import game.Input;
import game.TypeMaster;
import game.resources.Sprites;
import game.state.listener.ModeSelectionListener;
import nightingale.state.NState;
import nightingale.ui.NActionListener;
import nightingale.ui.NButton;
import nightingale.ui.NLabel;
import nightingale.ui.NUIElement;
import nightingale.ui.NUIGroup;

public class ModeSelection implements NState{

	protected NActionListener listener = new ModeSelectionListener();
	
	public NUIGroup ui = new NUIGroup();
	
	public ModeSelection() {
		ui.addElement("TITLE", new NLabel("PLAY", 0, 40, 160, 40));
		ui.addElement("SURVIVE", new NButton("Survive", 0, 140, 80, 50));
		ui.addElement("TRAINING", new NButton("Training", 0, 200, 80, 50));
		ui.addElement("BACK", new NButton("Back", 0, 300, 70, 40));
		
		ui.setActionListener(listener);
		ui.setCamera(TypeMaster.uiCamera);
	}
	
	@Override
	public void install() {
		TypeMaster.in.typingOff();
		for(NUIElement element : ui.getElements()) {
			element.setX(TypeMaster.canvas.getWidth()/2-element.getWidth()/2);
		}
		Sprites.testAnimator.start();
	}

	@Override
	public void update() {
		ui.perform(TypeMaster.in);
		Sprites.testAnimator.update();
		if(Input.ESC_KEY.isClicked()) {
			Sprites.testAnimator.changeAnimation(1);
		}
	}

	@Override
	public void draw(Graphics g, Graphics2D g2d, AffineTransform at) {
		ui.draw(g, g2d, at);
		g.setColor(Color.WHITE);
		g.fillRect(40, 40, 16, 16);
		Sprites.testAnimator.draw(40, 40, g2d, TypeMaster.gameCamera);
	}
	
}