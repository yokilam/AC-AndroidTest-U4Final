package nyc.c4q.androidtest_unit4final;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by justiceo on 1/7/18.
 */

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {

    private List<String> colorNames;

    public ColorAdapter(List<String> colors) {
        colorNames = colors;
    }

    @Override
    public ColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_itemview, parent, false);
        return new ColorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ColorViewHolder holder, int position) {
        String color = colorNames.get(position);
        holder.name.setText(color);
        holder.name.setTextColor(Color.parseColor(color));
    }

    @Override
    public int getItemCount() {
        return colorNames.size();
    }

    class ColorViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public ColorViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.color_name);
        }
    }
}
