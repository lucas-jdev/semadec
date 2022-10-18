package br.ifrn.semadec.entities.user;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class SocialNetwork {

    private String twitter;
    private String facebook;
    private String instagram;
    private String tiktok;

}
