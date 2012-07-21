package br.com.germantech.ioswidgets.checkbox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import br.com.germantech.ioswidgets.IWidgetConstants;

public class IOSShuffleCheckbox extends Canvas {
	
	private static Image SLIDER = 
			new Image(Display.getDefault(), IOSCheckbox.class.getResourceAsStream("slider.png"));
	
	private static int SLIDER_WIDTH = SLIDER.getImageData().width;
	private static int HEIGHT = 26;
	
	private boolean selected = false;
	
	/**
	 * Instantiates a new {@link IOSShuffleCheckbox} component, defaults unselected
	 * @param parent the parent composite
	 */
	public IOSShuffleCheckbox(final Composite parent) {
		super(parent, SWT.NONE);
		
		addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				
				int width = 50+SLIDER_WIDTH;
				
				e.gc.setAntialias(SWT.ON);
				e.gc.setAdvanced(true);
				
				if(!selected){
					e.gc.setForeground(IWidgetConstants.COLOR_TOP);
					e.gc.setBackground(IWidgetConstants.COLOR_BOTTOM);
				
				} else {
					e.gc.setForeground(IWidgetConstants.COLOR_TOP_SELECTED_GREEN);
					e.gc.setBackground(IWidgetConstants.COLOR_BOTTOM_SELECTED_GREEN);
				}
				
				e.gc.fillGradientRectangle(1, 1,width-1, HEIGHT-1, true);
				e.gc.drawRoundRectangle(0, 0, width, HEIGHT, IWidgetConstants.ARC_WIDTH_HEIGHT, IWidgetConstants.ARC_WIDTH_HEIGHT);
				
				e.gc.setFont(IWidgetConstants.OS_FONT);
				
				
				if(!selected){
					e.gc.setForeground(IWidgetConstants.COLOR_DARK_GRAY);
					e.gc.drawImage(SLIDER, 0, 0);
				} else {
					int end = width - SLIDER_WIDTH + 1;
					e.gc.drawImage(SLIDER, end, 0);
					e.gc.setForeground(IWidgetConstants.COLOR_WHITE);
				}
				
				setSize(width+1, HEIGHT+1);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				setSelected(!selected);
				redraw();
			}
		});
	}
	
	public boolean isSelected() {
		checkWidget();
		return selected;
	}
	
	public void setSelected(boolean selected) {
		checkWidget();
		this.selected = selected;
	}
}
