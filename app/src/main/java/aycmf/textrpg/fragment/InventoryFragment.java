package aycmf.textrpg.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import aycmf.textrpg.R;
import aycmf.textrpg.TextRPGApplication;
import aycmf.textrpg.model.Inventory;
import aycmf.textrpg.model.Item;

/**
 * A simple {@link Fragment} subclass.
 */
public class InventoryFragment extends Fragment {

    public InventoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final TextRPGApplication app = (TextRPGApplication) getActivity().getApplicationContext();
        final Inventory inventory = app.getModelContainer().getCharacter().getInventory();
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        return view;
    }

    private void populateList() {
        final TextRPGApplication app = (TextRPGApplication) getActivity().getApplicationContext();
        final Inventory inventory = app.getModelContainer().getCharacter().getInventory();


        //saveListView.setAdapter(saveAdapter);
    }
}
