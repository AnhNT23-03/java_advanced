package com.vti.dto;
                học tếp JAVA ADvanced từ video 13 slide 9 và cuối slide 8 đang nói về hateoas
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
public class AccountDto extends RepresentationModel<DepartmentDto> {
    private int id; // b3 sau b2 từ class AccountSpecification
    private String userName;
    private String departmentName;
}
