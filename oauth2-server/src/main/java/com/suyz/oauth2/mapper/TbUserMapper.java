package com.suyz.oauth2.mapper;

import com.suyz.oauth2.model.TbUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TbUserMapper extends Mapper<TbUser> {
}