package models;

import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name= "user_role")
public class UserRole {

    @Id
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    public enum userRoleEnum
    {
        ADMIN(1),CUSTOMER(2);

        private Integer roleId;

        public Integer getRoleId() {
            return this.roleId;
        }

        userRoleEnum(Integer roleId)
        {
            this.roleId =roleId;
        }
    }

    public static UserRole getInstance(Integer roleId)
    {
        UserRole userRole=new UserRole();
        userRole.setId(roleId);
        return userRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public static final Finder<Integer, UserRole> find = new Finder<>(UserRole.class);


}
