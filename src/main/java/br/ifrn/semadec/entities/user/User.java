package br.ifrn.semadec.entities.user;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.ifrn.semadec.entities.flag.Flag;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false)
    private String fullName;

    private String phone;

    @Column(nullable = false)
    private String cpf;

    @Column(unique = true, nullable = false)
    private String academicEmail;

    @Column(unique = true, nullable = false)
    private String personalEmail;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;

    @Column(length = 300)
    private String biography;

    private int likes;

    @ManyToMany
    @JoinTable(name = "user_flag", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "flag_id"))
    private Set<Flag> flags;

}
