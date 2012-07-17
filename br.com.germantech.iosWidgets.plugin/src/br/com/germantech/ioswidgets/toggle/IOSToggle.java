package br.com.germantech.ioswidgets.toggle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import br.com.germantech.rm.SWTResourceManager;

public class IOSToggle extends Canvas {
	private static Display DISPLAY = Display.getDefault();
	
	private static Color COLOR_TOP = SWTResourceManager.getColor(174, 174, 174);
	private static Color COLOR_BOTTOM = SWTResourceManager.getColor(250, 250, 250);
	
	private static Color COLOR_TOP_SELECTED = SWTResourceManager.getColor(66, 128, 0);
	private static Color COLOR_BOTTOM_SELECTED = SWTResourceManager.getColor(97, 189,0);
	
	private static Color COLOR_WHITE = SWTResourceManager.getColor(SWT.COLOR_WHITE);
	private static Color COLOR_DARK_GRAY = SWTResourceManager.getColor(120,120,120);
	
	private static Font OS_FONT = SWTResourceManager.getFont(DISPLAY.getSystemFont().getFontData()[0]+"", 11, SWT.BOLD);
	
	private static int HEIGHT = 26;
	
	private static int ARC = 4;
	
	private boolean toggled = false;
	
	public IOSToggle(Composite parent) {
		this(parent, "Toggle");
	}

	public IOSToggle(final Composite parent, final String text) {
		super(parent, SWT.NONE);
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				int x = computeStringSize(parent, text);
				int status = x+16;
				int width = status;
				
				e.gc.setAntialias(SWT.ON);
				
				if(!toggled){
					//Paint upside down
					e.gc.setForeground(COLOR_TOP);
					e.gc.setBackground(COLOR_BOTTOM);
				
				} else {
					e.gc.setForeground(COLOR_TOP_SELECTED);
					e.gc.setBackground(COLOR_BOTTOM_SELECTED);
				}
				
				e.gc.fillGradientRectangle(0, 1,width, HEIGHT-1, true);
				e.gc.drawRoundRectangle(0, 0, width, HEIGHT, ARC, ARC);
				
				e.gc.setFont(OS_FONT);
				
				if(!toggled){
					e.gc.setForeground(COLOR_DARK_GRAY);
					e.gc.drawText(text,8, 5, true);
				} else {
					e.gc.setForeground(COLOR_WHITE);
					e.gc.drawText(text, 8, 5, true);
				}
				
				setSize(width+1, HEIGHT+1);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				setToggled(!toggled);
				redraw();
			}
		});
	}
	
	private int computeStringSize(Composite parent, String stringToCompute){
		Label label = null;
		try {
			label = new Label(parent, SWT.NONE);
			label.setFont(OS_FONT);
			label.setText(stringToCompute);
			Point computedSize = label.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			
			return computedSize.x;
		} catch (Exception e) {
			// Should do something
			return 0;
		} finally {
			if(label != null) {
				label.dispose();
			}
		}
	}
	
	public boolean isToggled() {
		return toggled;
	}
	
	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}

}
