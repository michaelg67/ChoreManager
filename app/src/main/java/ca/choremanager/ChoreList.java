package ca.choremanager;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by michaelgilhooly on 2017-12-01.
 */

public class ChoreList extends ArrayAdapter<Chore> {
    // Builds a list of chores, used in the schedule and the user profile
    List<Chore> chores;
    private Activity context;

    public ChoreList(Activity context, List<Chore> chores) {
        super(context, R.layout.layout_chore_list, chores);
        this.context = context;
        this.chores = chores;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Fill in the blanks for to see the chore in a list
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_chore_list, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewNotes = listViewItem.findViewById(R.id.textViewNotes);
        TextView textViewStatus = listViewItem.findViewById(R.id.textViewStatus);

        Chore chore = chores.get(position);
        textViewName.setText(chore.getName());
        textViewNotes.setText(String.valueOf(chore.getDescription()));
        if (chore.getCompleted()) {
            textViewStatus.setText("Completed");
        } else {
            textViewStatus.setText("Incomplete");
        }
        return listViewItem;
    }
}

