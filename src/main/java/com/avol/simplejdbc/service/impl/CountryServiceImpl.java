package com.avol.simplejdbc.service.impl;

import com.avol.simplejdbc.domains.Country;
import com.avol.simplejdbc.repository.CountryRepository;
import com.avol.simplejdbc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lovababu on 7/3/2015.
 */

@Service
public class CountryServiceImpl  implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void insertCountry() {
        countryRepository.insertCountry();
    }

    @Override
    public List<Country> countries() {
        return countryRepository.countries();
    }
}
