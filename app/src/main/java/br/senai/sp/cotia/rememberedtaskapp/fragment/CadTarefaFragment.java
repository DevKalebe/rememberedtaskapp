package br.senai.sp.cotia.rememberedtaskapp.fragment;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Objects;

import br.senai.sp.cotia.rememberedtaskapp.R;
import br.senai.sp.cotia.rememberedtaskapp.database.AppDatabase;
import br.senai.sp.cotia.rememberedtaskapp.databinding.FragmentCadTarefaBinding;
import br.senai.sp.cotia.rememberedtaskapp.model.Task;

public class CadTarefaFragment extends Fragment {
    private FragmentCadTarefaBinding binding;
    // variáveis para os inputs


    // variável para o datePicker
    private DatePickerDialog datePicker;
    // variáveis para ano, mês e dia
    int year, month, day;
    // variável para a data atual
    Calendar dataAtual;
    // variável para a data formatada
    String dataFormatada = "";
    // variável para a database
    AppDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // instancia a database
        database = AppDatabase.getDatabase(getContext());

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
         // passar para as variáveis globais
         year = ano;
         month = mes;
         day = dia;
         // formata a data
         dataFormatada = String.format("%02d/%02d/%04d",day, month + 1, year);
         // aplica a data formatada no botão
            binding.btDatePrev.setText(dataFormatada);

        }, year, month, day);

        binding.btDatePrev.setOnClickListener(v ->{
            datePicker.show();
        });

        // Listener do botão salvar
        binding.btSave.setOnClickListener(v -> {

            if (binding.etTitleTask.getText().toString().isEmpty()) {

                AlertDialog.Builder nTconfirme = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
                nTconfirme.setTitle("Verifique os campos");
                nTconfirme.setMessage("Nome da tarefa não pode estar vazia !");

                Toast.makeText(getContext(), "Informe o nome da tarefa", Toast.LENGTH_LONG).show();

            }else if (binding.etDesc.getText().toString().isEmpty()){

                AlertDialog.Builder nTconfirme = new AlertDialog.Builder(getContext());
                nTconfirme.setTitle("Verifique os campos");
                nTconfirme.setMessage("Descrição não pode estar vazia !");

                Toast.makeText(getContext(), "Informe a descrição da tarefa", Toast.LENGTH_LONG).show();

            }else if (dataFormatada.isEmpty()){

                AlertDialog.Builder nTconfirme = new AlertDialog.Builder(getContext());
                nTconfirme.setTitle("Verifique os campos");
                nTconfirme.setMessage("A data não pode estar vazia !");

                Toast.makeText(getContext(), "Informe a data para conclusão", Toast.LENGTH_LONG).show();
            }else {
                // criar uma tarefa
                Task task = new Task();
                // popular o objeto da tarefa
                task.setTitle(binding.etTitleTask.getText().toString());
                task.setDesc(binding.etDesc.getText().toString());
                task.setDataCreate(dataAtual.getTimeInMillis());
                // criar um Calendar
                Calendar dataPrevista = Calendar.getInstance();
                // muda a data para a data escolhida no datepicker
                task.setDataPrev(dataPrevista.getTimeInMillis());
                // salvar a tarefa
                new InsertTask().execute(task);
            }

        });

        return binding.getRoot();
    }

    // AsyncTask para inserir Tarefa
    private class InsertTask extends AsyncTask<Task, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Task... tasks) {

            // pegar a tarefa apartir do vetor
            Task t = tasks[0];
            try {
                // chamar o método para salvar a tarefa
                database.getTaskDao().insert(t);
                // retornar
                return "ok";
            }catch (Exception erro){
                erro.printStackTrace();
                // retorna a mensagem de erro
                return erro.getMessage();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String r) {
            if(r.equals("ok")){
               Toast.makeText(getContext(), "Tarefa Salvada com sucesso", Toast.LENGTH_LONG).show();
               // voltar ao fragment anterior
                getActivity().onBackPressed();
            }else{
                Toast.makeText(getContext(), r, Toast.LENGTH_LONG).show();
            }

        }
    }
}