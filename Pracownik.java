import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pracownik implements Comparable<Pracownik> {
    private static List<Pracownik> listaPracownikow = new ArrayList<>();
    protected String imie;
    protected String nazwisko;
    protected Date dataUrodzenia;
    protected String dzial;

    public Pracownik(String imie, String nazwisko, Date dataUrodzenia, String dzial) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.dzial = dzial;
        listaPracownikow.add(this);
    }

    public static List<Pracownik> getListaPracownikow() {
        return listaPracownikow;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getDzial() {
        return dzial;
    }

    @Override
    public int compareTo(Pracownik innyPracownik) {
        int porownanieNazwisk = this.nazwisko.compareTo(innyPracownik.nazwisko);
        if (porownanieNazwisk != 0) {
            return porownanieNazwisk;
        }
        return this.imie.compareTo(innyPracownik.imie);
    }
}
public class Specjalista extends Pracownik {
    private String specjalizacja;

    public Specjalista(String imie, String nazwisko, Date dataUrodzenia, String dzial, String specjalizacja) {
        super(imie, nazwisko, dataUrodzenia, dzial);
        this.specjalizacja = specjalizacja;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }
}
public class Użytkownik extends Pracownik {
    private String login;
    private String haslo;
    private String inicial;

    public Użytkownik(String imie, String nazwisko, Date dataUrodzenia, String dzial, String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzial);
        this.login = login;
        this.haslo = haslo;
        this.inicial = generateInicial(imie, nazwisko);
    }

    private String generateInicial(String imie, String nazwisko) {
        return (imie.substring(0, 1) + nazwisko.substring(0, 1)).toUpperCase();
    }

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public String getInicial() {
        return inicial;
    }

    public void setImie(String imie) {
        this.imie = imie;
        this.inicial = generateInicial(imie, nazwisko);
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
        this.inicial = generateInicial(imie, nazwisko);
    }
}
public class Brygadzista extends Uzytkownik {
    public Brygadzista(String imie, String nazwisko, Date dataUrodzenia, String dzial, String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzial, login, haslo);
    }

    public List<Brygada> getBrygady() {
        return null;
    }

    public List<Zlecenie> getZlecenia() {
        return null;
    }
}
@Override
    public String toString() {
        return super.toString() + " [Brygadzista]";
    }
}