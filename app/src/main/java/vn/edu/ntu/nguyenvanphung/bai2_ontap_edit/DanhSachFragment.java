package vn.edu.ntu.nguyenvanphung.bai2_ontap_edit;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.ntu.nguyenvanphung.bai2_ontap_edit.controller.IController;
import vn.edu.ntu.nguyenvanphung.bai2_ontap_edit.model.contact;

public class DanhSachFragment extends Fragment {
    NavController navController;
    IController controller;
    List<contact> contactList;
    Bundle data = new Bundle();
    private RecyclerView mRcView;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        navController = NavHostFragment.findNavController(this);
        ((MainActivity) getActivity()).navController = navController;
        controller = ((MainActivity) getActivity()).controller;
    }


    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_danhsach, container, false);

        addView(view);
        addEvent();
        addData();
        return view;
    }

    private void addView(View view) {
        mRcView = view.findViewById(R.id.rcView);

    }

    private void addEvent() {

    }

    private void addData() {
        contactList = controller.GetAllThongTin();
        mRcView.setLayoutManager(new LinearLayoutManager(DanhSachFragment.this.getActivity()));
        contactAdapter adapter = new contactAdapter();
        mRcView.setAdapter(adapter);


    }
    private class contactViewHolder extends RecyclerView.ViewHolder{
            TextView txtname,txtphone,txtbirth;
            ImageView imgedit;

        public contactViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtName);
            txtbirth = itemView.findViewById(R.id.txtBirth);
            txtphone = itemView.findViewById(R.id.txtPhone);
            imgedit = itemView.findViewById(R.id.imagEdit);
        }
        public void bind(contact p)
        {
            txtname.setText(p.getTen());
            txtbirth.setText(p.getNgaySinh());
            txtphone.setText(p.getSodienthoai());
        }
    }
    private  class contactAdapter extends RecyclerView.Adapter<contactViewHolder>{

        @NonNull
        @Override
        public DanhSachFragment.contactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.item_phone, parent, false);
            return new contactViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DanhSachFragment.contactViewHolder holder,final int position) {
                holder.bind(contactList.get(position));
                holder.imgedit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        data.putInt("id",contactList.get(position).getId());
                        data.putString("name",contactList.get(position).getTen());
                        data.putString("phone",contactList.get(position).getSodienthoai());
                        data.putString("birth",contactList.get(position).getNgaySinh());
                        data.putString("address",contactList.get(position).getDiaChi());
                        navController.navigate(R.id.action_danhSachFragment_to_editFragment,data);
                    }
                });

        }

        @Override
        public int getItemCount() {
            return contactList.size();
        }
    }


}