package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.City;
import lmsbackendapp.backend.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepo;

    public Iterable<City> getCity(){
        return cityRepo.findAll();
    }
    public Optional<City> getCityById(long id){
        return  cityRepo.findById(id);
    }
    public void addCity(City city){
        cityRepo.save(city);
    }
    public void  editCity(Long id,City city){
        Optional<City> edtCity = cityRepo.findById(id);
        if(edtCity.isPresent()){
            city.setId(edtCity.get().getId());
            cityRepo.save(city);
        }
    }
    public void deleteCity(Long id){
        Optional<City> delCity = cityRepo.findById(id);
        if(delCity.isPresent()){
            cityRepo.delete(delCity.get());
        }
    }
}
