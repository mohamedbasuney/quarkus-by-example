package de.schulte.smartbar.backoffice.api.tables;

import de.schulte.smartbar.backoffice.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@jakarta.persistence.Table(name = "sbo_Table", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
}

)
public class Table extends BaseEntity {

    @NotNull
    public String name;

    @NotNull
    public Integer seatCount;

    @NotNull
    public  boolean active;
}