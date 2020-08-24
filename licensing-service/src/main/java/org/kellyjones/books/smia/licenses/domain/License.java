package org.kellyjones.books.smia.licenses.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class License {

    private String licenseID;
    private String productName;
    private String licenseSeat;
    private String organizationID;
}
