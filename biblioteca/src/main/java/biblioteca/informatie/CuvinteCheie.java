package biblioteca.informatie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by student on 12/2/2016.
 */
@Entity
public class CuvinteCheie {
    private int id;
    private String cuvint;
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCuvint() {
        return cuvint;
    }
    public void setCuvint(String cuvint) {
        this.cuvint = cuvint;
    }
}
