package br.com.germantech.ioswidgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

import br.com.germantech.resourceManager.SWTResourceManager;

/**
 * Class used to define static values for all widgets
 * @author Luiz Eduardo Kowalski <@luizkowalski>
 *
 */
public interface IWidgetConstants {

	public static Color COLOR_TOP = SWTResourceManager.getColor(174, 174, 174);
	public static Color COLOR_BOTTOM = SWTResourceManager.getColor(250, 250, 250);
	 
	public static Color COLOR_TOP_SELECTED = SWTResourceManager.getColor(55, 114, 185);
	public static Color COLOR_BOTTOM_SELECTED = SWTResourceManager.getColor(130, 179, 244);
	
	public static Color COLOR_TOP_SELECTED_GREEN = SWTResourceManager.getColor(66, 128, 0);
	public static Color COLOR_BOTTOM_SELECTED_GREEN = SWTResourceManager.getColor(97, 189,0);
	
	public static Color COLOR_WHITE = SWTResourceManager.getColor(SWT.COLOR_WHITE);
	public static Color COLOR_DARK_GRAY = SWTResourceManager.getColor(120,120,120);
	
	public static Font OS_FONT = SWTResourceManager.getFont(Display.getDefault().getSystemFont().getFontData()[0]+"", 11, SWT.BOLD);
	
	public static Integer ARC = 6;
}
