package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.Employee;
import com.vtan.salesapp.salesapp.entity.Employee1;
import com.vtan.salesapp.salesapp.entity.EmployeeType;
import com.vtan.salesapp.salesapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value={"/apiEmployee"},method = RequestMethod.GET)
public class EmployeeViewRestController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private GenderService genderService;
    @Autowired
    private DesignationService designationService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private HighestEducationalQualificationService highestEducationalQualificationService;
    @Autowired
    private HighestVocationalQualificationService highestVocationalQualificationService;
    @Autowired
    private CivilStatusService civilStatusService;
    @Autowired
    private EmployeeTypeService employeeTypeService;

    @RequestMapping(value={"/getAllEmployee"},method = RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        return employeeService.findByStatus(true);
    }

    @RequestMapping(value={"/getFilterEmployee/{heq}/{hvq}/{employetype}/{department}/{designation}/{civil}/{gender}/{status}"},method = RequestMethod.GET)
    public List<Employee1> getFilterEmployee(@PathVariable String heq, @PathVariable String hvq, @PathVariable String employetype,
                                             @PathVariable String department, @PathVariable String designation,
                                             @PathVariable String civil, @PathVariable String gender, @PathVariable String status){
        String stringQuery="SELECT * FROM Employee WHERE status = :status";

        if(!heq.isEmpty() && !heq.equals("0")){
            stringQuery+=" AND highset_educational_qualification_id= :heq";
        }

        if(!hvq.isEmpty() && !hvq.equals("0")){
            stringQuery+=" AND highset_vocational_qualification_id= :hvq";
        }

        if(!employetype.isEmpty() && !employetype.equals("0")){
            stringQuery+=" AND employee_type_id = :employeeType";
        }

        if(!department.isEmpty() && !department.equals("0")){
            stringQuery+=" AND department_id= :department";
        }

        if(!designation.isEmpty() && !designation.equals("0")){
            stringQuery+=" AND desination_id= :designation";
        }

        if(!civil.isEmpty() && !civil.equals("0")){
            stringQuery+=" AND civil_status_id= :civil";
        }

        if(!gender.isEmpty() && !gender.equals("0")){
            stringQuery+=" AND gender_id= :gender";
        }

        Query query = (Query) entityManager.createNativeQuery(stringQuery, Employee1.class);

        boolean statusLine=true;
        if(!status.isEmpty() && status.equals("0")){
            statusLine=false;
        }
        query.setParameter("status",statusLine);

        if(stringQuery.contains("highset_educational_qualification_id")){
            query.setParameter("heq",highestEducationalQualificationService.findById(Integer.parseInt(heq)));
        }

        if(stringQuery.contains("highset_vocational_qualification_id")){
            query.setParameter("hvq",highestVocationalQualificationService.findById(Integer.parseInt(hvq)));
        }

        if(stringQuery.contains("employee_type_id")){
            query.setParameter("employeeType",employeeTypeService.findById(Integer.parseInt(employetype)));
        }

        if(stringQuery.contains("department_id")){
            query.setParameter("department",departmentService.findById(Integer.parseInt(department)));
        }

        if(stringQuery.contains("desination_id")){
            query.setParameter("designation",designationService.findById(Integer.parseInt(designation)));
        }

        if(stringQuery.contains("civil_status_id")){
            query.setParameter("civil",civilStatusService.findById(Integer.parseInt(civil)));
        }

        if(stringQuery.contains("gender_id")){
            query.setParameter("gender",genderService.findById(Integer.parseInt(gender)));
        }


        List<Employee1> accList = new ArrayList();

        try{
            if(query.getResultList()!=null)
                accList=query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }

        return accList;
    }

}
