package org.kellyjones.books.smia.licenses.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Organization {

    private Long id;
    private String name;
    private OrganizationContact contact;
}
