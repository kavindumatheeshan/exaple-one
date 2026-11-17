package Repositories;

import com.example.demo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EmployeeRepository {
    private final Map<Long, Employee> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Employee save(Employee employee)
    {
        if(employee.getEmpId()==null)
        {
            employee.setEmpId(idGenerator.getAndIncrement());
        }
        store.put(employee.getEmpId(),employee);
        return employee;
    }

    public List<Employee> findAll()
    {
        return new ArrayList<>(store.values());
    }
    public Optional<Employee> findById(Long id)
    {
        return Optional.ofNullable(store.get(id));
    }
    public void deleteById(Long id){
        store.remove(id);
    }
    public List<Employee>findByDepartment(Long depId)
    {
        return store.values().stream().filter(emp -> emp.getDepartment()!=null && emp.getDepartment().getid().equals(depId)).toList();
    }
}
