/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaia_01;

import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public class BreakFirstSearch {

    public State Initial_state;
    public boolean founded_final_state = false;

    public BreakFirstSearch(State initial_State) {
        this.Initial_state = initial_State;

    }

    public void dosearch() {
        int level = 1;
        System.err.println("Estado inicial:" + Initial_state);
        ArrayList<State> current_states = new ArrayList<>();
        ArrayList<State> next_states = new ArrayList<>();
        ArrayList<State> visited_states = new ArrayList<>();

        current_states.add(Initial_state);
        while (!founded_final_state) {
            System.err.println("Generando estados de nivel" + level);

            //generamos los estados siguienetes y los validamos
            for (State state : current_states) {
                for (Transition t : state.validTransition()) {
                    State next = t.doTransition();

                    if (next.isValid() && !visited_states.contains(next)) {
                        System.out.println("-Actción " + t.action
                                + ", reultado" + next);

                        next_states.add(next);

                    }

                }
            }
            
            
        }
    }
}
