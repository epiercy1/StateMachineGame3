import java.util.ArrayList;
import java.util.HashMap;

public class Main {
private HashMap<StateType, State> states = new HashMap<StateType, State> ();
	
	public static void main(String[] args) {
		Main m = new Main();
		m.go();
	}
	public void go(){
		Model model = new Model();
		StateType currentStateType = model.getCurrentState();
		
		createStates(model);
		
		//Prompt the user if they want to load a previous game
		
		while(currentStateType != StateType.EndOfGame) {
			State currentState = states.get(currentStateType);
					
			String description = currentState.getDescription();
			System.out.println(description);
			
			ArrayList<String>options = currentState.getOptions();
			
			//print out the options
			//add on an option to save the game
			
			//get the user's choice
			
			//currentState.processChoice(choice);
			
			currentStateType = model.getCurrentState();
			
		}
	}
	
	public void createStates(Model model) {
		states.put(StateType.StreetOutsideHouse, new StreetOutsideHouse(model));
		states.put(StateType.OutsideSchoolBuilding, new OutsideSchoolBuilding(model));
		states.put(StateType.Classroom, new Classroom(model));
		states.put(StateType.Playground, new Playground(model));
		states.put(StateType.Auditorium, new Auditorium(model));
	}

}
