package labMetoda;
import javax.vecmath.*;

import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.behaviors.vp.*;
import com.sun.j3d.utils.image.TextureLoader;
import javax.swing.JFrame;
import com.sun.j3d.loaders.*;
import com.sun.j3d.loaders.objectfile.*;
import java.util.Hashtable;
import java.util.Enumeration;

public class labMetoda  extends JFrame{
  
	
	public Canvas3D myCanvas3D;
	
	 public labMetoda()
	 {
	 //механізм для закриття вікна та виходу з програми
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 //параметри перегляду сцени за замовчанням7
	 myCanvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
	 //створення SimpleUniverse (віртуального всесвіту)
	 SimpleUniverse simpUniv = new SimpleUniverse(myCanvas3D);
	 //положення глядача за замовчанням
	 simpUniv.getViewingPlatform().setNominalViewingTransform();
	 //створення сцени
	 createSceneGraph(simpUniv);
	 //додання світла у сцену
	 addLight(simpUniv);
	 //наступні рядки дозволяють навігацію по сцені за допомогою миші
	 OrbitBehavior ob = new OrbitBehavior(myCanvas3D);
	 ob.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE));
	 simpUniv.getViewingPlatform().setViewPlatformBehavior(ob);
	 //параметри вікна програми
	 setTitle("Alarm clock");
	 setSize(700,700);
	 getContentPane().add("Center", myCanvas3D);
	 setVisible(true);
	 }
	 public static void main(String[] args)
	 {
	   labMetoda labMetoda = new labMetoda();
	 }
	 //в цьому методі створюються об'єкти та додаються до сцени
	 public void createSceneGraph(SimpleUniverse su)
	 {
	// завантаження файлу .obj.
	 ObjectFile f = new ObjectFile(ObjectFile.RESIZE);
	 Scene alarmScene = null;
	 Scene tableScene = null;
	 try
	 {
	 alarmScene = f.load("alarm_clock.obj");
	 tableScene = f.load("table.obj");
	 }
	 catch (Exception e)
	 {
	 System.out.println("File loading failed:" + e);
	 }
	 //створення трансформаційної групи для завнтаженого будильника
	 Transform3D tfAlarm = new Transform3D();
	 tfAlarm.rotZ(0);
	 tfAlarm.rotY(Math.PI/3);
	 tfAlarm.setScale(1.0/6);
	 tfAlarm.setTranslation(new Vector3d(0.5f,0.0f,-0.4f));
	 TransformGroup tgAlarm = new TransformGroup(tfAlarm);
	 //створення трансформаційної групи для завнтаженого стола
	 Transform3D tfObjectTable = new Transform3D();
	 tfObjectTable.setTranslation(new Vector3d(0.0f,-0.61f,0.0f));
	 TransformGroup tgObjectTable = new TransformGroup(tfObjectTable);
	 tgObjectTable.addChild(tableScene.getSceneGroup());
	 //отримання імен об'єктів, з яких складаються будильник та стіл
	 //та вивід в консоль назв об'єктів, з яких складається стіл 8
	 Hashtable alarmNamedObjects = alarmScene.getNamedObjects();
	 Hashtable tableNamedObjects = tableScene.getNamedObjects();
	 Enumeration enumer = tableNamedObjects.keys();
	 String name;
	 while (enumer.hasMoreElements())
	 {
	 name = (String) enumer.nextElement();
	 System.out.println("Name: "+name);
	 }
	 //завантаження зображення для ткстури
	 TextureLoader textureLoad = new TextureLoader("table.jpg",null);
	 ImageComponent2D textureIm = textureLoad.getImage();
	 //створення текстури
	 Texture2D woodTexture = new Texture2D(Texture2D.BASE_LEVEL,Texture2D.RGB,
	 textureIm.getWidth(),
	 textureIm.getHeight());
	 woodTexture.setImage(0,textureIm);
	 //створення матеріалу з текстурою
	 Appearance textureApp = new Appearance();
	 textureApp.setTexture(woodTexture);
	 TextureAttributes textureAttr = new TextureAttributes();
	 textureAttr.setTextureMode(TextureAttributes.REPLACE);
	 textureApp.setTextureAttributes(textureAttr);
	 Material mat = new Material();
	 mat.setShininess(120.0f);
	 mat.setSpecularColor(new Color3f(0.7f,0.2f,0.1f));
	 textureApp.setMaterial(mat);
	 //накладання матеріалу столу
	 Shape3D tableObj = (Shape3D) tableNamedObjects.get("table");
	 tableObj.setAppearance(textureApp);
	 //пофарбуємо циферблат у білий колір
	 Appearance whiteApp = new Appearance();
	 setToMyDefaultAppearance(whiteApp,new Color3f(1.0f,1.0f,1.0f));
	 Shape3D dial = (Shape3D) alarmNamedObjects.get("dial");
	 dial.setAppearance(whiteApp);
	 //пофарбуємо корпус будильника у помаранчевий колір
	 Appearance lightRedApp = new Appearance();
	 setToMyDefaultAppearance(lightRedApp,new Color3f(0.8f,0.1f,0.0f));
	 Shape3D clock_obod = (Shape3D) alarmNamedObjects.get("cylinder05");
	 clock_obod.setAppearance(lightRedApp);
	 
	 Shape3D minute_arrow = (Shape3D) alarmNamedObjects.get("minute_arrow");
	 Shape3D hour_arrow = (Shape3D) alarmNamedObjects.get("hour_arrow");
	 //додавання всіх об'єктів будильника, крім хвилинної та годинної стрілки, у сцену 
	 Shape3D[] clock = new Shape3D[] {(Shape3D) alarmNamedObjects.get("sphere02"), clock_obod, 
	 (Shape3D) alarmNamedObjects.get("hammer"),(Shape3D) 
	alarmNamedObjects.get("alarm_arrow"),
	 (Shape3D) alarmNamedObjects.get("twelve"),(Shape3D) alarmNamedObjects.get("three"),
	 (Shape3D) alarmNamedObjects.get("six"),(Shape3D) alarmNamedObjects.get("nine"),
	 (Shape3D) alarmNamedObjects.get("cylinder07"),(Shape3D) 
	alarmNamedObjects.get("cylinder06"),
	 (Shape3D) alarmNamedObjects.get("rectangle03"), dial, (Shape3D) 
	alarmNamedObjects.get("sphere03")};
	 for (Shape3D shape:clock){
	 tgAlarm.addChild(shape.cloneTree());
	 }
	 
	 //група трансформації годинної стрілки
	 TransformGroup tgmHourArrow = new TransformGroup();
	 tgmHourArrow.addChild(hour_arrow.cloneTree());
	 //повернемо площину обертання на 90 градусів відносно осі Z
	 Transform3D hourArrowRotationAxis = new Transform3D();
	 hourArrowRotationAxis.rotZ(Math.PI/2);
	 
	 int timeStart = 2000; //стрілка почне рух через 2 секунди після запуску програми
	 int noRotationsHour = 2; //кількість обертів
	 int timeRotationHour = 36000;//час одного оберту
	 //Alpha для руху годинної стрілки
	 Alpha hourRotationAlpha = new Alpha(noRotationsHour,
	 Alpha.INCREASING_ENABLE,
	timeStart,
	 0,timeRotationHour,0,0,0,0,0);
	 //обертання годинної стрілки
	 RotationInterpolator hourArrRotation = new RotationInterpolator(
	 
	hourRotationAlpha,tgmHourArrow,
	 
	hourArrowRotationAxis,(float) Math.PI*2,0.0f);
	 BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE);
	 hourArrRotation.setSchedulingBounds(bounds);
	 tgmHourArrow.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	 tgmHourArrow.addChild(hourArrRotation);
	 
	 //група трансформації хвилинної стрілки
	 TransformGroup tgmMinArrow = new TransformGroup();
	 tgmMinArrow.addChild(minute_arrow.cloneTree());
	 //повернемо площину обертання на 90 градусів відносно осі Z
	 Transform3D minArrowRotationAxis = new Transform3D();
	 minArrowRotationAxis.rotZ(Math.PI/2); 
	 
	 int noStartRotationsMin = 24; //всього рух відбудеться 24 рази
	 int timeRotationMin = 3000;//1 оберт займе 3 секунди
	 Alpha minRotationAlpha = new Alpha(noStartRotationsMin,
	 Alpha.INCREASING_ENABLE,
	 timeStart,0,timeRotationMin,0,0,0,0,0);
	 //обертання хвилинної стрілки
	 RotationInterpolator minArrRotation = new RotationInterpolator(
	 minRotationAlpha, tgmMinArrow,
	 minArrowRotationAxis,(float) Math.PI*2,0.0f); 
	 
	 minArrRotation.setSchedulingBounds(bounds);
	 tgmMinArrow.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	 tgmMinArrow.addChild(minArrRotation);
	 
	 //розміщуємо будильник
	 Transform3D tfRotor = new Transform3D();
	 tfRotor.rotY(Math.PI/3);//розміщуємо у напівоберті до користувача
	 tfRotor.setScale(1.0/6);//зменшуємо будильник у 6 разів
	 tfRotor.setTranslation(new Vector3d(0.5f,0.0f,-0.4f));//переміщуємо
	 TransformGroup tgAlarmArrows = new TransformGroup(tfRotor);
	 tgAlarmArrows.addChild(tgmHourArrow);
	 tgAlarmArrows.addChild(tgmMinArrow);
	 //створення сцени
	 BranchGroup theScene = new BranchGroup();
	 theScene.addChild(tgAlarmArrows);//додаємо стрілки
	 theScene.addChild(tgAlarm);//додаємо будильник
	 theScene.addChild(tgObjectTable);//додаємо стіл
	 //створюємо білий фон
	 Background bg = new Background(new Color3f(1.0f,1.0f,1.0f));
	 bg.setApplicationBounds(bounds);
	 theScene.addChild(bg);
	 
	 theScene.compile();
	 //додаємо сцену до віртуального всесвіту
	 su.addBranchGraph(theScene);
	 }
	 //метод для генерації зовнішньої поверхні
	 public static void setToMyDefaultAppearance(Appearance app, Color3f col)
	 {
	 app.setMaterial(new Material(col,col,col,col,150.0f));
	 }
	 //метод для додавання освітлення
	 public void addLight(SimpleUniverse su)
	 {
	 BranchGroup bgLight = new BranchGroup();
	 BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
	 Color3f lightColour1 = new Color3f(1.0f,1.0f,1.0f);
	 Vector3f lightDir1 = new Vector3f(-1.0f,0.0f,-0.5f);
	 DirectionalLight light1 = new DirectionalLight(lightColour1, lightDir1);
	 light1.setInfluencingBounds(bounds);
	 bgLight.addChild(light1);
	 su.addBranchGraph(bgLight);
	 }
	 
}
