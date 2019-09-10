package com.example.exercise;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    private Student student;
    private StudentDaoImpl studentDaoImpl;
    private EditText edName,edAge;
    private Button btn_yes,btn_tui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner = findViewById(R.id.sp_classmate);
        edName = findViewById(R.id.et_name);
        edAge = findViewById(R.id.et_age);
        btn_yes = findViewById(R.id.btn_yes);
        btn_tui = findViewById(R.id.btn_exit);

        studentDaoImpl =  new StudentDaoImpl(this);

        btn_tui.setOnClickListener(this);
        btn_yes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_yes:
                ADDSHUJ();
                break;
            case R.id.btn_exit:
                finish();
                break;
        }
    }


    private void ADDSHUJ() {
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
           }


           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {
           }
       });
        if (student == null)
        {
            student = new Student();
        }
        student.setName(edName.getText().toString());
        student.setClassmage(String.valueOf(spinner.getSelectedItem()));
        student.setAge(Integer.parseInt(edAge.getText().toString()));

        studentDaoImpl.insert(student);

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("22",student);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}
