package com.suyz.resource.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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