module lab4_ {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	requires vecmath;
	requires j3dutils;
	requires j3dcore;
	opens application to javafx.graphics, javafx.fxml;
}
