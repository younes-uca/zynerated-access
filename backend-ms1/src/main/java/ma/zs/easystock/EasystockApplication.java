package ma.zs.easystock;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;
import com.fasterxml.jackson.databind.SerializationFeature;


import ma.zs.easystock.zynerator.security.common.AuthoritiesConstants;
import ma.zs.easystock.zynerator.security.bean.User;
import ma.zs.easystock.zynerator.security.bean.Permission;
import ma.zs.easystock.zynerator.security.bean.Role;
import ma.zs.easystock.zynerator.security.service.facade.UserService;
import ma.zs.easystock.zynerator.security.service.facade.RoleService;

//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableElasticsearchRepositories("ma.zs.easystock.dao")
//@EnableFeignClients("ma.zs.easystock.required.facade")
public class EasystockApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(EasystockApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){



    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }




    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("PaiementAchat.edit"));
        permissions.add(new Permission("PaiementAchat.list"));
        permissions.add(new Permission("PaiementAchat.view"));
        permissions.add(new Permission("PaiementAchat.add"));
        permissions.add(new Permission("PaiementAchat.delete"));
        permissions.add(new Permission("CategorieProduit.edit"));
        permissions.add(new Permission("CategorieProduit.list"));
        permissions.add(new Permission("CategorieProduit.view"));
        permissions.add(new Permission("CategorieProduit.add"));
        permissions.add(new Permission("CategorieProduit.delete"));
        permissions.add(new Permission("Produit.edit"));
        permissions.add(new Permission("Produit.list"));
        permissions.add(new Permission("Produit.view"));
        permissions.add(new Permission("Produit.add"));
        permissions.add(new Permission("Produit.delete"));
        permissions.add(new Permission("ModelPermission.edit"));
        permissions.add(new Permission("ModelPermission.list"));
        permissions.add(new Permission("ModelPermission.view"));
        permissions.add(new Permission("ModelPermission.add"));
        permissions.add(new Permission("ModelPermission.delete"));
        permissions.add(new Permission("Achat.edit"));
        permissions.add(new Permission("Achat.list"));
        permissions.add(new Permission("Achat.view"));
        permissions.add(new Permission("Achat.add"));
        permissions.add(new Permission("Achat.delete"));
        permissions.add(new Permission("Client.edit"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.add"));
        permissions.add(new Permission("Client.delete"));
        permissions.add(new Permission("Permission.edit"));
        permissions.add(new Permission("Permission.list"));
        permissions.add(new Permission("Permission.view"));
        permissions.add(new Permission("Permission.add"));
        permissions.add(new Permission("Permission.delete"));
        permissions.add(new Permission("AchatItem.edit"));
        permissions.add(new Permission("AchatItem.list"));
        permissions.add(new Permission("AchatItem.view"));
        permissions.add(new Permission("AchatItem.add"));
        permissions.add(new Permission("AchatItem.delete"));
        permissions.add(new Permission("ActionPermission.edit"));
        permissions.add(new Permission("ActionPermission.list"));
        permissions.add(new Permission("ActionPermission.view"));
        permissions.add(new Permission("ActionPermission.add"));
        permissions.add(new Permission("ActionPermission.delete"));
    }

}


