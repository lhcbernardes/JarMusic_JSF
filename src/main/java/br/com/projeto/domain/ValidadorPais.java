/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.domain;

/**
 *
 * @author leand
 */
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadorPais implements ConstraintValidator<ValidaPais, String> {
    private List<String> pais;
    
    @Override
    public void initialize(ValidaPais validadaPais) {
        this.pais = new ArrayList<>();
        this.pais.add("AHO");
        this.pais.add("ALB");
        this.pais.add("ALG");
        this.pais.add("AND");
        this.pais.add("ANG");
        this.pais.add("ANT");
        this.pais.add("ARG");
        this.pais.add("ARM");
        this.pais.add("ARU");
        this.pais.add("ASA");
        this.pais.add("AUS");
        this.pais.add("AUT");
        this.pais.add("AZE");
        this.pais.add("BAH");
        this.pais.add("BAN");
        this.pais.add("BEL");
        this.pais.add("BIH");
        this.pais.add("BOL");
        this.pais.add("BRA");
        this.pais.add("BUL");
        this.pais.add("CAM");
        this.pais.add("CAN");
        this.pais.add("CGO");
        this.pais.add("CHI");
        this.pais.add("CHN");
        this.pais.add("CIV");
        this.pais.add("CMR");
        this.pais.add("CPV");
        this.pais.add("CUB");
        this.pais.add("CZE");
        this.pais.add("DEN");
        this.pais.add("DMA");
        this.pais.add("DOM");
        this.pais.add("ECU");
        this.pais.add("EGY");
        this.pais.add("ESP");
        this.pais.add("ETH");
        this.pais.add("FIN");
        this.pais.add("FRA");
        this.pais.add("GAM");
        this.pais.add("GBR");
        this.pais.add("GEO");
        this.pais.add("GER");
        this.pais.add("GHA");
        this.pais.add("GRE");
        this.pais.add("GUA");
        this.pais.add("HAI");
        this.pais.add("HKG");
        this.pais.add("HUN");
        this.pais.add("INA");
        this.pais.add("IRI");
        this.pais.add("IRL");
        this.pais.add("ISR");
        this.pais.add("ITA");
        this.pais.add("JAM");
        this.pais.add("JPN");
        this.pais.add("KAZ");
        this.pais.add("KEN");
        this.pais.add("KGZ");
        this.pais.add("KOR");
        this.pais.add("KSA");
        this.pais.add("KUW");
        this.pais.add("LAT");
        this.pais.add("LTU");
        this.pais.add("LUX");
        this.pais.add("MAD");
        this.pais.add("MAR");
        this.pais.add("MAS");
        this.pais.add("MEX");
        this.pais.add("MGL");
        this.pais.add("MLT");
        this.pais.add("MON");
        this.pais.add("MOZ");
        this.pais.add("MTN");
        this.pais.add("NAM");
        this.pais.add("NED");
        this.pais.add("NEP");
        this.pais.add("NGR");
        this.pais.add("NOR");
        this.pais.add("NZL");
        this.pais.add("OMA");
        this.pais.add("PAK");
        this.pais.add("PAN");
        this.pais.add("PAR");
        this.pais.add("PER");
        this.pais.add("PHI");
        this.pais.add("PLE");
        this.pais.add("POL");
        this.pais.add("POR");
        this.pais.add("PRK");
        this.pais.add("PUR");
        this.pais.add("QAT");
        this.pais.add("ROM");
        this.pais.add("RSA");
        this.pais.add("RUS");
        this.pais.add("RWA");
        this.pais.add("SAM");
        this.pais.add("SEN");
        this.pais.add("SLE");
        this.pais.add("SLO");
        this.pais.add("SOL");
        this.pais.add("SOM");
        this.pais.add("SUD");
        this.pais.add("SWI");
        this.pais.add("SYR");
        this.pais.add("TAN");
        this.pais.add("TGA");
        this.pais.add("TUN");
        this.pais.add("TUR");
        this.pais.add("UAE");
        this.pais.add("UKR");
        this.pais.add("URU");
        this.pais.add("USA");
        this.pais.add("UZB");
        this.pais.add("VEN");
        this.pais.add("VIE");
        this.pais.add("YEM");
        this.pais.add("YUG");
        this.pais.add("ZAM");
        this.pais.add("ZIM");
    }

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext context) {
        return valor == null ? false : pais.contains(valor);
    }
    
}