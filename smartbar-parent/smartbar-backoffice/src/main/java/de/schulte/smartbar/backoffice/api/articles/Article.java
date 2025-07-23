package de.schulte.smartbar.backoffice.api.articles;


import de.schulte.smartbar.backoffice.BaseEntity;
import de.schulte.smartbar.backoffice.api.categories.Category;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.security.PublicKey;
import java.util.List;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "category_id"})
})
@NamedQueries({
        @NamedQuery(name = "Article.ByCategory",
                query = "from Article where category = ?1 order by price desc"),
        @NamedQuery(name = "Article.ByCategoryId",
                query = "from Article where category.id = :id order by price desc"),
        @NamedQuery(name = "Article.nameContaining",
                query = "from Article where name like concat('%', concat(?1, '%'))")
})
public class Article  extends BaseEntity {

    @NotNull
    public String name;

    @NotNull
    @Positive
    public BigDecimal price;

    @NotNull
    public String description;

    @NotNull
    public String pictureBase64;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    public Category category;

    /*public static List<Article> listByCategory(Category category) {
        return  list("from Article where category=?1",category);
    }

    public static List<Article> listByCategoryUsingFind(Category category) {
        return  find("from Article where category=?1",category).list();
    }

    public static List<Article> listByCategorySorting(Category category) {
        return list("category", Sort.by("price", Sort.Direction.Descending), category);
    }
    public static List<Article> listByCategorySortingAndPaging(Category category) {
        return find("category", Sort.by("price", Sort.Direction.Ascending), category)
                .page(Page.of(0,3))
                .list();
    }

    public static List<Article> listByCategoryNamedQuery(Category category) {
        return find("#Article.ByCategory", category)
                .page(Page.of(0,3))
                .list();
    }*/
}