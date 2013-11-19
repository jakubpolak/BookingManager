package com.pa165.bookingmanager.module.admin.binder;

import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/**
 * @author Jakub Polak
 */
@Component
public class RoleDtoBinder extends PropertyEditorSupport
{
    @Autowired
    private RoleService roleService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAsText(String text){
        RoleDto roleDto = roleService.find(Long.valueOf(text));

        this.setValue(roleDto);
    }
}
