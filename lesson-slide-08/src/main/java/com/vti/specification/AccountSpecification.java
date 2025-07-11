package com.vti.specification;

import com.vti.entity.Account;
import com.vti.form.AccountFilterForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AccountSpecification {
    public static Specification<Account> buildSpec(AccountFilterForm form) {
        if (form == null) {
            return null;
        }
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(form.getSearch())) {
                predicates.add(
                        builder.or(
                                builder.like(
                                        root.get("userName"),
                                        "%" + form.getSearch() + "%"
                                ),
                                builder.like(
                                        root.get("department").get("name"),
                                        "%" + form.getSearch() + "%"
                                )
                        )
                );
            }
            // B2_p1 vs minId
            if (form.getMinId() != null) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get("id"),
                        form.getMinId()
                ));
            }

            // B2_p2 vs maxId, to AccountDto
            if (form.getMaxId() != null) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get("id"),
                        form.getMaxId()
                ));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
