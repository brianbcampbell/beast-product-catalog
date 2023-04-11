//package beast.cart.util;
//
//import beast.cart.models.UserDetails;
//import beast.cart.user.SignupService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Collection;
//
//@Component
//public class LoadSampleData {
//
//    private final ObjectMapper mapper;
//    private SignupService signupService;
//
//    @Autowired
//    public LoadSampleData(
//            ObjectMapper mapper,
//            SignupService signupService
//    ) {
//        this.mapper = mapper;
//        this.signupService = signupService;
//    }
//
//    @PostConstruct
//    private void loadSampleData() {
//
//        // USERS
//        ClassPathResource users = new ClassPathResource("sampledata/users.json");
//        UserDetails[] bah = mapper.readValue(users.getFile(), UserDetails[].class);
//        Arrays.stream(bah).forEach(userDetails -> {
//            try {
//                signupService.signup(userDetails);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        // PRODUCTS
//        ClassPathResource jsonFile = new ClassPathResource("sampledata/users.json");
//        UserDetails[] bah = mapper.readValue(jsonFile.getFile(), UserDetails[].class);
//        Arrays.stream(bah).forEach(userDetails -> {
//            try {
//                signupService.signup(userDetails);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//
//    }
//}
