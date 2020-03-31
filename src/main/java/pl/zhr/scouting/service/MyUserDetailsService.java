//package pl.zhr.scouting.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import pl.zhr.scouting.entity.MyUserDetails;
//import pl.zhr.scouting.entity.User;
//import pl.zhr.scouting.repository.UserRepository;
//
//import java.util.Optional;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    UserRepository userRepositoryImpl;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Optional<User> tempUser = userRepositoryImpl.findByUsername(username);
//        tempUser.orElseThrow(() -> new UsernameNotFoundException("Not found " + username));
//
//        return tempUser.map(MyUserDetails::new).get();
//    }
//}
//
