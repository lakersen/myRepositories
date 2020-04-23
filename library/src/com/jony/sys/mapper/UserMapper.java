package com.jony.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jony.sys.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //��¼
    User login(User user);
    /*
     * ��ѯ�û�
     */
    List<User> queryAllUser(User user);
    
    /*
     * �����û��ͽ�ɫ�Ĺ�ϵ
     */
    void insertUserRole(@Param("uid")Integer userid,@Param("rid")Integer rid);
}