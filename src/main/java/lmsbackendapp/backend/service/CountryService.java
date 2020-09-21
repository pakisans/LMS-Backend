package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Country;
import lmsbackendapp.backend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepo;
    public Iterable<Country> getCountry(){
        return countryRepo.findAll();
    }
    public Optional<Country> getCountryById(Long id){
        return countryRepo.findById(id);
    }
    public void addCountry(Country country){
        countryRepo.save(country);
    }
    public void editCountry(Long id,Country country){
        Optional<Country> edtCountry = countryRepo.findById(id);
        if(edtCountry.isPresent()){
            country.setId(edtCountry.get().getId());
            countryRepo.save(country);
        }
    }
    public void deleteCountry(Long id){
        Optional<Country> delCntry = countryRepo.findById(id);
        if (delCntry.isPresent()){
            countryRepo.delete(delCntry.get());
        }
    }
}
