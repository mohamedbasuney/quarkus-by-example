package de.schulte.smartbar.backoffice;


import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "entity_seq",sequenceName = "entity_seq")
    @GeneratedValue(generator = "entity_seq")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
