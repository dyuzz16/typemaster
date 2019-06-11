package game.resources;

import java.awt.image.BufferedImage;

import nightingale.graph.NImageFactory;

public class Images {

	public static BufferedImage background = NImageFactory.loadFromFile("/res/img/background.png");
	public static BufferedImage surviveBackground = NImageFactory.loadFromFile("/res/img/survive_background.png");
	
	public static BufferedImage wizardSurvive = NImageFactory.loadFromFile("/res/img/wizard_survive.png");
	public static BufferedImage wizardTraining = NImageFactory.loadFromFile("/res/img/wizard_training.png");
	
	public static BufferedImage castle = NImageFactory.loadFromFile("/res/img/castle.png");
	
	//UI
	public static BufferedImage calmButton = NImageFactory.loadFromFile("/res/img/ui/calm_button.png");
	public static BufferedImage focusedButton = NImageFactory.loadFromFile("/res/img/ui/focused_button.png");
	public static BufferedImage pressedButton = NImageFactory.loadFromFile("/res/img/ui/pressed_button.png");
	
}