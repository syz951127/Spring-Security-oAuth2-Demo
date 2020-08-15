package com.suyz.resource.mapper;

import com.suyz.resource.model.TbUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TbUserMapper extends Mapper<TbUser> {
}