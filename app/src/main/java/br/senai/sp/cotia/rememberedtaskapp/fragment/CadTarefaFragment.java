package br.senai.sp.cotia.rememberedtaskapp.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;

import br.senai.sp.cotia.rememberedtaskapp.R;
import br.senai.sp.cotia.rememberedtaskapp.databinding.FragmentCadTarefaBinding;

public class CadTarefaFragment extends Fragment {
    private FragmentCadTarefaBinding binding;
    // variável para o datePicker
    private DatePickerDialog datePicker;
    // variáveis para ano, mês e dia
    int year, month, day;
    // variável para a data atual
    Calendar dataAtual;
    // variável para a data formatada
    String dataFormatada;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // instanciar o biding
        binding = FragmentCadTarefaBinding.inflate(getLayoutInflater(), container, false);

        // instanciar a data atual
        dataAtual = Calendar.getInstance();
        // obter ano, mês e dia, da data atual
        year = dataAtual.get(Calendar.YEAR);
        month = dataAtual.get(Calendar.MONTH);
        day = dataAtual.get(Calendar.DAY_OF_MONTH);

        // instanciar o datePicker
        datePicker = new DatePickerDialog(getContext(), (datePicker, ano,mes, dia)->{
         // ao escolher uma data no datePicker, cai aqui

        }, 0, 0, 0);

        binding.btDatePrev.setOnClickListener(v ->{
            datePicker.show();
        });

        return binding.getRoot();
    }
}