package Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class KingdomSubject {
    private List<KingdomObserver> observers = new ArrayList<>();

    public void attach(KingdomObserver observer) {
        observers.add(observer);
        System.out.println(observer.getObserverName() + " KRALLIK İZLENİYOR..");
    }

    public void detach(KingdomObserver observer) {
        observers.remove(observer);
        System.out.println(observer.getObserverName() + " KIRALLIK İZLEMESİ DURDURULDU.");
    }

    public void notifyObservers(KingdomEvent event) {
        for (KingdomObserver observer : observers) {
            observer.update(event);
        }
    }

    public int getObserverCount() {
        return observers.size();
    }
}
