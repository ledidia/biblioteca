package biblioteca.informatie;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by student on 12/2/2016.
 */
@Entity
@DiscriminatorValue("carte")
public class Carte  extends Publicatie {
    private Editura editura;
    @ManyToOne
    public Editura getEditura() {
        return editura;
    }
    public void setEditura(Editura editura) {
        this.editura = editura;
    }
}
