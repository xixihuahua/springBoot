package com.test.web.controller;

import com.test.web.dao.DepartmentDao;
import com.test.web.dao.EmployeeDao;
import com.test.web.entities.Department;
import com.test.web.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * description
 *
 * @author 24360 2019/08/29 11:16
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao ;

    /**
     * 查询所有员工
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //将查询到的信息存储在请求域中
        model.addAttribute("emps" , employees) ;
        return "emp/list" ;
    }

    /**
     * 跳转至添加页面
     * @return
     */
    @GetMapping("/emp")
    public String addEmp(Model model){
        //查找所有department
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts" , departments) ;
        return "emp/add" ;
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public  String add(Employee employee){
        employeeDao.save(employee);
        // redirect : 重定向
        // forward : 转发
        return "redirect:/emps" ;
    }

    /**
     * 跳转至员工修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String goEdit(@PathVariable("id") Integer id ,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp" , employee) ;
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts" , departments) ;
        return "emp/add";
    }

    /**
     * 修改员工信息
     * @param employee
     * @param model
     * @return
     */
    @PutMapping("/emp")
    public String goEdit(Employee employee,Model model){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String goEdit(@PathVariable("id") Integer id ){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
