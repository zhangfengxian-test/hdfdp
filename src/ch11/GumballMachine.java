package ch11;

import ch10.state.State;

public class GumballMachine {

    String location;
    int count;
    State state;

    public GumballMachine(String location, int count) {
        this.location = location;
        this.count = count;
    }

    public String getLocation() {
        return location;
    }

    public int getCount() {
        return count;
    }

    public State getState() {
        return state;
    }
}
