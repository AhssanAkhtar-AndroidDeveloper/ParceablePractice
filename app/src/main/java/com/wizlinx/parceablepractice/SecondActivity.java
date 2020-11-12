package com.wizlinx.parceablepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.wizlinx.parceablepractice.databinding.ActivitySecondBinding;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;
    private List<UserData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        UserData user=getIntent().getParcelableExtra("data");
        list=getIntent().getParcelableArrayListExtra("list");
//        binding.tvName.setText(user.getName());
//        binding.tvEmail.setText(user.getEmail());
//        binding.tvAddress.setText(user.getAddress());
        Toast.makeText(this, ""+list.size(), Toast.LENGTH_SHORT).show();
        for(int i=0;i<list.size();i++)
        {
            binding.tvName.append("\nName:"+list.get(i).getName());
            binding.tvEmail.append("\nEmail:"+list.get(i).getEmail());
            binding.tvAddress.append("\nAddress"+list.get(i).getAddress());
        }
    }
}