package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.NoDataFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.PersonNotFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.RoleNotAllowedForCreationException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.RoleNotFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.UserAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.UserNotFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IRoleRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.pragma.powerup.usermicroservice.configuration.Constants.*;

@RequiredArgsConstructor
@Transactional
public class UserMysqlAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final IUserEntityMapper userEntityMapper;
    @Override
    public void saveUser(User user) {
        if (user.getRole().getId().equals(PROVIDER_ROLE_ID))
        {
            throw new RoleNotAllowedForCreationException();
        }


        roleRepository.findById(user.getRole().getId()).orElseThrow(RoleNotFoundException::new);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public void deleteUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            userRepository.delete(userEntityMapper.toEntity(user));
         }
        else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<User> getAllProviders(int page) {
        Pageable pagination = PageRequest.of(page, MAX_PAGE_SIZE);
       /*
        List<UserEntity> userEntityList = userRepository.findAllByRoleEntityId(PROVIDER_ROLE_ID, pagination);

        if (userEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return userEntityMapper.toUserList(userEntityList);

        */

        return null;
    }

    @Override
    public User getProvider(String email) {
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public User getEmployee(String email) {
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);

        if(userEntity.getRoleEntity().getId()!=2l){

            throw new UserNotFoundException(" The id not is Employee");
        }
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public User getClient(String email) {
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);

        if(userEntity.getRoleEntity().getId()!=1l){

            throw new UserNotFoundException(" The id not is Client");
        }
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public User getOwner(String email) {

        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);

        if(userEntity.getRoleEntity().getId()!=4l){

           throw new UserNotFoundException(" The id not is Owner");
        }
        return userEntityMapper.toUser(userEntity);
    }
}
