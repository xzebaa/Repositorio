package com.example.desarrollo1.enucuestas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmento1 extends Fragment {

    private WebView wv_rae;
    private EditText ET_Busqueda;
    private Button btnBuscar;

    public fragmento1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View bView= inflater.inflate(R.layout.fragmento1, container, false);

        wv_rae=(WebView)bView.findViewById(R.id.wv_rae);
        ET_Busqueda=(EditText)bView.findViewById(R.id.ETBusqueda);

        btnBuscar=(Button)bView.findViewById(R.id.btnBuscarLaRae);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebSettings conf=wv_rae.getSettings();
                conf.setJavaScriptEnabled(true);

                wv_rae.loadUrl("http://"+ET_Busqueda.getText().toString());
            }
        });

        // Inflate the layout for this fragment
        return bView;
    }

    public void buscarOnclick(View v)
    {


    }


}
