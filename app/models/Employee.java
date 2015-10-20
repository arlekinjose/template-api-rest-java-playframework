package models;

import javax.persistence.*;
import play.data.validation.Constraints;
import play.data.format.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
public class Employee extends Model {
    public static String TABLE = "Employee";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id;

    @Constraints.Required
    public String name;

    public void emptyToNull() {
        if (name != null && name.isEmpty()) name = null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Employee aux = (Employee) obj;

        if (id != null && aux.id != null)
            return (id == aux.id);
        else
            return (name.equals(aux.name));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result +
            ((id == null) ? 0 : id);
        result = prime * result + name.hashCode();
        return result;
    }
}