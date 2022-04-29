package com.example.security.models;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.Id;

        import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

    public Role(String role_user) {
        this.name = role_user;
    }
}
