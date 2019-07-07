package design_patterns_and_principles.singleton;

import java.io.Serializable;

public class VisitorTicketTracker implements Serializable {
    private VisitorTicketTracker() { }

    private static volatile VisitorTicketTracker instance;

    public VisitorTicketTracker getInstance(){
        if(instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new VisitorTicketTracker();
                }
            }
        }
        return instance;
    }

    protected Object readResolve(){
        return getInstance();
    }
}
