package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lmsbackendapp.backend.model.Address;
import lmsbackendapp.backend.service.AddressService;
import lmsbackendapp.backend.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService adrsSrvc;

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Address>> getAddress() {
        return new ResponseEntity<Iterable<Address>>(adrsSrvc.getAddress(), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> address = adrsSrvc.getAddressById(id);
        if(address.isPresent()) {
            return new ResponseEntity<Address>(address.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        adrsSrvc.addAddress(address);
        return new ResponseEntity<Address>(address, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Address> editAddress(@PathVariable Long id, @RequestBody Address address) {
        adrsSrvc.editAddress(id, address);
        return new ResponseEntity<Address>(address, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Address> deleteAddress(@PathVariable Long id) {
        try {
            adrsSrvc.deleteAddress(id);
        }catch (Exception e) {
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
    }
}
