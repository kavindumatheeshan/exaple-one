package Controller;

import Repositories.DepartmentRepository;
import Repositories.EmployeeRepository;
import com.example.demo.Department;
import com.example.demo.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentRepository depReo;
    private final EmployeeRepository empreo;

    public DepartmentController(DepartmentRepository depReo,EmployeeRepository empreo)
    {
        this.depReo=depReo;
        this.empreo=empreo;
    }
    @PostMapping
    public Department create(@RequestBody Department department){
        return depReo.save(department);
    }
    @GetMapping
    public List<Department> getAll()
    {
        return depReo.findAll();
    }

    @GetMapping("/{id}/employee")
    public List<Employee> getEmployeesByDepartment(@PathVariable Long id)
    {
        return empreo.findByDepartment(id);
    }

}
