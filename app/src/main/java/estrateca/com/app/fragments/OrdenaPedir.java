package estrateca.com.app.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import estrateca.com.app.R;

/**
 * Created by salvador on 20/05/2015.
 */
public class OrdenaPedir extends Fragment {

    int cantidad=0;
    int img;
    public static void newInstance(String param1, String param2) {
        OrdenaPedir fragment = new OrdenaPedir(0);
        Bundle args = new Bundle();

        fragment.setArguments(args);
        }
    public OrdenaPedir(int img)
    {
    this.img=img;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ordenarpedir, container, false);
        final TextView mTextView = (TextView) v.findViewById(R.id.numero);
        final TextView platilloTextView = (TextView) v.findViewById(R.id.textoplatillo);
        final Button masButton = (Button) v.findViewById(R.id.mas);
        final Button menosButton = (Button) v.findViewById(R.id.menos);
        final Button cancelButton = (Button) v.findViewById(R.id.cancelar);
        final Button agregarButton = (Button) v.findViewById(R.id.Agregar);
        final ImageView image= (ImageView) v.findViewById(R.id.imagen);
        switch (img){
            case 0:
                    image.setImageResource(R.drawable.platillo1);
                break;
            case 1:
                image.setImageResource(R.drawable.platillo2);
                platilloTextView.setText("Exquisita hamburguesa acompañada con papas a las francesa.");
                break;
            case 2:
                image.setImageResource(R.drawable.platillo3);
                platilloTextView.setText("Deliciosa arrachera termino medio acompañada con guarniciones .");
                break;
            case 3:
                image.setImageResource(R.drawable.platillo4);
                platilloTextView.setText("Ricas orden de enchiladas suizas rellenas de pollo.");
                break;
            case 4:
                image.setImageResource(R.drawable.platillo5);
                platilloTextView.setText("Sabrosa pizza mediana con extra queso");
                break;


        }
        masButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cantidad++;
                mTextView.setText(Integer.toString( cantidad));
            }
        });
        menosButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cantidad--;
                if (cantidad<0){
                    cantidad=0;
                }
                mTextView.setText(Integer.toString(cantidad));
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentManager =  getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment = new Fragment();
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Orden Cancelada" , Toast.LENGTH_SHORT).show();
                fragment = new Ordenar();
                fragmentTransaction.replace(R.id.vale_holder_container, fragment);
                fragmentTransaction.commit();
            }
        });
        agregarButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentManager =  getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment = new Fragment();
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Su orden se a pedido" , Toast.LENGTH_SHORT).show();
                fragment = new Ordenar();
                fragmentTransaction.replace(R.id.vale_holder_container, fragment);
                fragmentTransaction.commit();
            }
        });
        return v;

    }
   }
