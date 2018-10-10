package in.saeakgec.efficycle.model;

import javax.persistence.*;


@Entity
@Table(name = "notes_step")
public class NStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
