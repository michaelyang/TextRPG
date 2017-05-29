package aycmf.textrpg.model;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import aycmf.textrpg.R;

/**
 * Created by myang on 5/25/17.
 */

public class InventoryAdapter extends BaseAdapter {
    private Context context;
    private Inventory inventory;
    HashMap<Item, Integer> inventoryHashMap = new HashMap<>();
    Item[] keys;

    public InventoryAdapter(Context context, Inventory inventory) {
        this.context = context;
        this.inventory = inventory;
        inventoryHashMap = inventory.getHashMap();
        keys = inventoryHashMap.keySet().toArray(new Item[inventoryHashMap.size()]);
    }

    @Override
    public int getCount() {
        return inventory.size();
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item key = keys[position];
        String value = getItem(position).toString();

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.inventory_item_view, null);
        }
        final TextView itemName = (TextView) convertView.findViewById(R.id.itemName);
        //final ImageView itemIcon = (ImageView) convertView.findViewById(R.id.achievementIcon);

        //Resources resources = context.getResources();
        //final int resourceId = resources.getIdentifier(achievement.iconId,"drawable",context.getPackageName());

        itemName.setText(key.getName());

        return convertView;
    }

}
