package org.kellyjones.books.smia.licenses.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizationContact {

    private Long id;
    private Long organizationID;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
}
