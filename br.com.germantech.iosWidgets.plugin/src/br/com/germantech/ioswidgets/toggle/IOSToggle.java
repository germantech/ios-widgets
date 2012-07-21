package br.com.germantech.ioswidgets.toggle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import br.com.germantech.helpers.IOSHelper;
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
				int x = IOSHelper.computeStringSize(parent, text);
				int status = x+16;
				int width = status;
				
				e.gc.setAntialias(SWT.ON);
				e.gc.setAdvanced(true);
				
				if(!toggled){
					e.gc.setForeground(IWidgetConstants.COLOR_TOP);
					e.gc.setBackground(IWidgetConstants.COLOR_BOTTOM);
				
				} else {
					e.gc.setForeground(IWidgetConstants.COLOR_TOP_SELECTED_GREEN);
					e.gc.setBackground(IWidgetConstants.COLOR_BOTTOM_SELECTED_GREEN);
				}
				
				e.gc.fillGradientRectangle(1, 1, width-1, HEIGHT-1, true);
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
	
	public boolean isToggled() {
		checkWidget();
		return toggled;
	}
	
	public void setToggled(boolean toggled) {
		checkWidget();
		this.toggled = toggled;
	}

}
