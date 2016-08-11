package com.example.android.devq;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random randomGenerator = new Random();
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView1);
        final Button btnQuotes = (Button) findViewById(R.id.btnQuotes);
        final ImageButton btnYoda = (ImageButton) findViewById(R.id.btnYoda);
        final ImageButton btnShare = (ImageButton) findViewById(R.id.btnShare);
        final ImageView hintergrundbild = (ImageView) findViewById(R.id.imageView1);

        final ArrayList<String> yoda = createYodaArray();
        final ArrayList<String> quotes = createQuotesArray();

        if (textView != null) {
            if (btnYoda != null) {
                btnYoda.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        int randomInt = randomGenerator.nextInt(yoda.size());
                        textView.setText(yoda.get(randomInt));
                        if (hintergrundbild != null) {
                            hintergrundbild.setImageResource(R.drawable.camel);
                        }
                    }
                });
            }



            if (btnQuotes != null) {
                btnQuotes.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        int randomInt = randomGenerator.nextInt(quotes.size());

                        textView.setText(quotes.get(randomInt));

                        if (hintergrundbild != null) {
                            hintergrundbild.setImageResource(R.drawable.matrix);
                        }
                    }
                });
            }
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String words = textView.getText().toString();
                    startSpeak(words);
                }
            });

            if (btnShare != null) {
                btnShare.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String share = null;
                        share = textView.getText().toString();

                        Intent shareIntent = new Intent();
                        shareIntent.setAction(Intent.ACTION_SEND);
                        shareIntent.putExtra(Intent.EXTRA_TEXT, share);
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Awesome Developer Quote");
                        startActivity(Intent.createChooser(shareIntent,
                                "Share with..."));
                    }

                });
            }
        }
    }

    @NonNull
    private ArrayList<String> createQuotesArray() {
        final ArrayList<String> quotes = new ArrayList<String>();
        quotes.add("“If debugging is the process of removing software bugs, then programming must be the process of putting them in.”\n" +
                "- Edsger Dijkstra");
        quotes.add("“Measuring programming progress by lines of code is like measuring aircraft building progress by weight.”\n" +
                "- Bill Gates");
        quotes.add("“Any fool can write code that a computer can understand. Good programmers write code that humans can understand.”\n" +
                "- Martin Fowler");
        quotes.add("“Don’t worry if it doesn’t work right. If everything did, you’d be out of a job.”\n" +
                "- Mosher’s Law of Software Engineering");
        quotes.add("“Walking on water and developing software from a specification are easy if both are frozen.” \n" +
                "- Edward V Berard");
        quotes.add("“They don't make bugs like Bunny anymore.” \n" +
                "- Olav Mjelde");
        quotes.add("“Fine, Java MIGHT be a good example of what a programming language should be like. But Java applications are good examples of what applications SHOULDN’T be like.” \n" +
                "- pixadel");
        quotes.add("“In the one and only true way. The object-oriented version of 'Spaghetti code' is, of course, 'Lasagna code'. (Too many layers).” \n" +
                "- Roberto Waltman");
        quotes.add("“When someone says: 'I want a programming language in which I need only say what I wish done', give him a lollipop.” \n" +
                "- Alan J. Perlis");
        quotes.add("“Good design adds value faster than it adds cost.” \n" +
                "- Thomas C. Gale");
        quotes.add("“Talk is cheap. Show me the code.” \n" +
                "- Linus Torvalds");
        quotes.add("“Perfection [in design] is achieved, not when there is nothing more to add, but when there is nothing left to take away.” \n" +
                "- Antoine de Saint-Exupéry");
        quotes.add("“In theory, theory and practice are the same. In practice, they’re not.” \n" +
                "- Yoggi Berra");
        quotes.add("“You can’t have great software without a great team, and most software teams behave like dysfunctional families.” \n" +
                "- Jim McCarthy");
        quotes.add("“Programming is like kicking yourself in the face, sooner or later your nose will bleed.” \n" +
                "- Kyle Woodbury");
        quotes.add("“Learning to program has no more to do with designing interactive software than learning to touch type has to do with writing poetry” \n" +
                "- Ted Nelson");
        quotes.add("“Beware of bugs in the above code; I have only proved it correct, not tried it.” \n" +
                "- Donald E. Knuth");
        quotes.add("“I don't care if it works on your machine! We are not shipping your machine!” \n" +
                "- Vidiu Platon");
        quotes.add("“Sometimes it pays to stay in bed on Monday, rather than spending the rest of the week debugging Monday's code.” \n" +
                "- Christopher Thompson");
        quotes.add("“First learn computer science and all the theory. Next develop a programming style. Then forget all that and just hack.” \n" +
                "- George Carrette");
        quotes.add("“Most of you are familiar with the virtues of a programmer. There are three, of course: laziness, impatience, and hubris.” \n" +
                "- Larry Wall");
        quotes.add("“The trouble with programmers is that you can never tell what a programmer is doing until it’s too late.” \n" +
                "- Seymour Cray");
        quotes.add("“Most good programmers do programming not because they expect to get paid or get adulation by the public, but because it is fun to program.” \n" +
                "- Linus Torvalds");
        quotes.add("“Never trust a computer you can’t throw out a window.” \n" +
                "- Steve Wozniak");
        quotes.add("“Controlling complexity is the essence of computer programming.” \n" +
                "- Brian Kernigan");
        quotes.add("“The function of good software is to make the complex appear to be simple.” \n" +
                "- Grady Booch");
        quotes.add("“That’s the thing about people who think they hate computers. What they really hate is lousy programmers.” \n" +
                "- Larry Niven");
        quotes.add("“A computer is a stupid machine with the ability to do incredibly smart things, while computer programmers are smart people with the ability to do incredibly stupid things.” \n" +
                "- Bill Bryson");
        quotes.add("“First, solve the problem. Then, write the code.” \n" +
                "- John Johnson");
        quotes.add("“There are two ways to write error-free programs; only the third one works.” \n" +
                "- Alan J. Perlis");
        quotes.add("“Good code is its own best documentation.” \n" +
                "- Steve McConnell");
        quotes.add("“Any code of your own that you haven’t looked at for six or more months might as well have been written by someone else.” \n" +
                "- Eagleson’s Law");
        quotes.add("“The first 90% of the code accounts for the first 90% of the development time. The remaining 10% of the code accounts for the other 90% of the development time.” \n" +
                "- Tom Cargill");
        quotes.add("“If Java had true garbage collection, most programs would delete themselves upon execution.” \n" +
                "- Robert Sewell");
        return quotes;
    }

    @NonNull
    private ArrayList<String> createYodaArray() {
        final ArrayList<String> yoda = new ArrayList<>();
        yoda.add("If the process of removing software bugs, debugging is, then the process of putting them in, programming must be. \n" +
                "- Yoda");
        yoda.add("Like measuring aircraft building progress by weight, measuring programming progress by lines of code is.  \n" +
                "- Yoda");
        yoda.add("Understand, any fool can write code that a computer can.  Understand, good programmers write code that humans can.  Yes, hmmm.\n" +
                "- Yoda");
        yoda.add("Do not worry if it works not right. If everything did, out of a job you would be.  Hmmmmmm. \n" +
                "- Yoda");
        yoda.add("Frozen, walking on water and developing software from a specification are easy if both are.  Yes, hmmm.\n" +
                "- Yoda");
        yoda.add("Bugs like bunny anymore they make not.  Herh herh herh. \n" +
                "- Yoda");
        yoda.add("Fine, be like, java might be a good example of what a programming language should. But be like java applications are good examples of what applications should not.  \n" +
                "- Yoda");
        yoda.add("In the one and only true way.  Of 'spaghetti code' is the object-oriented version, of course, 'lasagna code'.  (too many layers).   \n" +
                "- Yoda");
        yoda.add("When someone says:  'i want a programming language in which I need only say what I wish done', give him a lollipop.  Hmmmmmm. \n" +
                "- Yoda");
        yoda.add("It adds cost good design adds value faster than.  Herh herh herh. \n" +
                "- Yoda");
        yoda.add("Cheap, talk is.  Me the code show.  Yeesssssss. \n" +
                "- Yoda");
        yoda.add("Achieved, perfection [in design] is, not when there is nothing more to add, but when, nothing left to take away, there is.  Yeesssssss. \n" +
                "- Yoda");
        yoda.add("In theory, the same, theory and practice are. In practice, not, they are not.  Hmmmmmm. \n" +
                "- Yoda");
        yoda.add("Have great software without a great team you cannot, and like dysfunctional families most software teams behave.  Yes, hmmm. \n" +
                "- Yoda");
        yoda.add("Like kicking yourself in the face, programming is, bleed, sooner or later your nose will.  Yeesssssss. \n" +
                "- Yoda");
        yoda.add("No more to do with designing interactive software, learning to program has, to do with writing poetry, than learning to touch type has.  \n" +
                "- Yoda");
        yoda.add("Of bugs in the above code beware; only proved it correct, I have, not tried it.  Hmmmmmm. \n" +
                "- Yoda");
        yoda.add("If it works on your machine I care not! We are shipping your machine not!  Yes, hmmm. \n" +
                "- Yoda");
        yoda.add("To stay in bed on monday sometimes it pays. Of the week debugging monday's code rather than spending the rest.  Yeesssssss. \n" +
                "- Yoda");
        yoda.add("First learn computer science and all the theory.  Next develop a programming style. Then forget all that and just hack.  Herh herh herh. \n" +
                "- Yoda");
        yoda.add("Most of, familiar with the virtues of a programmer, you are.  Three, there are, of course:  Laziness, impatience, and hubris. \n" +
                "- Yoda");
        yoda.add("The trouble with programmers is that you can never tell what a programmer is doing until, too late, is it.  Yes, hmmm. \n" +
                "- Yoda");
        yoda.add("Programming not, most good programmers do because they expect to get paid or get adulation by the public, but fun to program, because it is.   \n" +
                "- Yoda");
        yoda.add("Throw out a window, never trust a computer you cannot.   \n" +
                "- Yoda");
        yoda.add("The essence of computer programming, controlling complexity is.  Hmmmmmm. \n" +
                "- Yoda");
        yoda.add("To make the complex appear to be simple, the function of good software is.  Hmmmmmm. \n" +
                "- Yoda");
        yoda.add("The thing about people who think they hate computers, that is. Lousy programmers, what they really hate is. \n" +
                "- Yoda");
        yoda.add("Stupid machine with the ability to do incredibly smart things, a computer is, smart people with the ability to do incredibly stupid things, while computer programmers are.  Herh herh herh. \n" +
                "- Yoda");
        yoda.add("First, solve the problem. Then, write the code.  Yes, hmmm. \n" +
                "- Yoda");
        yoda.add("Two ways to write error-free programs, there are; only the third one works.  Hmmmmmm. \n" +
                "- Yoda");
        yoda.add("Its own best documentation, good code is.  Hmmmmmm. \n" +
                "- Yoda");
        yoda.add("Any code of your own that you have looked at for six or more months might as well have been written by someone else not.   \n" +
                "- Yoda");
        yoda.add("For the first 90% of the development time the first 90% of the code accounts. For the other 90% of the development time the remaining 10% of the code accounts.  Herh herh herh. \n" +
                "- Yoda");
        yoda.add("If java had true garbage collection, delete themselves upon execution, most programs would.   \n" +
                "- Yoda");
        return yoda;
    }

    private void startSpeak(final String data) {

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int initStatus) {
                if (initStatus == TextToSpeech.SUCCESS) {
                    if (tts.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE)
                        tts.setLanguage(Locale.US);
                    tts.setPitch(1.3f);
                    tts.setSpeechRate(0.9f);
                    // start speak
                    tts.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                } else if (initStatus == TextToSpeech.ERROR) {
                    Toast.makeText(getApplicationContext(), "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
                }
            }


        });

    }

}




