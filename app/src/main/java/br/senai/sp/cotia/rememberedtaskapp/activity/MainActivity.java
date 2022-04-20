package br.senai.sp.cotia.rememberedtaskapp.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import br.senai.sp.cotia.rememberedtaskapp.R;
import br.senai.sp.cotia.rememberedtaskapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // instacia o binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // seta na contentView a raiz (root) do binding
        setContentView(binding.getRoot());
    }


}