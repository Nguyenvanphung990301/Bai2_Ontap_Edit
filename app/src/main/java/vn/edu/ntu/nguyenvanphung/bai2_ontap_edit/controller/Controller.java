package vn.edu.ntu.nguyenvanphung.bai2_ontap_edit.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.nguyenvanphung.bai2_ontap_edit.model.contact;

public class Controller extends Application implements IController {
    List<contact> contactList = new ArrayList<>();

    public Controller() {
        contactList.add(new contact(1,"Phùng","1/3/199","0387968865","Phú Yên"));
    }

    @Override
    public List<contact> GetAllThongTin() {
        return contactList;
    }

    @Override
    public void editThongTin(int id, contact contact) {
        for(contact p:contactList){
            if(p.getId() == id){
                p.setId(contact.getId());
                p.setTen(contact.getTen());
                p.setNgaySinh(contact.getNgaySinh());
                p.setSodienthoai(contact.getSodienthoai());
                p.setDiaChi(contact.getDiaChi());
            }
        }

    }
}
