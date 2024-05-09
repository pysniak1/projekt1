import java.util.ArrayList;
import java.util.List;

public class Brygada {
    private String nazwa;
    private Brygadzista brygadzista;
    private List<Pracownik> listaPracownikow;

    public Brygada(String nazwa, Brygadzista brygadzista) {
        this.nazwa = nazwa;
        this.brygadzista = brygadzista;
        this.listaPracownikow = new ArrayList<>();
    }

    public void dodajPracownika(Pracownik pracownik) {
        listaPracownikow.add(pracownik);
    }

    public void dodajPracownikow(List<Pracownik> pracownicy) {
        listaPracownikow.addAll(pracownicy);
    }

    public String getNazwa() {
        return nazwa;
    }

    public Brygadzista getBrygadzista() {
        return brygadzista;
    }

    public List<Pracownik> getListaPracownikow() {
        return listaPracownikow;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Brygada: ").append(nazwa).append("\n");
        sb.append("Brygadzista: ").append(brygadzista).append("\n");
        sb.append("Lista pracowników: ").append(listaPracownikow).append("\n");
        return sb.toString();
    }
}
