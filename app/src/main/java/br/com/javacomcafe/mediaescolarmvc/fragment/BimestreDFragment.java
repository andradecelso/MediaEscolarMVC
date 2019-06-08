package br.com.javacomcafe.mediaescolarmvc.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.javacomcafe.mediaescolarmvc.R;
import br.com.javacomcafe.mediaescolarmvc.controller.MediaEscolarController;
import br.com.javacomcafe.mediaescolarmvc.model.MediaEscolar;
import br.com.javacomcafe.mediaescolarmvc.view.MainActivity;


public class BimestreDFragment extends Fragment {

    Button btnCalcular;
    EditText editMateria;
    EditText editNotaProva;
    EditText editNotaTrabalho;
    TextView txtResultado;
    TextView txtSituacaoFinal;

    double notaProva;
    double notaTrabalho;
    double media;

    MediaEscolar mediaEscolar;
    MediaEscolarController controller;

    boolean dadosValidados = true;
    Context context;
    View view;

    public BimestreDFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getContext();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        view =inflater.inflate(R.layout.fragment_bimestred, container, false);

        editMateria = view.findViewById(R.id.editMateria);
        editNotaProva = view.findViewById(R.id.editNotaProva);
        editNotaTrabalho = view.findViewById(R.id.editNotaTrabalho);
        txtResultado = view.findViewById(R.id.txtResultado);
        txtSituacaoFinal = view.findViewById(R.id.txtSituacaoFinal);
        btnCalcular = view.findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    if (editNotaProva.getText().toString().length() > 0) {
                        notaProva = Double.parseDouble(editNotaProva.getText().toString());
                    } else {
                        editNotaProva.setError("*");
                        editNotaProva.requestFocus();
                        dadosValidados =false;
                    }


                    if (editNotaTrabalho.getText().toString().length() > 0) {
                        notaTrabalho = Double.parseDouble(editNotaTrabalho.getText().toString());
                    } else {
                        editNotaTrabalho.setError("*");
                        editNotaTrabalho.requestFocus();
                        dadosValidados = false;
                    }

                    if(editMateria.getText().toString().length()==0){
                        editMateria.setError("*");
                        editMateria.requestFocus();
                        dadosValidados = false;
                    }

                    // Após Validação
                    if(dadosValidados) {

                        mediaEscolar = new MediaEscolar();
                        controller = new MediaEscolarController(context);


                        mediaEscolar.setMateria(editMateria.getText().toString());
                        mediaEscolar.setNotaProva(Double.parseDouble((editNotaProva.getText().toString())));
                        mediaEscolar.setNotaTrabalho(Double.parseDouble(editNotaTrabalho.getText().toString()));


                        media = controller.calcularMedia(mediaEscolar);

                        txtResultado.setText(MainActivity.valorFormatado(media));



                        mediaEscolar.setBimestre("4o Bimestre");
                        mediaEscolar.setSituacao(controller.resultadoFinal(media));
                        mediaEscolar.setMediaFinal(media);


                        txtSituacaoFinal.setText(mediaEscolar.getSituacao());
                        editNotaProva.setText(MainActivity.valorFormatado(notaProva));
                        editNotaTrabalho.setText(MainActivity.valorFormatado(notaTrabalho));

                        // salvarSharedPreferences();


                        if (controller.salvar(mediaEscolar)){
                            Toast.makeText(context, "Sucesso ao salvar dados", Toast.LENGTH_SHORT).show();


                        }else{

                            Toast.makeText(context, "Esso ao tentar salvar dados", Toast.LENGTH_SHORT).show();
                        }

                    }

                } catch (Exception e) {

                    Toast.makeText(context, "Informe as notas...", Toast.LENGTH_LONG).show();

                }


            }
        });


        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }



}
