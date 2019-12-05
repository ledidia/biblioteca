package biblioteca.informatie;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by student on 12/2/2016.
 */
@Entity
public class Autor implements java.io.Serializable {
    private int id;
    private String nume;
    private String pseudonim;
    private String observatii;
    private List<Publicatie> publicatie = new ArrayList<Publicatie>(0);

    public Autor() {
    }

    public Autor(String nume, String pseudonim, String observatii) {
        this.nume = nume;
        this.pseudonim = pseudonim;
        this.observatii = observatii;
    }
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPseudonim() {
        return pseudonim;
    }

    public void setPseudonim(String pseudonim) {
        this.pseudonim = pseudonim;
    }

    public String getObservatii() {
        return observatii;
    }

    public void setObservatii(String observatii) {
        this.observatii = observatii;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Publicatie> getPublicatie() {
        return publicatie;
    }
    public void setPublicatie(List<Publicatie> publicatie) {
        this.publicatie = publicatie;
    }
}