package de.schulte.smartbar.backoffice.api.categories;


import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import jakarta.annotation.security.RolesAllowed;

@RolesAllowed("admin")
public interface CategoriesResource extends PanacheEntityResource<Category,Long> {
}