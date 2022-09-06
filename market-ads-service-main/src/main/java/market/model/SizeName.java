package market.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class SizeName {

    @Id
    private Long id;

    @NotBlank
    private String name;

    public SizeName() {}

    public SizeName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SizeName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
