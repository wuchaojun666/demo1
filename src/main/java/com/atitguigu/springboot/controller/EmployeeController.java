package com.atitguigu.springboot.controller;

import com.atitguigu.springboot.dao.DepartmentDao;
import com.atitguigu.springboot.dao.EmployeeDao;
import com.atitguigu.springboot.entities.Department;
import com.atitguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author 研发部吴超军
 * @version 1.0
 * @date 2019/7/10 8:56
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    //到添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        //来到员工列表页面
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(Model model, @PathVariable("id") Integer id) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}