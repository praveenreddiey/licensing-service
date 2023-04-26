package com.optimagrowth.license;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseService {
    private final MessageSource messageSource;

    public LicenseService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    public License getLicense(String licenseId, String organizationId){
        return License.builder()
                .id(new Random().nextInt(100))
                .licenseId(licenseId)
                .licenseType("full")
                .organizationId(organizationId)
                .description("software product")
                .productId("Ostock").build();
    }
    public String createLicense(License license, String organizationId, Locale locale){
        String responseMessage = null;
        if(license!=null){
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messageSource.getMessage("license.create.message",null,locale),license.toString());
        }
        return responseMessage;
    }
    public String updateLicense(License license, String organizationId, Locale locale){
        String responseMessage = null;
        if(license!=null){
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messageSource.getMessage("license.update.message",null,locale), license.toString());
        }
        return responseMessage;
    }
    public String deleteLicense(String license, String organizationId){
        String responseMessage = null;
        if(license!=null){
            responseMessage = String.format(messageSource.getMessage("license.delete.message",null,null), license,organizationId);
        }
        return responseMessage;
    }
}
