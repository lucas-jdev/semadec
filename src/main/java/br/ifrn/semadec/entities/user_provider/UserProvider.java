package br.ifrn.semadec.entities.user_provider;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name = "user_providers")
@Data
public class UserProvider {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    
    private String username;
    private String token;

    @Enumerated(EnumType.STRING)
    private Provider provider;

}
