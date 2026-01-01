package Behavioral.Observer;

public interface KingdomObserver {

    void update(KingdomEvent event);

    String getObserverName();
}

