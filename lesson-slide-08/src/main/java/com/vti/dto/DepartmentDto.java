package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class DepartmentDto extends RepresentationModel<DepartmentDto> {
    private int id;
    private String name;
    private int totalMembers;
    private String type;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    private List<AccountDto> accounts;

    @Setter
    @Getter
    public static class AccountDto {
        @JsonProperty("accountId")
        private int id;
        private String username;
    }
}
