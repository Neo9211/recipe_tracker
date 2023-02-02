package lasalle.midterm.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RecipeActivity extends AppCompatActivity {


    private TextView mRecipeName;
    private TextView mRecipeIngredients;
    private TextView mRecipeMethodTitle;
    private TextView mRecipe;


    TextView showRating;
    EditText review;
    Button button, submit;
    RatingBar ratingStars;

    float myRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        button = findViewById(R.id.button);
        ratingStars = findViewById(R.id.ratingBar);
        review = findViewById(R.id.review);
        submit = findViewById(R.id.submitBtn);
        showRating = findViewById(R.id.showRating);

        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int) v;
                String message = null;

                myRating = ratingBar.getRating();

                switch (rating){
                    case 1:
                        message = "Sorry to hear that! :(";
                        break;

                    case 2:
                        message = "You always accept suggestions!";
                        break;

                    case 3:
                        message = "Good enough!";
                        break;

                    case 4:
                        message = "Great, thanks!";
                        break;

                    case 5:
                        message = "Awesome, thank you!";
                        break;
                }

                Toast.makeText(RecipeActivity.this, message, Toast.LENGTH_SHORT).show();

            }
        });


        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(RecipeActivity.this,String.valueOf(myRating), Toast.LENGTH_SHORT).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                showRating.setText("Your review: \n" + review.getText());
                review.setText("");

            }
        });

        mRecipeName = (TextView)findViewById(R.id.text_recipe);
        mRecipeIngredients = (TextView)findViewById(R.id.ingredients);
        mRecipeMethodTitle = (TextView)findViewById(R.id.method);
        mRecipe = (TextView)findViewById(R.id.recipe);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("RecipeName");
        String Ingredients = intent.getExtras().getString("RecipeIngredients");
        String MethodTitle = intent.getExtras().getString("RecipeMethodTitle");
        String Recipe = intent.getExtras().getString("Recipe");

        mRecipeName.setText(Title);
        mRecipeIngredients.setText(Ingredients);
        mRecipeMethodTitle.setText(MethodTitle);
        mRecipe.setText(Recipe);
    }
}