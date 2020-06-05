package com.example.studentcompanionapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Syllabus extends AppCompatActivity {

    Spinner spSem, spSub;
    TextView tvBooks,tvSyllabus;

    String[] semester = {"Semester 1","Semester 2","Semester 3","Semester 4","Semester 5","Semester 6","Semester 7","Semester 8"};

    ArrayAdapter<String> adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar2);

        spSem = findViewById(R.id.spSem);
        spSub = findViewById(R.id.spSub);
        tvSyllabus = findViewById(R.id.tvSyllabus);
        tvBooks = findViewById(R.id.tvBooks);

        tvSyllabus.setVisibility(View.GONE);
        tvBooks.setVisibility(View.GONE);
        spSub.setVisibility(View.GONE);

        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinnerlayoout,semester);
        spSem.setAdapter(adapter);

        spSem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        tvSyllabus.setText(null);
                        tvBooks.setText(null);
                        semester_1();
                        break;
                    case 1:
                        tvSyllabus.setText(null);
                        tvBooks.setText(null);
                        semester_2();
                        break;
                    case 2:
                        tvSyllabus.setText(null);
                        tvBooks.setText(null);
                        semester_3();
                        break;
                    case 3:
                        tvSyllabus.setText(null);
                        tvBooks.setText(null);
                        semester_4();
                        break;
                    case 4:
                        tvSyllabus.setText(null);
                        tvBooks.setText(null);
                        semester_5();
                        break;
                    case 5:
                        tvSyllabus.setText(null);
                        tvBooks.setText(null);
                        semester_6();
                        break;
                    case 6:
                        tvSyllabus.setText(null);
                        tvBooks.setText(null);
                        semester_7();
                        break;
                    case 7:
                        tvSyllabus.setText(null);
                        tvBooks.setText(null);
                        semester_8();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Syllabus.this, "Select Semester", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void semester_1(){
        spSub.setVisibility(View.VISIBLE);

        String[] subject = {"Mathematics I","Chemistry"};
        ArrayAdapter<String> sem_1_adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinnerlayoout,subject);
        spSub.setAdapter(sem_1_adapter);

        spSub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Matrices, Vectors"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"Linear Transformation & Solution of Polynomials"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Numerical Differentiation & Integration");
                        tvBooks.setText("1.Engineering Mathematics by Pal and S. Bhunia, Oxford Publication "+"\n"+
                                "\n2.Advance Engineering Mathematics by P. V. O'Neil, Cengage"+"\n"+"\n3.Advanced Engineering Mathematics by E. Kreyszig, Tenth Edition, Wiley");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;
                    case 1 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Quantum Chemistry & Spectroscopy"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"Organometalics "+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Fuels & Corrosion");
                        tvBooks.setText("1.textbook of Applied Chemistry by B.Samantaray"+"\n"+"\n2.Introduction to Quantum Chemistry");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Syllabus.this, "Select Subject", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void semester_2(){
        spSub.setVisibility(View.VISIBLE);

        String[] subject = {"Mathematics II","Physics"};
        ArrayAdapter<String> sem_2_adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinnerlayoout,subject);
        spSub.setAdapter(sem_2_adapter);

        spSub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Calculus, Partial Differentiation"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"Vector Differential & Integral Calculus"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Differential Equation"+"\n"+"\n"+"Module 4 :"+"\n"+"Series Solution of Differential Equation & Laplace Equation");
                        tvBooks.setText("1.Engineering Mathematics by Pal and S. Bhunia, Oxford Publication "+"\n"+
                                "\n2.Advance Engineering Mathematics by P. V. O'Neil, Cengage"+"\n"+"\n3.Advanced Engineering Mathematics by E. Kreyszig, Tenth Edition, Wiley");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;
                    case 1 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Classical Dynamics,General Properties of Matter, Oscillations,Optics"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"Solid State,LASER and Fiber Optics"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Electromagnetism, Quantum Physics");
                        tvBooks.setText("1.L. Maharana, P. K. Panda, S. N. Dash, B. Ojha, Lectures in Engineering" +"\n"+
                                 "\n"+"2.Concepts of Modern Physics - Arthur Beiser "+"\n"+"\n"+"3.Quantum Physics - Gasiorowicz ");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Syllabus.this, "Select Subject", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void semester_3(){
        spSub.setVisibility(View.VISIBLE);

        String[] subject = {"ECA","AEC"};
        ArrayAdapter<String> sem_3_adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinnerlayoout,subject);
        spSub.setAdapter(sem_3_adapter);

        spSub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Network Theorems"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"Laplace Transform and Transient"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Network Functions"+"\n"+"\n"+"Module 4 :"+"\n"+"Fourier Transform");
                        tvBooks.setText("1.Network Analysis, M. E. Van Valkenburg, PHI, third edition. "+"\n"+
                                "\n2.Network Analysis and Synthesis, Franklin F. Kuo, Wiley Student Edition.");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;
                    case 1 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Biasing of BJT, MOSFET, FET"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"Small signal Analysis and High Frequency Response of BJT and FET"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Power Amplifiers");
                        tvBooks.setText("1.Electronic Devices and Circuits theory, R.L. Boylestad and L. Nashelsky" +"\n"+
                                "\n"+"2.Microelectronics Circuits, Adel Sedra and Kenneth C Smith "+"\n"+"\n"+"3.Design with Operational Ampli\fers and Analog Integrated Circuits");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Syllabus.this, "Select Subject", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void semester_4(){
        spSub.setVisibility(View.VISIBLE);

        String[] subject = {"EM II","MT"};
        ArrayAdapter<String> sem_4_adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinnerlayoout,subject);
        spSub.setAdapter(sem_4_adapter);

        spSub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Fundamentals of AC Machines"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"Synchronous Generator and Motor"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Three Phase Induction Motor"+"\n"+"\n"+"Module 4 :"+"\n"+"Single Phase Induction Motor");
                        tvBooks.setText("1.A. E. Fitzgerald and C. Kingsley, Electric Machinery "+"\n"+
                                "\n2.P. S. Bimbhra, Electrical Machinery, Khanna Publishers, 2011");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;
                    case 1 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Measuring Instruments"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"Measurement of Resistance, Capacitance and Inductance"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Instruments for measuring Basic Parameters");
                        tvBooks.setText("1.Electrical Measurements and Measuring Instruments- Golding & Widdis"+"\n" +
                                "\n"+"2.Modern Electronic Instrumentation and Measurement Techniques "+"\n"+"\n"+"3.Electronic Instrumentation- H C Kalsi- 2nd Edition, Tata McGraw Hill");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Syllabus.this, "Select Subject", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void semester_5(){
        spSub.setVisibility(View.VISIBLE);

        String[] subject = {"EPTD","PE"};
        ArrayAdapter<String> sem_5_adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinnerlayoout,subject);
        spSub.setAdapter(sem_5_adapter);

        spSub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"TL Parameters"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"TL Performance & Overhead Transmission Lines"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Distribution"+"\n"+"\n"+"Module 4 :"+"\n"+"Power System Earthing");
                        tvBooks.setText("1.J. Grainger and W. D. Stevenson, \"Power System Analysis\", McGraw Hill "+"\n"+
                                "\n2.D. P. Kothari and I. J. Nagrath, \"Modern Power System Analysis\"");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;
                    case 1 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Power Switching Devices"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"DC-DC Converter"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Voltage & Current Source Inverter");
                        tvBooks.setText("1.M. H. Rashid, \"Power electronics: circuits, devices, and applications\""+"\n" +
                                "\n"+"2.R. W. Erickson and D. Maksimovic, \"Fundamentals of Power Electronics\" "+"\n"
                                +"\n"+"3.L. Umanand, \"Power Electronics: Essentials and Applications\"");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Syllabus.this, "Select Subject", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void semester_6(){
        spSub.setVisibility(View.VISIBLE);

        String[] subject = {"PSOC","ED"};
        ArrayAdapter<String> sem_6_adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinnerlayoout,subject);
        spSub.setAdapter(sem_6_adapter);

        spSub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Power flow Analysis"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"Control of Frequency and Voltage"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Power System Stability");
                        tvBooks.setText("1.J. Grainger and W. D. Stevenson, \"Power System Analysis\" "+"\n"+
                                "\n2.O. I. Elgerd, \"Electric Energy Systems Theory\", McGraw Hill Education");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;
                    case 1 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Advantages of Electric Drives"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"EC-Motor Drive"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Induction-Motor Drive");
                        tvBooks.setText("1.G. K. Dubey, \"Fundamentals of Electrical Drives\", CRC Press, 2002"+"\n" +
                                "\n"+"2.R. Krishnan, \"Electric Motor Drives: Modeling, Analysis and Control\" "+"\n"
                                +"\n"+"3.W. Leonhard, \"Control of Electric Drives\", Springer Science");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Syllabus.this, "Select Subject", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void semester_7(){
        spSub.setVisibility(View.VISIBLE);

        String[] subject = {"PSDC","CS II"};
        ArrayAdapter<String> sem_7_adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinnerlayoout,subject);
        spSub.setAdapter(sem_7_adapter);

        spSub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Synchronous MT & Modelling"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"Power System Stability"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Excitation System Requirements");
                        tvBooks.setText("1.Prabha Kundur, Power system stability and control "+"\n"+
                                "\n2.P. Sauer and M. Pai, Power system dynamics and stability");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;
                    case 1 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Discrete - Time Control Systems"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"State Space Approach for discrete time systems"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Non-linear Systems");
                        tvBooks.setText("1.K. Ogata, \"Digital Control Engineering\", Prentice Hall, Englewood Cli\u000Bs"+"\n" +
                                "\n"+"2.M. Gopal, \"Digital Control Engineering\", Wiley Eastern, 1988 "+"\n"
                                +"\n"+"3.B. C. Kuo, \"Digital Control System\", Holt, Rinehart and Winston, 1980");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Syllabus.this, "Select Subject", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void semester_8(){
        spSub.setVisibility(View.VISIBLE);

        String[] subject = {"AED","IES"};
        ArrayAdapter<String> sem_8_adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinnerlayoout,subject);
        spSub.setAdapter(sem_8_adapter);

        spSub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Power Converters for AC drives"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"Induction motor drives"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Synchronous motor drives");
                        tvBooks.setText("1.B. K. Bose, \"Modern Power Electronics and AC Drives\" "+"\n"+
                                "\n2.R. Krishnan, \"Permanent Magnet Synchronous and Brushless DC motor"+
                                "Drives, CRC Press, 2009");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;
                    case 1 :
                        tvSyllabus.setText("Module 1 :"+"\n"+"Electrical System Components"+"\n"+"\n"+
                                "Module 2 :"+"\n"+"Residential and Commercial Electrical Systems"+"\n"+"\n"+"Module 3 :"+
                                "\n"+"Illumination Systems");
                        tvBooks.setText("1.S. L. Uppal and G. C. Garg, \"Electrical Wiring, Estimating & Costing\""+"\n" +
                                "\n"+"2.K. B. Raina, \"Electrical Design, Estimating & Costing\" "+"\n"
                                +"\n"+"3.S. Singh and R. D. Singh, \"Electrical estimating and costing\"");
                        tvBooks.setVisibility(View.VISIBLE);
                        tvSyllabus.setVisibility(View.VISIBLE);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Syllabus.this, "Select Subject", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
