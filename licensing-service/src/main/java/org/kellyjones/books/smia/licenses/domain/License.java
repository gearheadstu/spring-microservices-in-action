package org.kellyjones.books.smia.licenses.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class License {

    private Long id;
    private String productName;
    private String licenseSeat;
    private Organization organization;
}
