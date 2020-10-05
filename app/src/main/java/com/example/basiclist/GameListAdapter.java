package com.example.basiclist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<Game> gameList;
    ArrayList<Game> gameArrayList;

    public GameListAdapter(Context mContext, List<Game> gameList) {
        context = mContext;
        this.gameList = gameList;
        inflater = LayoutInflater.from(context);
        gameArrayList = new ArrayList<>(gameList);
    }

    public class ViewHolder {
        TextView mTitle, mDescription;
    }

    @Override
    public int getCount() {
        return gameList.size();
    }

    @Override
    public Object getItem(int position) {
        return gameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.custom_list, null);

            viewHolder.mTitle = convertView.findViewById(R.id.title);
            viewHolder.mDescription = convertView.findViewById(R.id.description);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mTitle.setText(gameList.get(position).getTitle());
        viewHolder.mDescription.setText(gameList.get(position).getDescription());

        return convertView;
    }

    public void filter(String searchText) {
        searchText = searchText.toLowerCase();
        gameList.clear();
        if (searchText.length() == 0) {
            gameList.addAll(gameArrayList);
        } else {
            for (Game game : gameArrayList) {
                if (game.getTitle().toLowerCase().contains(searchText)) {
                    gameList.add(game);
                }
            }
        }
        notifyDataSetChanged();
    }
}
