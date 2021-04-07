package ch12;

import ch12.Observer;

public interface QuackObservable {
    public void registerObserver(Observer observer);

    public void notifyObservers();
}