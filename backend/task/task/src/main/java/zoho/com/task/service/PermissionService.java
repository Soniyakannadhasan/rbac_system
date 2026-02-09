package zoho.com.task.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoho.com.task.model.Permission;
import zoho.com.task.repository.PermissionRepository;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepo;

    public List<String> getViewableFields(Long roleId,String table){

        List<Permission> permissions =
                permissionRepo.findByRoleIdAndTableName(roleId,table);

        return permissions.stream()
                .filter(Permission::isCanView)
                .map(Permission::getFieldName)
                .toList();
    }
}
