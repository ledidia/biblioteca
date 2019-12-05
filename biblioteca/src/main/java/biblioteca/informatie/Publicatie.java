package biblioteca.informatie;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 12/2/2016.
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype", discriminatorType =DiscriminatorType.STRING, length=15)
@DiscriminatorValue("publicatie")
public class Publicatie
{
    private int id;
    private String denumire;
    private List<Autor> autor=new ArrayList<Autor>();
    private Date data;
    private CuvinteCheie cuvint;
    private Locatie locatie ;
    private String type;
    private Descriere descriere;
    @GeneratedValue
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
@ManyToMany
    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
@ManyToOne
    public CuvinteCheie getCuvint() {
        return cuvint;
    }

    public void setCuvint(CuvinteCheie cuvint) {
        this.cuvint = cuvint;
    }
    @OneToOne(fetch = FetchType.LAZY)
    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }
    @Column (name="dtype" , length=15, insertable=false ,updatable=false)
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
@OneToOne
    public Descriere getDescriere() {
        return descriere;
    }
    public void setDescriere(Descriere descriere) {
        this.descriere = descriere;
    }
}
