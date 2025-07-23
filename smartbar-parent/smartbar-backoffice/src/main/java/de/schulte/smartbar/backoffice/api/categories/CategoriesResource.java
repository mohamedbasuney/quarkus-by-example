package de.schulte.smartbar.backoffice.api.categories;


import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;


public interface CategoriesResource extends PanacheEntityResource<Category,Long> {
}