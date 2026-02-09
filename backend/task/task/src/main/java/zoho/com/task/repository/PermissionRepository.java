package zoho.com.task.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import zoho.com.task.model.Permission;

public interface PermissionRepository
        extends JpaRepository<Permission,Long>{

    List<Permission> findByRoleIdAndTableName(Long roleId,String tableName);
}
