package com.namezio.traloitracnghiem.monhoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.namezio.traloitracnghiem.MainActivity;
import com.namezio.traloitracnghiem.Model.Exam;
import com.namezio.traloitracnghiem.R;
import com.namezio.traloitracnghiem.slide.ScreenSlideActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class GDCDFragment extends Fragment {
    ExamAdapter examAdapter;
    GridView gridView;
    ArrayList<Exam> exams = new ArrayList<Exam>( );

    public GDCDFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Môn GDCD");
        return inflater.inflate( R.layout.fragment_gdcd, container, false );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        gridView = getActivity().findViewById( R.id.gvExam );

        exams.add( new Exam( "Đề Số 1" ) );
        exams.add( new Exam( "Đề Số 2" ) );
        exams.add( new Exam( "Đề Số 3" ) );
        exams.add( new Exam( "Đề Số 4" ) );

        examAdapter = new ExamAdapter( getActivity(),exams );
        gridView.setAdapter( examAdapter );

        gridView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent( getActivity(), ScreenSlideActivity.class );
                intent.putExtra( "num_exam",i+1 );
                intent.putExtra( "subject","gdcd" );
                startActivity( intent );
            }
        } );
    }
}
