package br.ifrn.semadec.entities.user;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class SocialNetwork implements Serializable {

    private String twitter;
    private String facebook;
    private String instagram;
    private String tiktok;

}
