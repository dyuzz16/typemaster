package game.state.listener;
import game.TypeMaster;
import nightingale.ui.NActionListener;
import nightingale.ui.NUIElement;

public class MenuListener implements NActionListener {
	@Override
	public void actionPerform(NUIElement element) {
		if(element.getName() == "EXIT") System.exit(1);
		else if(element.getName() == "SETTINGS") TypeMaster.stateHandler.setState("SETTINGS_STATE");
		else if(element.getName() == "PLAY") TypeMaster.stateHandler.setState("MODE_SELECTION_STATE");
		else if(element.getName() == "HELP") TypeMaster.stateHandler.setState("HELP_STATE");
	}
}