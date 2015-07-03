package com.avol.simplejdbc.service;

import com.avol.simplejdbc.domains.Country;

import java.util.List;

/**
 * Created by Lovababu on 7/3/2015.
 */
public interface CountryService {

    void insertCountry();

    List<Country> countries();
}
