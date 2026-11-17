package Repositories;


import com.example.demo.Department;
import org.springframework.stereotype.Repository;
import java.util.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class DepartmentRepository {
    private final Map<Long,Department> store =new ConcurrentHashMap<>();
    private final AtomicLong idGenerator= new AtomicLong(1);

    public Department save(Department department)

    {
        if(department.getid()==null)
        {
            department.setid(idGenerator.getAndIncrement());
        }
        store.put(department.getid(),department);
        return department;

    }
    public List<Department> findAll()
    {
        return new ArrayList<>(store.values());

    }
    public Optional<Department> findById(Long id)
    {
        return Optional.ofNullable(store.get(id));
    }

}
