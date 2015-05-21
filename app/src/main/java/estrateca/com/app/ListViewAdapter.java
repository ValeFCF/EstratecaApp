package estrateca.com.app;

import android.content.Context;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    // Declare Variables
    Context context;
    String[] titulos;
    int[] imagenes;
    int tipo;
    LayoutInflater inflater;

    public ListViewAdapter(Context context, String[] titulos, int[] imagenes,int tipo) {
        this.context = context;
        this.titulos = titulos;
        this.imagenes = imagenes;
        this.tipo=tipo;
    }

    @Override
    public int getCount() {
        return titulos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtTitle;
        ImageView imgImg;


        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if( tipo ==1) {
            View itemView = inflater.inflate(R.layout.list_row, parent, false);

            // Locate the TextViews in listview_item.xml
            txtTitle = (TextView) itemView.findViewById(R.id.list_row_title);
            imgImg = (ImageView) itemView.findViewById(R.id.list_row_image);

            // Capture position and set to the TextViews
            txtTitle.setText(titulos[position]);
            imgImg.setImageResource(imagenes[position]);
            return itemView;
        }
        else{

            View itemView = inflater.inflate(R.layout.list_row2, parent, false);

            // Locate the TextViews in listview_item.xml

            imgImg = (ImageView) itemView.findViewById(R.id.list_row_image);

            // Capture position and set to the TextViews

            imgImg.setImageResource(imagenes[position]);
            return itemView;
        }


    }
}