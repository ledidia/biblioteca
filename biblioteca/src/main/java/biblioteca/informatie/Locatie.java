package biblioteca.informatie;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 12/2/2016.
 */
@Entity
public class Locatie implements java.io.Serializable {
    private int id;
    private String denumirea;
    private String adresa;
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumirea() {
        return denumirea;
    }

    public void setDenumirea(String denumirea) {
        this.denumirea = denumirea;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }


}