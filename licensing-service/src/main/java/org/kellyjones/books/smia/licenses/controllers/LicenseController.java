package org.kellyjones.books.smia.licenses.controllers;

import org.kellyjones.books.smia.licenses.domain.License;
import org.kellyjones.books.smia.licenses.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/organizations/{organizationID}/licenses")
public class LicenseController {

    private LicenseService licenseService;

    @Autowired
    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping
    public List<License> getLicensesForOrganization(@PathVariable(value = "organizationID") Long organizationID) {
        // FIXME: Integrate HTTP 404 for invalid input
        return licenseService.getLicensesForOrganziation(organizationID);
    }

    @GetMapping(value = "/license/{licenseID}")
    public License getLicenseByOrgAndID(
            @PathVariable(value = "organizationID") Long organizationID,
            @PathVariable(value = "licenseID") Long licenseID) {

        // FIXME: Integrate HTTP 404 for invalid input
        return this.licenseService.getLicense(organizationID, licenseID);
    }

}
