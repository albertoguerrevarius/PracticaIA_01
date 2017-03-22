/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaia_01;

import practicaia_01.State.Position;

/**
 *
 * @author Alberto
 */
public class Transition {

    public enum Action {

        MOVER_OVEJA, MOVER_REPOLLOS, MOVER_LOBO, MOVER_GRANJERO
    }
public State initial;
public Action action;

    public State doTransition() {

        
        State result = new State();
        if (action == Action.MOVER_GRANJERO) {

            result.oveja = initial.oveja;
            result.repollos = initial.repollos;
            result.lobo = initial.lobo;

            if (initial.granjero == Position.DERECHA) {
                result.granjero = Position.IZQUIERDA;
            } else {
                result.granjero = Position.DERECHA;
            }
        }

        if (action == Action.MOVER_OVEJA) {

            if (initial.oveja == Position.DERECHA) 
                result.oveja = Position.IZQUIERDA;
             else {
                result.oveja = Position.DERECHA;
            }
            result.repollos = initial.repollos;
            result.lobo = initial.lobo;

            if (initial.granjero == Position.DERECHA) {
                result.granjero = Position.IZQUIERDA;
            } else {
                result.granjero = Position.DERECHA;
            }
        }

        return result;

    }
public Transition(State initial, Action action){
    this.initial = initial;
    this.action = action;
}
}


