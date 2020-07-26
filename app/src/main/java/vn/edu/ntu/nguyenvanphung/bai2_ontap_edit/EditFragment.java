package vn.edu.ntu.nguyenvanphung.bai2_ontap_edit;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import vn.edu.ntu.nguyenvanphung.bai2_ontap_edit.controller.IController;
import vn.edu.ntu.nguyenvanphung.bai2_ontap_edit.model.contact;

public class EditFragment extends Fragment {

    contact contact;
    IController controller;
    int id;
    String name,birth,phone,address;
    private EditText mEdtId;
    private EditText mEdtName;
    private EditText mEdtBirth;
    private EditText mEdtPhone;
    private EditText mEdtAddress;
    private Button mBtnSave;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        controller = ((MainActivity) getActivity()).controller;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        Bundle data = getArguments();
        id = data.getInt("id");
        name = data.getString("name");
        phone = data.getString("phone");
        birth = data.getString("birth");
        address = data.getString("address");
        addView(view);
        addEvent();
        addData();
        return  view;
    }

    private void addData() {
        mEdtId.setText(String.valueOf(id));
        mEdtName.setText(name);
        mEdtPhone.setText(phone);
        mEdtBirth.setText(birth);
        mEdtAddress.setText(address);
    }

    private void addEvent() {
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contact = new contact(id, mEdtName.getText().toString(), mEdtBirth.getText().toString(),
                        mEdtPhone.getText().toString(),mEdtAddress.getText().toString());
                controller.editThongTin(id,contact);
                Toast.makeText(getActivity(), "Lưu thành công", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void addView(View view) {
        mEdtId = view.findViewById(R.id.edtId);
        mEdtName = view.findViewById(R.id.edtName);
        mEdtBirth = view.findViewById(R.id.edtBirth);
        mEdtPhone = view.findViewById(R.id.edtPhone);
        mEdtAddress = view.findViewById(R.id.edtAddress);
        mBtnSave = view.findViewById(R.id.btnSave);
    }
}