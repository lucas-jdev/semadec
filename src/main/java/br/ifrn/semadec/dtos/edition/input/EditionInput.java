package br.ifrn.semadec.dtos.edition.input;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditionInput {

    private String name;
    private String startDate;
    private String endDate;
    private Set<String> records;

}
