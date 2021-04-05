package ch6.simple;

import ch6.Command;

public class SimpleRemoteControl {

    Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }

}
