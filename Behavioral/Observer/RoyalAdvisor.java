package Behavioral.Observer;

public class RoyalAdvisor implements KingdomObserver{

    private String name;

    public RoyalAdvisor(String name) {
        this.name = name;
    }

    @Override
    public void update(KingdomEvent event) {
        System.out.println("[" + name + "] Olay kaydedildi: " + event.getMessage());

        // Önemli olaylara özel tepki
        switch (event.getEventType()) {
            case "SOLDIER_ADDED":
                System.out.println("!* " + name + ": \"Ordumuz güçleniyor, Majesteleri!\"");
                break;
            case "GOLD_SPENT":
                System.out.println("!* " + name + ": \"Hazine dikkatli kullanılmalı...\"");
                break;
            case "GOLD_CHANGE":
                System.out.println("!* " + name + ": \"Harika! Hazine büyüyor!\"");
                break;
        }
    }

    @Override
    public String getObserverName() {
        return "Danışman " + name;
    }
    
}
