package br.com.germantech.ioswidgets.slider;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import br.com.germantech.ioswidgets.IWidgetConstants;

public class IOSSlider extends Canvas {

	private int totalSize;
	private Image SLIDER = new Image(getDisplay(), IOSSlider.class.getResourceAsStream("brush25.png"));

	public IOSSlider(Composite parent, int totalSize) {
		super(parent, SWT.NONE);
		this.totalSize = totalSize;
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				e.gc.setAntialias(SWT.ON);
				e.gc.setAdvanced(true);
				e.gc.setForeground(IWidgetConstants.COLOR_DARK_GRAY);
				int y = SLIDER.getImageData().width/2;
				
				//Draw a rectangle
				e.gc.setForeground(IWidgetConstants.COLOR_TOP);
				e.gc.setBackground(IWidgetConstants.COLOR_BOTTOM);
				
				e.gc.fillGradientRectangle(11, y/2+1, 200-1, y-1, true);
				e.gc.drawRoundRectangle(10, y/2, 200, y, 8,8);
				int pos = 100;
				e.gc.drawImage(SLIDER, pos, 0);
				e.gc.drawArc(pos, 0, SLIDER.getImageData().width, SLIDER.getImageData().height, 0, 500);
				
				setSize(SLIDER.getImageData().width+200, SLIDER.getImageData().height+10);
			}
		});
	}
	

	public int getTotalSize() {
		return totalSize;
	}
	
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

}
