package com.vedruna.proyectoFinal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vedruna.perezpradamproyectofinal.R;
import com.vedruna.proyectoFinal.model.Publication;

import java.util.List;

/**
 * Adaptador personalizado para mostrar publicaciones en una lista.
 */
public class PublicationsAdapter extends BaseAdapter {
    List<Publication> publicationList;

    Context context;
    TextView text;
    TextView date;
    TextView post;

    /**
     * Constructor del adaptador.
     * @param publicationList La lista de publicaciones a mostrar.
     * @param context El contexto de la aplicación.
     */
    public PublicationsAdapter(List<Publication> publicationList, Context context) {
        this.publicationList = publicationList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return publicationList.size();
    }

    @Override
    public Object getItem(int i) {
        return publicationList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return publicationList.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.publication_list, parent, false);
        }
        text = convertView.findViewById(R.id.postText);
        text.setText(publicationList.get(position).getText());
        date = convertView.findViewById(R.id.datePost);
        date.setText(publicationList.get(position).getCreationDate());
        post = convertView.findViewById(R.id.postId);
        post.setText(publicationList.get(position).getId() + "");
        return convertView;
    }
}
