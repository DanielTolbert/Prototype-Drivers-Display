import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Display extends Application {


    public void start( Stage stage ) {

        BorderPane root = new BorderPane( );
        Scene scene = new Scene( root, Color.WHITE );
        Image abtn = new Image( "abtn.png" );
        Image bbtn = new Image( "bbtn.png" );
        Image wht = new Image( "White.png" );
        Canvas canvas = new Canvas( 500, 500 );

        //Initialize images

        //Draw Images
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage( abtn, canvas.getWidth()/2, canvas.getHeight()/2);

        root.setCenter( canvas );

        stage.setScene( scene );

        HashSet<String> inputs = new HashSet<>(  );

        scene.setOnKeyPressed( e -> inputs.add( e.getCode().toString() ));

        scene.setOnKeyReleased( e -> inputs.remove( e.getCode().toString() ) );

        final long startTime = System.nanoTime();

        new AnimationTimer() {
//            double vector = 5;
            double currentX = canvas.getWidth()/2;
            double currentY = canvas.getHeight()/2;
                Image currentImage = wht;
            public void handle( long currentNanoTime ) {

//                switch ( ) {

//                }


                System.out.println( inputs.toString() );

                gc.clearRect( 0, 0, canvas.getWidth(), canvas.getHeight() );
                gc.drawImage( currentImage, currentX, currentY );
            }
        }.start();

        stage.show();

    }


    public static void main ( String[] args ) {
        launch( args );
    }

}
