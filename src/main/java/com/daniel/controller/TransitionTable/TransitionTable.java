package com.daniel.controller.TransitionTable;

import com.daniel.controller.FollowTable.FollowTable;
import com.daniel.controller.Tree.NodeType;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TransitionTable {

    private final State initialState;
    private Set<Transition> transitions;
    public Set<State> states;
    public String name;
    public FollowTable followTable;

    public TransitionTable(State initialState, FollowTable followTable) {
        Comparator<State> comparator = Comparator.comparingInt(State::getNumber);
        this.initialState = initialState;
        this.followTable = followTable;
        this.transitions = new HashSet<>();
        this.states = new TreeSet<>(comparator);
        this.states.add(initialState);
        calculateTransitions(initialState);
        verifyIfStateIsAccepting();
    }

    public void calculateTransitions(State state){
        for(Integer i: state.follows){
            String lexeme = (String) this.followTable.getNode(i).lexeme;
            Set<Integer> follows = getFollowsOfLexemeAvailable(i, state.follows);
            if (!verifyIfStateExist(follows)){
                if (follows.isEmpty()){
                    continue;
                }
                State newState = new State(states.size());
                newState.follows = follows;
                states.add(newState);
                Transition transition = new Transition(state,lexeme, newState);
                // Verificar que la transicion no exista
                if (verifyIfTransitionExist(transition))
                    transitions.add(transition);
                calculateTransitions(newState);
            } else {
                State newState = getStateByFollows(follows);
                Transition transition = new Transition(state,lexeme, newState);
                // Verificar que la transicion no exista
                if (verifyIfTransitionExist(transition))
                    transitions.add(transition);
            }
        }
    }

    // Metodo para saber si es un estado de aceptación
    public void verifyIfStateIsAccepting(){
        for (State state: states){
            for (Integer i: state.follows){
                if (this.followTable.getNode(i).type == NodeType.ACCEPT){
                    state.isAccepting = true;
                    break;
                }
            }
        }
    }

    public boolean verifyIfTransitionExist(Transition transition){
        for (Transition transition1: transitions){
            if (transition1.getCurrentState() == transition.getCurrentState() &&
                    transition1.getCharacter().equals(transition.getCharacter()) &&
                    transition1.getNextState() == transition.getNextState()){
                return false;
            }
        }
        return true;
    }

    public State getStateByFollows(Set<Integer> follows){
        for(State state: states){
            if (state.follows.equals(follows)){
                return state;
            }
        }
        return null;
    }

    // Metodo para saber las transiciones que van desde el estado x, con que lexema, hacia el estado y
    public Set<Transition> getTransitionsFromState(State state){
        Set<Transition> transitionsFromState = new HashSet<>();
        for (Transition transition: transitions){
            if (transition.getCurrentState().equals(state)){
                transitionsFromState.add(transition);
            }
        }
        return transitionsFromState;
    }

    public String getNameRegex() {
        return name;
    }

    public Set<String> getLexemes(){
        Set<String> lexemes = new HashSet<>();
        for (Transition transition: transitions){
            lexemes.add(transition.getCharacter());
        }
        return lexemes;
    }

    public boolean verifyIfStateExist(Set<Integer> follows){
        for(State state: states){
            if (state.follows.equals(follows)){
                return true;
            }
        }
        return false;
    }

    /*
    Vamos a recibir int que va a ser el numero del nodo dentro
    de la tabla de follow, luego vamos a agarrar su lexema
    y vamos a recorrer toda la tabla para ver cuantas veces aparece
    ese lexema, y vamos a unir los follows. Siempre y cuando el numero
    de ese nodo dentro de la tabla pertezca al estado inicial
    */
    public Set<Integer> getFollowsOfLexemeAvailable(int numberOfNode, Set<Integer> availableFollows){
        Set<Integer> follows = new HashSet<>();
        String lexeme =(String)this.followTable.getNode(numberOfNode).lexeme;
        for (Integer i: availableFollows){
            if (this.followTable.getNode(i).lexeme.equals(lexeme)){
                follows.addAll(this.followTable.getNode(i).follow);
            }
        }
        return follows;
    }


    @Override
    public String toString() {
        return "Transition Table {\n" +
                "Transitions: " + transitions + "\n" +
                "States: " + states + "\n" +
                "}";
    }
}
