package Controller;

import Repositories.DepartmentRepository;
import Repositories.EmployeeRepository;
import com.example.demo.Department;
import com.example.demo.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")

public class EmployeeControler {
    private final EmployeeRepository empReo;
    private final DepartmentRepository depReo;

    public EmployeeControler(EmployeeRepository empReo,DepartmentRepository depReo)
    {
        this.empReo=empReo;
        this.depReo=depReo;
    }

    @PostMapping("/department/{depId}")
    public Employee create(@PathVariable long depid, @RequestBody Employee employee)
    {
        Department dept =depReo.findById(depid).orElseThrow(()-> new RuntimeException("Department not found "));
        employee.setDepartment(dept);
        return empReo.save(employee);
    }
    @GetMapping
    public List<Employee> getAll()
    {
        return empReo.findAll();
    }

    @GetMapping("/{id}")
    public Employee update(@PathVariable long id,@RequestBody Employee details)
    {
        Employee emp=empReo.findById(id).orElseThrow(()-> new RuntimeException("employee not found "));
        emp.setEname(details.getEname());
        emp.setEmail(details.getEmail());
        emp.setTel(details.getTel());
        return empReo.save(emp);
    }
    @DeleteMapping("{/id}")
    public String delete(@PathVariable Long id ){
        empReo.deleteById(id);
        return "Deleted employee id:"+id;
    }
}
