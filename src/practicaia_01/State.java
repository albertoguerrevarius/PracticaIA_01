/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaia_01;

import java.util.ArrayList;
import practicaia_01.Transition.Action;

/**
 *
 * @author Alberto
 */
public class State {

    public enum Position {

        DERECHA, IZQUIERDA
    }

    public Position oveja;
    public Position repollos;
    public Position lobo;
    public Position granjero;

    public boolean isValid() {
        if ((oveja == Position.DERECHA)
                && (repollos == Position.DERECHA)
                && (lobo == Position.IZQUIERDA)) {
            return false;
        }

        if ((oveja == Position.DERECHA)
                && (lobo == Position.DERECHA)
                && (granjero == Position.IZQUIERDA)) {
            return false;
        }
        //yo la hice
        if ((oveja == Position.IZQUIERDA)
                && (lobo == Position.IZQUIERDA)
                && (granjero == Position.DERECHA)) {
            return false;

        }
        return true;

    }

    public boolean isFinal() {
        if ((oveja == Position.IZQUIERDA)
                && (repollos == Position.IZQUIERDA)
                && (lobo == Position.IZQUIERDA)
                && (granjero == Position.IZQUIERDA)) {
            return true;
        }

        return false;

    }

    public ArrayList<Transition> validTransition() {
        ArrayList<Transition> result
                = new ArrayList<>();

        //mover al granjero siempre es posible
        result.add(new Transition(this, Transition.Action.MOVER_GRANJERO));

        //mover ala oveja solo es posible con el granjero
        if (oveja == granjero) {
            result.add(new Transition(this, Action.MOVER_OVEJA));
        }
        //mover a los demas objetos quedan en la comodidad de suu hogar

        return result;
    }

    public static void main(String[] args) {
        State test = new State();
        test.granjero = Position.DERECHA;
        System.out.println(test);
    }

    @Override
    public String toString() {
        return "Posicion oveja: " + oveja + ","
                + "Posicion repollos" + repollos + ","
                + "Posicion lobo" + lobo + ","
                + "Posicion granjero" + granjero;
    }
}
