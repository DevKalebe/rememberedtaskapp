package br.senai.sp.cotia.rememberedtaskapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import br.senai.sp.cotia.rememberedtaskapp.R;
import br.senai.sp.cotia.rememberedtaskapp.model.Task;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>{
    // variável para a lista de tarefas
    private List<Task> tasks;
    // variável para o Context
    private Context context;

    // construtor que recebe os parâmetros para o Adapter
    public TaskAdapter(List<Task> list, Context context){
        this.tasks = list;
        this.context  = context;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflar a view do viewHolder
        View view = LayoutInflater.from(context).inflate(R.layout.task, parent, false);
        // retorna uma viewHolder
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        // obtém a tarefa através da position
        Task t = tasks.get(position);
        // transportar  a info da tarefa para o holder
        holder.tvTitle.setText(t.getTitle());
        // formata a data e exibe no textView
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        holder.tvDate.setText(format.format(t.getDataPrev()));
        // verifica se está concluida
        if (t.isConcluida()){
            holder.tvStatus.setText("Finalizada");
            // COLOCAR A COR
            holder.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.black));
        }else{
            holder.tvStatus.setText("Aberta");
            // COLOCAR A COR
            holder.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.black));
        }
        // fazer a atrasada
    }

    @Override
    public int getItemCount() {
        if (tasks != null){
            return tasks.size();
        }
        return 0;
    }


    class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDate, tvStatus;

        public TaskViewHolder(View view){
            super(view);

            // passar da view para os componentes
            tvTitle = view.findViewById(R.id.tv_title);
            tvDate = view.findViewById(R.id.tv_date);
            tvStatus = view.findViewById(R.id.tv_status);
        }
    }

}
