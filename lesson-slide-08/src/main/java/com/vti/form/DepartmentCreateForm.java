package com.vti.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DepartmentCreateForm {
    private String name;
    private int totalMembers;
    private String type;
    private List<Account> accounts;

    @Setter
    @Getter
    public static class Account {
        private String username;
    }
}
