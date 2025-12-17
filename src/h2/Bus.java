package h2;
import java.util.ArrayList;

public class Bus {
    ArrayList<Passenger> passengers;

    public Bus() {
        passengers = new ArrayList<>();
    }

    public void enterBus(Passenger p) {
        passengers.add(p);
    }

    private void exitBus() {
        for (int i = 0; i < passengers.size(); i++) {
            Passenger p = passengers.get(i);
            if (p.visited >= p.planned) {
                passengers.remove(i);
                i--;
            }
        }
    }

    public void nextStop() {
        for (int i = 0; i < passengers.size(); i++) {
            Passenger p = passengers.get(i);
            p.visited += 1;
        }

        exitBus();
    }

    public void nextStop(Passenger[] boarding) {
        for (int i = 0; i < passengers.size(); i++) {
            Passenger p = passengers.get(i);
            p.visited += 1;
        }

        exitBus();

        for (Passenger p : boarding) {
            enterBus(p);
        }
    }

    public ArrayList<Passenger> findPassengersWithoutTickets() {
        ArrayList<Passenger> noTicket = new ArrayList<>();

        for (int i = 0; i < passengers.size(); i++) {
            Passenger p = passengers.get(i);
            if (!p.ticket) {
                noTicket.add(p);
                passengers.remove(p);
            }
        }

        return noTicket;
    }

    public void transferPassengers(Bus otherBus, String[] passengerNames) {
        for (String name : passengerNames) {
            for (int i = 0; i < passengers.size(); i++) {
                Passenger p = passengers.get(i);
                if (p.name.equals(name)) {
                    otherBus.enterBus(p);
                    passengers.remove(i);
                    break;
                }
            }
        }
    }
}
