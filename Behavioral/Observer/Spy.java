package Behavioral.Observer;

public class Spy implements KingdomObserver {

    private String codeName;

    public Spy(String codeName) {
        this.codeName = codeName;
    }

    @Override
    public void update(KingdomEvent event) {
        // Casus sadece askeri olaylarla ilgilenir
        if (event.getEventType().equals("SOLDIER_ADDED") ||
                event.getEventType().equals("BATTLE_START")) {
            System.out.println("[Casus " + codeName + "] Gizli rapor: " + event.getMessage());
        }
    }

    @Override
    public String getObserverName() {
        return "Casus " + codeName;
    }
    
}
