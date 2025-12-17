package h1;
import java.util.ArrayList;

public class PrioListe {
    public ArrayList<Patient> myList = new ArrayList<>();

    public void addPatient(Patient p) {

        if (myList.size() == 0) {
            myList.add(p);
            return;
        }

        for (int i = 0; i < myList.size(); i++) {
            if (p.prio < myList.get(i).prio) {
                myList.add(i, p);
                return;
            }
        }

        myList.add(p);
        return;
    }

    public Patient getNextPatient() {

        if (myList.size() == 0) {
            return null;
        }

        return myList.remove(0);
    }

    public int getPosition(Patient p) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) == p) {
                return i;
            }
        }
        return -1;
    }
}
