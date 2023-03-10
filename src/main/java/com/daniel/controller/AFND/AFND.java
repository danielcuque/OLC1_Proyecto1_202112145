package com.daniel.controller.AFND;

import com.daniel.controller.TransitionTable.State;
import com.daniel.controller.TransitionTable.Transition;
import com.daniel.controller.Tree.*;

import java.util.*;

public class AFND {

    public Set<State> states = new HashSet<>();
    public Set<String> alphabet = new HashSet<>();
    public Set<Transition> transitions = new HashSet<>();
    public Set<State> finalStates = new HashSet<>();

    private int stateNumber = 0;
    private final String name;

    public AFND(Node root, String name){
        this.name = name;
        buildNFA(root);
    }

    public void buildNFA(Node node) {
        if (node == null) {
            return;
        }
        String EPSILON = "ε";
        if (node.type == NodeType.LEAVE) {
            State state1 = new State(stateNumber++, false, node.lexeme.toString());
            State state2 = new State(stateNumber++, true, node.lexeme.toString());
            states.add(state1);
            states.add(state2);
            finalStates.add(state1);
            finalStates.add(state2);
            alphabet.add(node.lexeme.toString());
            transitions.add(new Transition(state1, node.lexeme.toString(), state2));
        } else if (node.type == NodeType.AND) {
            buildNFA(node.left);
            buildNFA(node.right);
            State lastStateLeft = getLastState(node.left);
            State firstStateRight = getFirstState(node.right);
            lastStateLeft.setAccepting(false);
            firstStateRight.setAccepting(false);
            transitions.add(new Transition(lastStateLeft, EPSILON, firstStateRight));
        } else if (node.type == NodeType.OR) {
            buildNFA(node.left);
            buildNFA(node.right);
            State state1 = new State(stateNumber++, false, "");
            State state2 = new State(stateNumber++, true, "");
            states.add(state1);
            states.add(state2);
            State firstStateLeft = getFirstState(node.left);
            State firstStateRight = getFirstState(node.right);
            State lastStateLeft = getLastState(node.left);
            State lastStateRight = getLastState(node.right);
            lastStateLeft.setAccepting(false);
            lastStateRight.setAccepting(false);
            transitions.add(new Transition(state1, EPSILON, firstStateLeft));
            transitions.add(new Transition(state1, EPSILON, firstStateRight));
            transitions.add(new Transition(lastStateLeft, EPSILON, state2));
            transitions.add(new Transition(lastStateRight, EPSILON, state2));
        } else if (node.type == NodeType.STAR) {
            buildNFA(node.left);
            State state1 = new State(stateNumber++, false, "");
            State state2 = new State(stateNumber++, true, "");
            states.add(state1);
            states.add(state2);
            State firstStateLeft = getFirstState(node.left);
            State lastStateLeft = getLastState(node.left);
            lastStateLeft.setAccepting(false);
            transitions.add(new Transition(state1, EPSILON, firstStateLeft));
            transitions.add(new Transition(state1, EPSILON, state2));
            transitions.add(new Transition(lastStateLeft, EPSILON, firstStateLeft));
            transitions.add(new Transition(lastStateLeft, EPSILON, state2));
        } else if(node.type == NodeType.PLUS){
            buildNFA(node.left);
            State state1 = new State(stateNumber++, false, "");
            State state2 = new State(stateNumber++, true, "");
            states.add(state1);
            states.add(state2);
            State firstStateLeft = getFirstState(node.left);
            State lastStateLeft = getLastState(node.left);
            lastStateLeft.setAccepting(false);
            transitions.add(new Transition(state1, EPSILON, firstStateLeft));
            transitions.add(new Transition(lastStateLeft, EPSILON, firstStateLeft));
            transitions.add(new Transition(lastStateLeft, EPSILON, state2));
        } else if(node.type == NodeType.QUERY){
            buildNFA(node.left);
            State state1 = new State(stateNumber++, false, "");
            State state2 = new State(stateNumber++, true, "");
            states.add(state1);
            states.add(state2);
            State firstStateLeft = getFirstState(node.left);
            State lastStateLeft = getLastState(node.left);
            lastStateLeft.setAccepting(false);
            transitions.add(new Transition(state1, EPSILON, firstStateLeft));
            transitions.add(new Transition(state1, EPSILON, state2));
            transitions.add(new Transition(lastStateLeft, EPSILON, state2));
        }
    }

    public State getFirstState(Node node){
        if (node == null) {
            return null;
        }
        if (node.type == NodeType.LEAVE) {
            return states.stream().filter(state -> state.lexeme.equals(node.lexeme.toString())).findFirst().get();
        } else if (node.type == NodeType.AND) {
            return getFirstState(node.left);
        } else if (node.type == NodeType.OR) {
            return getFirstState(node.left);
        } else if (node.type == NodeType.STAR) {
            return getFirstState(node.left);
        }
        return null;
    }

    public State getLastState(Node node){
        if (node == null) {
            return null;
        }
        if (node.type == NodeType.LEAVE) {
            return states.stream().filter(state -> state.lexeme.equals(node.lexeme.toString())).skip(1).findFirst().get();
        } else if (node.type == NodeType.AND) {
            return getLastState(node.right);
        } else if (node.type == NodeType.OR) {
            return getLastState(node.right);
        } else if (node.type == NodeType.STAR) {
            return getLastState(node.left);
        }
        return null;
    }



    public String getNameRegex() {
        return name;
    }

    public Set<Transition> getTransitionsFromState(State state){
        Set<Transition> transitionsFromState = new HashSet<>();
        for (Transition transition: transitions){
            if (transition.getCurrentState().equals(state)){
                transitionsFromState.add(transition);
            }
        }
        return transitionsFromState;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("States: ").append(states).append("\n");
        sb.append("Alphabet: ").append(alphabet).append("\n");
        sb.append("Transitions: ").append(transitions).append("\n");
        return sb.toString();
    }
}
