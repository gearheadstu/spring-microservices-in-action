package org.kellyjones.books.smia.licenses.services;

import org.kellyjones.books.smia.licenses.domain.License;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LicenseService {

    private static final List<License> PRETEND_THIS_IS_A_DATABASE = new ArrayList<>();

    static {
        PRETEND_THIS_IS_A_DATABASE.add(
                License.builder()
                        .licenseID("license1234")
                        .productName("productName1")
                        .licenseSeat("fff")
                        .organizationID("org01")
                        .build());

        PRETEND_THIS_IS_A_DATABASE.add(
                License.builder()
                        .licenseID("license2345")
                        .productName("productName2")
                        .licenseSeat("jjjj")
                        .organizationID("org01")
                        .build());

        PRETEND_THIS_IS_A_DATABASE.add(
                License.builder()
                        .licenseID("license3456")
                        .productName("productName1")
                        .licenseSeat("qqq")
                        .organizationID("org02")
                        .build());

        PRETEND_THIS_IS_A_DATABASE.add(
                License.builder()
                        .licenseID("license4567")
                        .productName("productName3")
                        .licenseSeat("hhh")
                        .organizationID("org03")
                        .build());
    }


    public List<License> getLicensesForOrganziation(String organizationID) {
        List<License> licensesForOrg = new ArrayList<>();

        PRETEND_THIS_IS_A_DATABASE.stream().forEach((license) -> {
            if (license.getOrganizationID().equals(organizationID)) {
                licensesForOrg.add(license);
            }
        });

        return licensesForOrg;
    }

    public License getLicense(String organizationID, String licenseID) {

        for (License license : PRETEND_THIS_IS_A_DATABASE) {
            if ((license.getOrganizationID().equals(organizationID)) &&
                    (license.getLicenseID().equals(licenseID))) {

                return license;
            }
        }

        return null;
    }
}
