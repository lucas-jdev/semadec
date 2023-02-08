package br.ifrn.semadec.entities.flag;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.ifrn.semadec.entities.user.User;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Flag implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "flags")
    private Set<User> users;

    public Flag() {
    }

    public Flag(UUID id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

}
