import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Zlecenie implements Runnable {
    public enum Rodzaj { Planowanie, Nieplanowanie }

    private boolean czyPlanowane;
    private Collection<Prac> kolekcjaPrac; 
    private Brygada brygada;
    private Rodzaj rodzaj;
    private LocalDateTime dataUtworzenia;
    private LocalDateTime dataRozpoczecia;
    private LocalDateTime dataZakonczenia;

    private static Map<Integer, Zlecenie> zlecenieMapa = new HashMap<>();
    private static int kolejnyNumer = 1;

    public Zlecenie(boolean czyPlanowane, Collection<Prac> kolekcjaPrac, Brygada brygada) { 
        this.czyPlanowane = czyPlanowane;
        this.kolekcjaPrac = kolekcjaPrac != null ? kolekcjaPrac : new ArrayList<>();
        this.brygada = brygada;
        this.rodzaj = czyPlanowane ? Rodzaj.Planowanie : Rodzaj.Nieplanowanie;

        zlecenieMapa.put(kolejnyNumer++, this);
    }

    public boolean dodajPrace(Prac prac) {
        return brygada != null && kolekcjaPrac.add(prac);
    }

    public Rodzaj getRodzaj() {
        return rodzaj;
    }

    public LocalDateTime getDataUtworzenia() {
        return dataUtworzenia;
    }

    public LocalDateTime getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public LocalDateTime getDataZakonczenia() {
        return dataZakonczenia;
    }

    @Override
    public void run() {
        if (brygada != null && !kolekcjaPrac.isEmpty()) {
            dataRozpoczecia = LocalDateTime.now();
            for (Prac prac : kolekcjaPrac) { 
                prac.wykonajPrace();
            }
            dataZakonczenia = LocalDateTime.now();
        }
    }

    public String stanZlecenia() {
        if (dataRozpoczecia == null && dataZakonczenia == null) {
            return "Utworzone";
        } else if (dataRozpoczecia != null && dataZakonczenia == null) {
            return "Rozpoczęte";
        } else {
            return "Zakończone";
        }
    }

    public static Zlecenie pobierzZlecenie(int numer) {
        return zlecenieMapa.get(numer);
    }

    @Override
    public String toString() {
        return "Zlecenie{" +
                "czyPlanowane=" + czyPlanowane +
                ", kolekcjaPrac=" + kolekcjaPrac +
                ", brygada=" + brygada +
                ", rodzaj=" + rodzaj +
                ", dataUtworzenia=" + dataUtworzenia +
                ", dataRozpoczecia=" + dataRozpoczecia +
                ", dataZakonczenia=" + dataZakonczenia +
                '}';
    }
}
