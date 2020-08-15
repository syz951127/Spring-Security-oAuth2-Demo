package com.suyz.oauth2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * tb_user_role
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbUserRole implements Serializable {
    private Long id;

    /**
     * 用户 ID
     */
    private Long userId;

    /**
     * 角色 ID
     */
    private Long roleId;

    private static final long serialVersionUID = 1L;
}