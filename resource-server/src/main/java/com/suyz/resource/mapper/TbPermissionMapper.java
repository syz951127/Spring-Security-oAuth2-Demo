package com.suyz.resource.mapper;

import com.suyz.resource.model.TbPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TbPermissionMapper extends Mapper<TbPermission> {

    List<TbPermission> selectPermissionByUserId(@Param("userId") Integer userId);
}