package de.schulte.smartbar.backoffice.api.articles;

import de.schulte.smartbar.backoffice.api.categories.Category;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@ResourceProperties(hal = true,rolesAllowed = {"admin"})
//@ResourceProperties(hal = true)
public interface ArticlesResource extends PanacheEntityResource<Article,Long> {
    @GET
    @Path("/name")
    @Produces({MediaType.APPLICATION_JSON})
    default Uni<List<PanacheEntityBase>> getByNameContaining(@QueryParam("s") String fragment) {
        return Article.list("#Article.nameContaining", fragment);
    }
    /*
    @GET
    @Path("/category/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    default Response articlesGetByCategoryId(@PathParam("categoryId") Long categoryId) {
        final Optional<Category> category = Category.findByIdOptional(categoryId);
        if (category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build(); // 404 if category doesn't exist
        }
        List<Article> articles = Article.listByCategory(category.get());
        return Response.ok(articles).build();
    }

    @GET
    @Path("/categoryUsingFind/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    default Response articlesGetByCategoryIdUsingFind(@PathParam("categoryId") Long categoryId) {
        final Optional<Category> category = Category.findByIdOptional(categoryId);
        if (category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build(); // 404 if category doesn't exist
        }
        List<Article> articles = Article.listByCategoryUsingFind(category.get());
        return Response.ok(articles).build();
    }

    @GET
    @Path("/categorySorting/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    default Response articlesGetByCategoryIdSorting(@PathParam("categoryId") Long categoryId) {
        final Optional<Category> category = Category.findByIdOptional(categoryId);
        if (category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build(); // 404 if category doesn't exist
        }
        List<Article> articles = Article.listByCategorySorting(category.get());
        return Response.ok(articles).build();
    }

    @GET
    @Path("/categorySortingAndPaging/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    default Response articlesGetByCategoryIdSortingAndPaging(@PathParam("categoryId") Long categoryId) {
        final Optional<Category> category = Category.findByIdOptional(categoryId);
        if (category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build(); // 404 if category doesn't exist
        }
        List<Article> articles = Article.listByCategorySortingAndPaging(category.get());
        return Response.ok(articles).build();
    }

    @GET
    @Path("/categoryNamed/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    default Response articlesGetByCategoryIdNamed(@PathParam("categoryId") Long categoryId) {
        final Optional<Category> category = Category.findByIdOptional(categoryId);
        if (category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build(); // 404 if category doesn't exist
        }
        List<Article> articles = Article.listByCategoryNamedQuery(category.get());
        return Response.ok(articles).build();
    }*/
}
