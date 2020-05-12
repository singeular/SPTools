package com.tools.module.sys.service;

import com.tools.common.model.Result;
import com.tools.module.sys.entity.SysUser;

import java.util.List;

public interface SysUserService {

    Result save(SysUser user);

    Result get(Long userId);

    Result delete(Long userId);

    SysUser getUser(String username);

    Result list(SysUser user);

    List<String> listUserRoles(Long userId);

    List<String> listUserPerms(Long userId);

    Result updatePwd(SysUser user);
}
