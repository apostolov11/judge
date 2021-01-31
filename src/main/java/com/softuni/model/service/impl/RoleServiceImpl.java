package com.softuni.model.service.impl;

import com.softuni.model.entity.Role;
import com.softuni.model.entity.RoleNameEnum;
import com.softuni.model.repository.RoleRepository;
import com.softuni.model.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if (roleRepository.count() == 0) {
            Role admin = new Role(RoleNameEnum.ADMIN);
            Role user = new Role(RoleNameEnum.USER);

            roleRepository.save(admin);
            roleRepository.save(user);
        }
    }
}
