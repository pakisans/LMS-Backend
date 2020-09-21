package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.RegUser;
import lmsbackendapp.backend.model.UserPermission;
import lmsbackendapp.backend.repository.RegUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    RegUserRepository regUserRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<RegUser> user = regUserRepo.findByUsername(username);

        if (user.isPresent()){
            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            for(UserPermission up:user.get().getUserPermission()){
                authorities.add(new SimpleGrantedAuthority(up.getPermission().getName()));

            }return new User(user.get().getUsername(),user.get().getPassword(),authorities);
        }else {
        return null;}
    }
}
