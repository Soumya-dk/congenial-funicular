package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multiple_cardview.R;

import java.util.List;

import Model.MyModel;

import static Model.MyModel.ONE_TYPE;
import static Model.MyModel.TWO_TYPE;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MyModel> list;

    public MyAdapter(List<MyModel> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        MyModel model = list.get(position);
        if(model!= null){
           return model.getType();
        }

        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case ONE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_one,parent,false);
                return new OneViewHolder(view);
            case TWO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_two,parent,false);
                return new TwoViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       MyModel model = list.get(position);
        switch (model.getType()){
            case ONE_TYPE:
                ((OneViewHolder)holder).title.setText(model.getTitle());
                break;
            case TWO_TYPE:
                ((TwoViewHolder)holder).title.setText(model.getTitle());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder{
        TextView title;

        public OneViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.text_title);
        }
    }
    class TwoViewHolder extends RecyclerView.ViewHolder{
        TextView title;

        public TwoViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.text_title);
        }
    }


}
