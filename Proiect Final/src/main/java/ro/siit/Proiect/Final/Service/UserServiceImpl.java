package ro.siit.Proiect.Final.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.siit.Proiect.Final.Model.User;
import ro.siit.Proiect.Final.Model.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired //pentru a instantia singur
            UserRepository userRepository;

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void saveUser (User users) {

        users.setPassword(encrytePassword(users.getPassword()));
        userRepository.save(users);
    }

    public User searchIfUserExist(String user){
        return userRepository.findUserByUsername(user);

//        List<User> usersList = userRepository.searchUser(user);
//
//        if (usersList != null && !usersList.isEmpty()){
//            System.out.println("usersList.get(0)--------"+usersList.get(0).getUsername());
//            return usersList.get(0);
//        }
//
//        else {
//            System.out.println("usersList.get(0)------nullll--");
//
//            return null;
//        }
    }
    // Encryte Password with BCryptPasswordEncoder
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}