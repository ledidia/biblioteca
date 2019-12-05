package biblioteca.informatie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by student on 12/2/2016.
 */
@Entity
public class Editura {
    private int id;
    private String nume;
    private String director;
    private String adresa;
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int idEditura) {
        this.id = idEditura;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getAdresa() {
        return adresa;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
