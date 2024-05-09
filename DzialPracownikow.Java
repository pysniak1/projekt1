import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NotUniqueNameException extends RuntimeException {
    public NotUniqueNameException(String message) {
        super(message);
    }
}

class DzialPracownikow {
    private static Map<String, DzialPracownikow> dzialy = new HashMap<>();
    private String nazwa;
    private List<String> pracownicy;

    private DzialPracownikow(String nazwa) {
        this.nazwa = nazwa;
        this.pracownicy = new ArrayList<>();
    }

    public static DzialPracownikow createDzial(String nazwa) throws NotUniqueNameException {
        if (dzialy.containsKey(nazwa)) {
            throw new NotUniqueNameException("Nazwa działu musi być unikalna.");
        }

        DzialPracownikow dzial = new DzialPracownikow(nazwa);
        dzialy.put(nazwa, dzial);
        return dzial;
    }

    public void dodajPracownika(String pracownik) {
        pracownicy.add(pracownik);
    }

    public List<String> pobierzPracownikow() {
        return pracownicy;
    }

    @Override
    public String toString() {
        return "Dział: " + nazwa + ", Pracownicy: " + pracownicy;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            DzialPracownikow dzial = DzialPracownikow.createDzial("IT");
            dzial.dodajPracownika("Piotr Pysniak");
            dzial.dodajPracownika("John Smith");

            System.out.println("Informacje o dziale: " + dzial);
        } catch (NotUniqueNameException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}
