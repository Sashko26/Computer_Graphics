package application;
	
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Main extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 600);
        {
             MoveTo start = new MoveTo(200, 200);
             HLineTo hLineTo = new HLineTo(300);
             VLineTo vLineTo1 = new VLineTo(250);
             // Top part
			
			 ArcTo bottom = new ArcTo(100, 70, 0, 200, 250, false, true); 
			 VLineTo vLineTo2 = new VLineTo(200);
			 
             Path drum = new Path();
             drum.setStrokeWidth(1);
		   
			 drum.setStroke(Color.BLACK); 
            
             //закрашення барабану градієнтом
              drum.setFill(Color.RED);
			
			  //рисовка барабану 
              drum.getElements().add(start); 
			  drum.getElements().add(hLineTo);
			  drum.getElements().add(vLineTo1); 
			  drum.getElements().add(bottom); 
			  drum.getElements().add(vLineTo2);
			  root.getChildren().add(drum);
        }

       	{
			  // перший лівий дзеркальний декоративний круг 
	          Ellipse e1 = new Ellipse(233, 187, 5, 5);
	          e1.setStrokeWidth(1); 
	          e1.setStroke(Color.BLACK);
			  e1.setFill(Color.BROWN);
			  
			  
			  // перший правий дзеркальний декоративний круг 
			   Ellipse e2 = new Ellipse(266,
			   187, 5, 5);
			   e2.setStrokeWidth(1);
			   e2.setStroke(Color.BLACK);
			   e2.setFill(Color.BROWN);
			   root.getChildren().add(e1); 
			   root.getChildren().add(e2);
		  
		}
		  
		  { 
			  // смужка каркасу, що тримає лівий тримач ленти
		  
			  Path p = new Path();
			  p.setStrokeWidth(1);
			  p.setStroke(Color.BLACK);
			  p.setFill(Color.BROWN);
			  p.getElements().add(new MoveTo(200, 200));
			  p.getElements().add(new LineTo(203, 250));
			  p.getElements().add(new ArcTo(3,
			  3, 0, 197, 250, false, true));
			  p.getElements().add(new LineTo(200, 200));
			  root.getChildren().add(p);
		  
		  
		  }
		  
		  { 
			  // ліва смужка каркасу 
			  Path p = new Path(); 
			  p.setStrokeWidth(1);
			  p.setStroke(Color.BLACK);
			  p.setFill(Color.BROWN);
			  p.getElements().add(new
			  MoveTo(233, 213));
			  p.getElements().add(new LineTo(236, 258));
			  p.getElements().add(new ArcTo(3, 3, 0, 230, 258, false, true));
			  p.getElements().add(new LineTo(233, 213));
			  root.getChildren().add(p);
		  
		  }
		  
		  { 
		      // права смужка каркасу
			  Path p = new Path(); 
			  p.setStrokeWidth(1);
			  p.setStroke(Color.BLACK);
			  p.setFill(Color.BROWN);
			  p.getElements().add(new
			  MoveTo(266, 213));
			  p.getElements().add(new LineTo(269, 258));
			  p.getElements().add(new ArcTo(3, 3, 0, 263, 258, false, true));
			  p.getElements().add(new LineTo(266, 213));
			  root.getChildren().add(p);
		  
		  }
		  
		  { 
			  // смужка каркасу, що тримає правий тримач ленти
			  Path p = new Path();
			  p.setStrokeWidth(1);
			  p.setStroke(Color.BLACK); 
			  p.setFill(Color.BROWN);
			  p.getElements().add(new MoveTo(300, 200)); 
			  p.getElements().add(new
			  LineTo(303, 250)); 
			  p.getElements().add(new ArcTo(3, 3, 0, 297, 250, false,true)); 
			  p.getElements().add(new LineTo(300, 200)); 
			  root.getChildren().add(p);
		  
		  }
		  
		  { 
		      //покриття барабану (свиняча жовта шкіра) 
			  Ellipse ellipse = new Ellipse(250, 200, 50, 15); 
			  ellipse.setStrokeWidth(1);
			  ellipse.setStroke(Color.BLACK); 
			  ellipse.setFill(Color.YELLOW);
			  root.getChildren().add(ellipse);
		  
		  }
		  
		  { 
			  //ліве кріплення для ленти 
			  Ellipse e1 = new Ellipse(200, 200, 5, 5);
			  e1.setStrokeWidth(1); e1.setStroke(Color.BLACK); 
			  e1.setFill(Color.BROWN); 
			  //перший лівий декоративний круг 
			  Ellipse e2 = new Ellipse(233, 213, 5, 5);
			  e2.setStrokeWidth(1); 
			  e2.setStroke(Color.BLACK); e2.setFill(Color.BROWN); 
			  //перший правий декоративний круг 
			  Ellipse e3 = new Ellipse(266, 213, 5, 5);
			  e3.setStrokeWidth(1);
			  e3.setStroke(Color.BLACK);
			  e3.setFill(Color.BROWN);
			  //праве кріплення для ленти 
			  Ellipse e4 = new Ellipse(300, 200, 5, 5);
			  e4.setStrokeWidth(1);
			  e4.setStroke(Color.BLACK);
			  e4.setFill(Color.BROWN);
			  root.getChildren().add(e1);
			  root.getChildren().add(e2);
			  root.getChildren().add(e3);
			  root.getChildren().add(e4);
		  
		  
		  }
		  
		  { 
			  //рисовка лівої палички 
			  Path p = new Path(); 
			  p.getElements().addAll( new MoveTo(200, 130), new LineTo(250, 150), new ArcTo(10, 10, 0, 248, 155, true,
			  true), new LineTo(200, 135), new ArcTo(2, 2, 30, 200, 130, false, true) );
			  p.setStrokeWidth(1); 
			  p.setStroke(Color.BLACK);
			  p.setFill(Color.ORANGE);
			  root.getChildren().add(p);
		  
		  }
		  
		  { 
			  //рисовка правої палички 
			  Path p = new Path(); 
			  p.getElements().addAll( new
			  MoveTo(310, 150), new LineTo(260, 190), new ArcTo(10, 10, 0, 265, 195, true,
			  false), new LineTo(310, 155), new ArcTo(2, 2, 0, 310, 150, false, false) );
			  p.setStrokeWidth(1); 
			  p.setStroke(Color.BLACK);
			  p.setFill(Color.ORANGE);
			  root.getChildren().add(p);
			  
		  }
		  
		  {
		  
		  
		  // рисовка ленти 
			  Path stripe = new Path(); 
			  var x = 200; 
			  var y = 200;
		  stripe.getElements().addAll(
				
				  
				// менший кістяк ленти
				  new MoveTo(x, y), 
				  new CubicCurveTo(-30 + x, 30 + y, -5 + x, 39 + y, -30 + x, 70 + y), 
				  new CubicCurveTo(-40 + x, 80 + y, -20 + x, 122 + y, 10 + x, 100 + y), 
				  new QuadCurveTo(50 + x, 50 + y, 90 + x, 97 + y), 
				  new CubicCurveTo(-10 + 100 + x, 100 + y, 40 + 100 + x, 130 + y, 123 + x, 70 + y), 
				  new CubicCurveTo(-10 + 100 + x, 30 + y, 30 + 100 + x, 10 + y, 100 + x, y), 
				  
				// більший кістяк ленти
				   new CubicCurveTo(130 + x, y, 110 + x, 11 + y, 115 + x, 45 + y), 
				  new CubicCurveTo(143 + x, 70 + y, 40 + 100 + x, 130 + y, -5 + 100 + x, 110 + y),
				  new CubicCurveTo(80 + x, 90 + y, 50 + x, 50 + y, 5 + x, 110 + y), 
				  new CubicCurveTo(-40 + x, 130 + y, -43 + x, 70 + y, -30 + x, 53 + y), 
				  new CubicCurveTo(-20 + x, 45 + y, -20 + x, 5 + y, x, y) );
		  		  stripe.setStrokeWidth(1);
		  		  stripe.setStroke(Color.BLACK);
					
					 stripe.setFill(Color.BLUE);
					 
		          root.getChildren().add(stripe);
		  
		  }
		  
		  	  int cycleCount = 2; 
		  	  int time = 2000;
			  
		  	  //масштабування барабану
			  ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(time),root);
			  scaleTransition.setToX(2);
			  scaleTransition.setToY(2);
			  scaleTransition.setAutoReverse(true);
			  
			  
			  
			  // поворот на 360 градусів
			  RotateTransition rotateTransition = new
			  RotateTransition(Duration.millis(time), root);
			  rotateTransition.setByAngle(360f);
			  rotateTransition.setCycleCount(cycleCount);
			  rotateTransition.setAutoReverse(true);
			  
			  
			  //переміщення по x
			  TranslateTransition translateTransition = new
			  TranslateTransition(Duration.millis(time), root);
			  translateTransition.setFromX(150); 
			  translateTransition.setToX(0);
			  translateTransition.setCycleCount(cycleCount+1);
			  translateTransition.setAutoReverse(true);
			  
			  //масштабування у напрямку зменшення
			  ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(time),root);
			  scaleTransition2.setToX(0.1); scaleTransition2.setToY(0.1);
			  scaleTransition2.setCycleCount(cycleCount);
			  scaleTransition2.setAutoReverse(true);
			 
			  //паралельна рисовка всіх анімацій
			  ParallelTransition parallelTransition = new ParallelTransition();
			  parallelTransition.getChildren().addAll(rotateTransition,scaleTransition,translateTransition,scaleTransition2);
			  parallelTransition.setCycleCount(Timeline.INDEFINITE);
			  
			  //старт паралельної анімації
				 parallelTransition.play();
			  // End of animation
			  primaryStage.setTitle("Lab 3");
			  // встановлення сцени 
			  primaryStage.setScene(scene);
			  
			  // стартувати показ
			  primaryStage.show();
		 
    }

}

