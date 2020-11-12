package com.wizlinx.parceablepractice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.wizlinx.parceablepractice.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public UserData userData;
    private List<UserData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        clickListener();
    }

    @Override
    protected void onStart() {
        startService(new Intent(MainActivity.this,ForegroundService.class));
        super.onStart();
    }

    private void init() {
        list=new ArrayList<>();
        userData=new UserData("Ali","Ali@gmail.com","Lahore");
        UserData userData2=new UserData("Ahssan","ahssanakhtar32@gmail.com","Lahore");
        UserData userData3=new UserData("Usman","Usmanakhtar32@gmail.com","Lahore");
        UserData userData4=new UserData("Abdul Rahman","AbdulRahman@gmail.com","Lahore");
        UserData userData5=new UserData("Umer","Umer@gmail.com","Lahore");
        list.add(userData);
        list.add(userData2);
        list.add(userData3);
        list.add(userData4);
        list.add(userData5);
    }

    private void clickListener() {
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("list",(Serializable) list);
                startActivity(intent);
            }
        });
    }
}