package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.RegUser;
import lmsbackendapp.backend.model.UserPermission;
import lmsbackendapp.backend.repository.PermissionRepository;
import lmsbackendapp.backend.repository.RegUserRepository;
import lmsbackendapp.backend.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;

@Service
public class LoginService {
    @Autowired
    RegUserService regUserSrvc;
    @Autowired
    RegUserRepository regUserRepo;
    @Autowired
    PermissionRepository permissionRepo;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private TokenUtils tokenUtils;

    public ResponseEntity<HashMap<String, String>> login(RegUser regUser) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(regUser.getUsername(),
                    regUser.getPassword());

            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails details = userDetailsService.loadUserByUsername(regUser.getUsername());
            String userToken = tokenUtils.generateToken(details);

            HashMap<String, String> data = new HashMap<String, String>();
            data.put("token", userToken);

            return new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK);
        }
        catch (InternalAuthenticationServiceException e) {
            System.out.println("Auth error");
            return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
        }
        catch (UsernameNotFoundException e) {
            return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
        }
    }
    public void addPermission(RegUser regUser,String role){
        regUser = regUserRepo.save(regUser);
        regUser.setUserPermission(new HashSet<UserPermission>());
        regUser.getUserPermission().add(new UserPermission(regUser,permissionRepo.getByName(role).get()));
        regUserRepo.save(regUser);
    }
}
