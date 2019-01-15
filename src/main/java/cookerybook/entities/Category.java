package cookerybook.entities;

import cookerybook.entities.base.EntityModel;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category implements EntityModel {

    private int id;
    private String name;
    private Set<Receipt> receipts;

    public Category() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", length = 100, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy="category")
    public Set<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(Set<Receipt> receipts) {
        this.receipts = receipts;
    }

    public boolean isSelected(Integer categoryId){
        if (categoryId != null) {
            return categoryId.equals(getId());
        }
        return false;
    }
}
