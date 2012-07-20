package br.com.germantech.ioswidgets.button;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import br.com.germantech.helpers.IOSHelper;
import br.com.germantech.ioswidgets.IWidgetConstants;
import br.com.germantech.resourceManager.SWTResourceManager;

public class IOSButton extends Canvas {
	private String text;
	private boolean clicked = false;

	public IOSButton(final Composite parent, String text) {
		super(parent, SWT.NONE);
		this.text = text;
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				e.gc.setAntialias(SWT.ON);
				int width = IOSHelper.computeStringSize(parent, getText()) + 16;
				
				if(!clicked){
					e.gc.setForeground(IWidgetConstants.COLOR_BUTTON_TOP);
					e.gc.setBackground(IWidgetConstants.COLOR_BUTTON_BOTTOM);
				} else {
					e.gc.setForeground(IWidgetConstants.COLOR_BUTTON_BOTTOM);
					e.gc.setBackground(IWidgetConstants.COLOR_BUTTON_TOP);
				}
				
				e.gc.fillGradientRectangle(1, 1, width-1, 25, true);
				e.gc.setForeground(IWidgetConstants.COLOR_BORDER);
				e.gc.drawRoundRectangle(0, 0, width, 26, IWidgetConstants.ARC, IWidgetConstants.ARC);
				
				e.gc.setFont(IWidgetConstants.OS_FONT);
				e.gc.setForeground(IWidgetConstants.COLOR_BORDER);
				e.gc.drawString(getText(), 7, 3, true);
				
				e.gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				e.gc.drawString(getText(), 8, 4, true);
				
				
				setSize(width+1, 27);
			}
		});
		
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				clicked = false;
				redraw();
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				clicked = true;
				redraw();
			}
		});
	}
	

	public void setText(String text) {
		redraw();
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
