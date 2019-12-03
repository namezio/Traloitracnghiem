package com.namezio.traloitracnghiem.monhoc;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.namezio.traloitracnghiem.MainActivity;
import com.namezio.traloitracnghiem.R;
import com.namezio.traloitracnghiem.question.QuestionAdapter;
import com.namezio.traloitracnghiem.Presenter.QuestionController;


public class SearchQuesFragment extends Fragment {

    ListView lvQuestion;
    QuestionController questionController;
    QuestionAdapter adapter;
    EditText edtSearch;

    public SearchQuesFragment() {
        // Required empty public constructor
    }
    public void begin() {
        lvQuestion = (ListView) getActivity().findViewById(R.id.lvQuestion);
        edtSearch = (EditText) getActivity().findViewById(R.id.edtSearch);
        questionController = new QuestionController(getActivity());
        listCursor( questionController.getSearchQuestion( edtSearch.getText().toString() ) );

    }
    public void listCursor(Cursor cursor) {
        adapter = new QuestionAdapter(getActivity(), cursor, true);
        lvQuestion.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Tìm Kiếm");
        return inflater.inflate( R.layout.fragment_search_ques, container, false );
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );

           begin();

        edtSearch.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                listCursor( questionController.getSearchQuestion( edtSearch.getText().toString() ) );

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        } );



    }
}
