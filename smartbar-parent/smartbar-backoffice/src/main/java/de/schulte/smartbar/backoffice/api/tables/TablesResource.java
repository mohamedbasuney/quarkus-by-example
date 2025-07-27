package de.schulte.smartbar.backoffice.api.tables;


import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import jakarta.annotation.security.RolesAllowed;


public interface TablesResource extends PanacheEntityResource<Table,Long> {
}