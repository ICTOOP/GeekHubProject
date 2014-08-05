/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fitnessmember;

import Fitnessmember.entities.Addmember;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Owner
 */
public class MemberTableModel extends AbstractTableModel{

    List<Addmember> members;
    String []columNames = {"Id","First Name","Last Name","Address","Phone","Gender"};

    public List<Addmember> getMembers() {
        return members;
    }

    public void setMembers(List<Addmember> members) {
        this.members = members;
    }

    @Override
    public String getColumnName(int i) {
        return columNames[i];
    }
    
    
    
    @Override
    public int getRowCount() {
        return members.size();
    }

    @Override
    public int getColumnCount() {
        return columNames.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Addmember a = members.get(i);
        switch(i1){
            case 0 : return a.getId();
            case 1 : return a.getFirstname();
            case 2 : return a.getLastname();
            case 3 : return a.getAddress();
            case 4 : return a.getPhone();
            case 5 : return a.getGander(); 
                
            default : return "testtesttestest";
        }
    }
    
    
    
}
