package br.com.germantech.ioswidgets.toggle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import br.com.germantech.ioswidgets.IWidgetConstants;

public class IOSToggle extends Canvas {
	private static int HEIGHT = 26;
	
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
					e.gc.setForeground(IWidgetConstants.COLOR_TOP);
					e.gc.setBackground(IWidgetConstants.COLOR_BOTTOM);
				
				} else {
					e.gc.setForeground(IWidgetConstants.COLOR_TOP_SELECTED_GREEN);
					e.gc.setBackground(IWidgetConstants.COLOR_BOTTOM_SELECTED_GREEN);
				}
				
				e.gc.fillGradientRectangle(0, 1,width, HEIGHT-1, true);
				e.gc.drawRoundRectangle(0, 0, width, HEIGHT, IWidgetConstants.ARC, IWidgetConstants.ARC);
				
				e.gc.setFont(IWidgetConstants.OS_FONT);
				
				if(!toggled){
					e.gc.setForeground(IWidgetConstants.COLOR_DARK_GRAY);
					e.gc.drawText(text,8, 5, true);
				} else {
					e.gc.setForeground(IWidgetConstants.COLOR_WHITE);
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
			label.setFont(IWidgetConstants.OS_FONT);
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
