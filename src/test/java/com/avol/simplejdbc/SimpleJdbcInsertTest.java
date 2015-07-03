package com.avol.simplejdbc;

import com.avol.simplejdbc.config.AppConfig;
import com.avol.simplejdbc.domains.Country;
import com.avol.simplejdbc.service.CountryService;
import jdk.internal.dynalink.linker.LinkerServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Lovababu on 7/3/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SimpleJdbcInsertTest {

    @Autowired
    private CountryService countryService;

    @Test
    public void testInsert() {
        countryService.insertCountry();

        List<Country> countries = countryService.countries();

        assertNotNull(countries);

        System.out.println("*************** Countries List *************");
        System.out.println("ID       | NAME           | CODE     ");
        System.out.println("--------------------------------------");
        countries.stream().forEach(country -> print(country));
    }

    private void print(Country country) {
        System.out.println(country.getId() + "    |   "  + country.getName() + "     |       " + country.getCode());
    }

}
