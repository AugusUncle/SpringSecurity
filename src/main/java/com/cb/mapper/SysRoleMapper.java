package com.cb.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import com.cb.domain.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author cuibing
* @description 针对表【sys_role(角色信息表)】的数据库操作Mapper
* @createDate 2024-06-21 14:48:18
* @Entity com.cb.domain.SysRole
*/
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> findAllByIdIn(@Param("idList") Collection<Long> idList);

}




