package com.vti.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountFilterForm {
    private String search;

    // B1 -> B2 to AccountSpecification
    private Integer minId;
    private Integer maxId;
}
