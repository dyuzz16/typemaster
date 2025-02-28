package game.state.listener;

import game.TypeMaster;
import game.state.ModeSelection;
import nightingale.ui.NActionListener;
import nightingale.ui.NLabel;
import nightingale.ui.NUIElement;

public class ModeSelectionListener implements NActionListener {
	
	private ModeSelection ms;
	public ModeSelectionListener(ModeSelection ms) {
		this.ms = ms;
	}
	
	@Override
	public void actionPerform(NUIElement element) {
		if(element.getName() == "BACK") {
			TypeMaster.stateHandler.setState("MENU_STATE");
		}else if(element.getName() == "TRAINING") {
			TypeMaster.stateHandler.setState("TRAINING_STATE");
		}else if(element.getName() == "SURVIVE") {
			ms.survive = true;
		}else if(element.getName() == "Back_to_selection") {
			ms.survive = false;
		}else if(element.getName() == "down_speed") {
			if(ModeSelection.speed > 1) ModeSelection.speed--;
			((NLabel)ms.ssUI.getElement("speed")).setText("Speed: " + ModeSelection.speed);
		}else if(element.getName() == "up_speed") {
			if(ModeSelection.speed < 10) ModeSelection.speed++;
			((NLabel)ms.ssUI.getElement("speed")).setText("Speed: " + ModeSelection.speed);
		}else if(element.getName() == "play") {
			TypeMaster.stateHandler.setState("SURVIVE_STATE");
		}else if(element.getName() == "dif_<") {
			if(ModeSelection.diff != ModeSelection.Difficulty.EASY) ModeSelection.diff = ModeSelection.Difficulty.EASY;
			((NLabel)ms.ssUI.getElement("dif_label")).setText(ModeSelection.diff.name());
		}else if(element.getName() == "dif_>") {
			if(ModeSelection.diff != ModeSelection.Difficulty.HARD) ModeSelection.diff = ModeSelection.Difficulty.HARD;
			((NLabel)ms.ssUI.getElement("dif_label")).setText(ModeSelection.diff.name());
		}
	}
}