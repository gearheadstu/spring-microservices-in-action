package org.kellyjones.books.smia.licenses.services;

import org.kellyjones.books.smia.licenses.domain.License;
import org.kellyjones.books.smia.licenses.domain.Organization;
import org.kellyjones.books.smia.licenses.domain.OrganizationContact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LicenseService {

    private static final List<License> PRETEND_THIS_IS_A_DATABASE = new ArrayList<>();

    static {
        PRETEND_THIS_IS_A_DATABASE.add(
                License.builder()
                        .id(1234L)
                        .productName("productName1")
                        .licenseSeat("fff")
                        .organization(
                                Organization.builder()
                                        .id(999L)
                                        .name("My Organization")
                                        .contact(
                                                OrganizationContact.builder()
                                                        .id(2002L)
                                                        .organizationID(999L)
                                                        .contactName("Jane Doe")
                                                        .contactEmail("nobody@invalid.ie")
                                                        .contactPhone("800-555-1212")
                                                        .build()
                                        )
                                        .build()
                        )
                        .build());

        Organization myOrganization = PRETEND_THIS_IS_A_DATABASE.get(0).getOrganization();

        PRETEND_THIS_IS_A_DATABASE.add(
                License.builder()
                        .id(2345L)
                        .productName("productName2")
                        .licenseSeat("jjjj")
                        .organization(myOrganization)
                        .build());

        PRETEND_THIS_IS_A_DATABASE.add(
                License.builder()
                        .id(3456L)
                        .productName("productName1")
                        .licenseSeat("qqq")
                        .organization(
                                Organization.builder()
                                        .id(1000L)
                                        .name("Organization #2")
                                        .contact(
                                                OrganizationContact.builder()
                                                        .id(2001L)
                                                        .organizationID(1001L)
                                                        .contactName("Jenny TuTone")
                                                        .contactEmail("invalid@doesitwork.no")
                                                        .contactPhone("+1 888 867 5309")
                                                        .build()
                                        )
                                        .build()
                        )
                        .build());

        PRETEND_THIS_IS_A_DATABASE.add(
                License.builder()
                        .id(4567L)
                        .productName("productName3")
                        .licenseSeat("hhh")
                        .organization(
                                Organization.builder()
                                        .id(1001L)
                                        .name("Another Org")
                                        .contact(
                                                OrganizationContact.builder()
                                                        .id(2003L)
                                                        .organizationID(1001L)
                                                        .contactName("Rodney Anonymous")
                                                        .contactEmail("dead@milkm.en")
                                                        .build()
                                        )
                                        .build()
                        )
                        .build());
    }


    public List<License> getLicensesForOrganziation(Long organizationID) {
        List<License> licensesForOrg = new ArrayList<>();

        PRETEND_THIS_IS_A_DATABASE.forEach((license) -> {
            if (license.getOrganization().getId().equals(organizationID)) {
                licensesForOrg.add(license);
            }
        });

        return licensesForOrg;
    }

    public License getLicense(Long organizationID, Long licenseID) {

        for (License license : PRETEND_THIS_IS_A_DATABASE) {
            if ((license.getOrganization().getId().equals(organizationID)) &&
                    (license.getId().equals(licenseID))) {

                return license;
            }
        }

        return null;
    }
}
