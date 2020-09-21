package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Address;
import lmsbackendapp.backend.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository adrsRepo;

    public Iterable<Address> getAddress(){
        return adrsRepo.findAll();
    }
    public Optional<Address> getAddressById(Long id){
        return adrsRepo.findById(id);
    }
    public void addAddress(Address address){
        adrsRepo.save(address);
    }
    public void editAddress(Long id,Address address){
        Optional<Address> address1 = adrsRepo.findById(id);
        if(address1.isPresent()){
            address.setId(address1.get().getId());
            adrsRepo.save(address);
        }
    }
    public void deleteAddress(Long id){
        Optional<Address> address = adrsRepo.findById(id);
        if(address.isPresent()){
            adrsRepo.delete(address.get());
        }
    }
}
