package com.suyz.oauth2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * tb_role_permission
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbRolePermission implements Serializable {
    private Long id;

    /**
     * 角色 ID
     */
    private Long roleId;

    /**
     * 权限 ID
     */
    private Long permissionId;

    private static final long serialVersionUID = 1L;
}