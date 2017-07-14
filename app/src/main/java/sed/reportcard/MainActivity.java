package sed.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Defines variables for the users grades, scores and a string returned to user to tell them all the grades
    public static String MATH_GRADE, ENGLISH_GRADE, HISTORY_GRADE ,ART_GRADE ,PHYSICS_GRADE,BIOLOGY_GRADE;
    public static int MATH_SCORE, ENGLISH_SCORE, HISTORY_SCORE ,ART_SCORE ,PHYSICS_SCORE,BIOLOGY_SCORE;
    public static String USER_DETAILS;


    // Calls methods that store grades and returns string with all of users grades
    private  String ReportCard(){
        setMathGrade();
        setEnglishGrade();
        setArtGrade();
        setHistoryGrade();
        setBiologyGrade();
        setPhysicsGrade();

        String maths = "Math grade is" + getMathGrade();
        String english = "English grade is" + getEngishGrade();
        String history = "History grade is" + getHistoryGrade();
        String art = "Art grade is" + getArtGrade();
        String physics = "Physics grade is" + getPhysicsGrade();
        String biology = "Biology grade is" + getBiologyGrade();

        USER_DETAILS = "Your name" + maths + ", "
                + english + history + art + physics + biology;

        return USER_DETAILS;
    }
    // String to display score and grade
    public String getMathGrade(){
        return "Grade - " + MATH_SCORE +" - " + MATH_GRADE;
    }
    public String getEngishGrade(){
        return "Grade - " + ENGLISH_SCORE +" - " + ENGLISH_GRADE;
    }
    public String getHistoryGrade(){
        return "Grade - " + HISTORY_SCORE +" - " + HISTORY_GRADE;
    }
    public String getArtGrade(){
        return "Grade - " + ART_SCORE +" - " + ART_GRADE;
    }
    public String getPhysicsGrade(){
        return "Grade - " + PHYSICS_SCORE +" - " + PHYSICS_GRADE;
    }
    public String getBiologyGrade(){
        return "Grade - " + BIOLOGY_SCORE +" - " + BIOLOGY_GRADE;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // For user interface, enables user to enter score per subject and hit submit button to see results
        Button mButton = (Button) findViewById(R.id.SubmitButton);
        final EditText editMaths = (EditText) findViewById(R.id.getMaths);
        final EditText editEnglish = (EditText) findViewById(R.id.getEnglish);
        final EditText editHistory = (EditText) findViewById(R.id.getHistory);
        final EditText editArt = (EditText) findViewById(R.id.getArt);
        final EditText editPhysics = (EditText) findViewById(R.id.getPhysics);
        final EditText editBiology = (EditText) findViewById(R.id.getBiology);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MATH_SCORE = Integer.parseInt(editMaths.getText().toString());
                ENGLISH_SCORE = Integer.parseInt(editEnglish.getText().toString());
                HISTORY_SCORE = Integer.parseInt(editHistory.getText().toString());
                ART_SCORE = Integer.parseInt(editArt.getText().toString());
                PHYSICS_SCORE = Integer.parseInt(editPhysics.getText().toString());
                BIOLOGY_SCORE = Integer.parseInt(editBiology.getText().toString());

                TextView textView = (TextView) findViewById(R.id.results);
                textView.setText(ReportCard());

                // Intent to email grades to chosen recipient
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Report Card");
                intent.putExtra(Intent.EXTRA_TEXT, ReportCard());
                startActivity(intent);
            }
        });

    }

    // Methods used to convert the subject score to a grade
    public  String setMathGrade(){

        if (MATH_SCORE <40){
            MATH_GRADE ="F";
        } else if (MATH_SCORE >40 && MATH_SCORE <50) {
            MATH_GRADE = "D";
        }else if (MATH_SCORE >50 && MATH_SCORE <60) {
            MATH_GRADE = "C";
        }else if (MATH_SCORE >60 && MATH_SCORE <70) {
            MATH_GRADE = "B";
        }else   {
            MATH_GRADE = "A";
        }
        return MATH_GRADE;
    }
    public  String setEnglishGrade(){

        if (ENGLISH_SCORE <40){
            ENGLISH_GRADE ="F";
        } else if (ENGLISH_SCORE >40 && ENGLISH_SCORE <50) {
            ENGLISH_GRADE = "D";
        }else if (ENGLISH_SCORE >50 && ENGLISH_SCORE <60) {
            ENGLISH_GRADE = "C";
        }else if (ENGLISH_SCORE >60 && ENGLISH_SCORE <70) {
            ENGLISH_GRADE = "B";
        }else   {
            ENGLISH_GRADE = "A";
        }
        return ENGLISH_GRADE;
    }
    public  String setHistoryGrade(){

        if (HISTORY_SCORE <40){
            HISTORY_GRADE ="F";
        } else if (HISTORY_SCORE >40 && HISTORY_SCORE <50) {
            HISTORY_GRADE = "D";
        }else if (HISTORY_SCORE >50 && HISTORY_SCORE <60) {
            HISTORY_GRADE = "C";
        }else if (HISTORY_SCORE >60 && HISTORY_SCORE <70) {
            HISTORY_GRADE = "B";
        }else   {
            HISTORY_GRADE = "A";
        }
        return HISTORY_GRADE;
    }
    public  String setArtGrade(){

        if (ART_SCORE <40){
            ART_GRADE ="F";
        } else if (ART_SCORE >40 && ART_SCORE <50) {
            ART_GRADE = "D";
        }else if (ART_SCORE >50 && ART_SCORE <60) {
            HISTORY_GRADE = "C";
        }else if (ART_SCORE >60 && ART_SCORE <70) {
            ART_GRADE = "B";
        }else   {
            ART_GRADE = "A";
        }
        return ART_GRADE;
    }
    public  String setPhysicsGrade(){

        if (PHYSICS_SCORE <40){
            PHYSICS_GRADE ="F";
        } else if (PHYSICS_SCORE >40 && PHYSICS_SCORE <50) {
            PHYSICS_GRADE = "D";
        }else if (PHYSICS_SCORE >50 && PHYSICS_SCORE <60) {
            PHYSICS_GRADE = "C";
        }else if (PHYSICS_SCORE >60 && PHYSICS_SCORE <70) {
            PHYSICS_GRADE = "B";
        }else   {
            PHYSICS_GRADE = "A";
        }
        return PHYSICS_GRADE;
    }
    public  String setBiologyGrade(){

        if (BIOLOGY_SCORE <40){
            BIOLOGY_GRADE ="F";
        } else if (BIOLOGY_SCORE >40 && BIOLOGY_SCORE <50) {
            BIOLOGY_GRADE = "D";
        }else if (BIOLOGY_SCORE >50 && BIOLOGY_SCORE <60) {
            BIOLOGY_GRADE = "C";
        }else if (BIOLOGY_SCORE >60 && BIOLOGY_SCORE <70) {
            BIOLOGY_GRADE = "B";
        }else   {
            BIOLOGY_GRADE = "A";
        }
        return BIOLOGY_GRADE;
    }
}
