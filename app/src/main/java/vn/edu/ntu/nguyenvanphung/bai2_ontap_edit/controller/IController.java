package vn.edu.ntu.nguyenvanphung.bai2_ontap_edit.controller;

import java.util.List;

import vn.edu.ntu.nguyenvanphung.bai2_ontap_edit.model.contact;

public interface IController {
    public List<contact> GetAllThongTin();
    public void editThongTin(int id ,contact contact);
}
