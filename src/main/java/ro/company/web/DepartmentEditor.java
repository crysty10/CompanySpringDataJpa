package ro.company.web;

import ro.company.domain.Department;

import java.beans.PropertyEditorSupport;

public class DepartmentEditor extends PropertyEditorSupport
{
    //This will be called when user HTTP Post to server a field bound to DepartmentVO
    @Override
    public void setAsText(String id)
    {
        Department department;
        switch(Integer.parseInt(id))
        {
            case 1: department = new Department("CTI"); break;
            case 2: department = new Department("IS"); break;
            case 3: department = new Department("ACS"); break;
            default: department = null;
        }
        this.setValue(department);
    }
}
