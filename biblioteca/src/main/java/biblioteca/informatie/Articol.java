package biblioteca.informatie;

import javax.persistence.*;
import java.util.*;

/**
 * Created by student on 12/2/2016.
 */
@Entity
@DiscriminatorValue("articol")
public class Articol extends Publicatie {
    private String revista;
    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }
}

