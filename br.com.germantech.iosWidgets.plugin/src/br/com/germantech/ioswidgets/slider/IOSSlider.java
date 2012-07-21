package br.com.germantech.ioswidgets.slider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import br.com.germantech.ioswidgets.IWidgetConstants;
import br.com.germantech.ioswidgets.slider.listener.IOSSliderListener;

/**
 * 
 * @author Luiz Eduardo Kowalski, Alexsando Specht
 *
 */
public class IOSSlider extends Canvas {

	private int totalSize;
	private Image SLIDER = new Image(getDisplay(), IOSSlider.class.getResourceAsStream("brush25.png"));
	protected boolean down;
	protected int x = 0;
	private int position = 0;
	private List<IOSSliderListener> listeners = new ArrayList<IOSSliderListener>();

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
				
				//Draw the path
				e.gc.setForeground(IWidgetConstants.COLOR_TOP);
				e.gc.setBackground(IWidgetConstants.COLOR_BOTTOM);
				
				e.gc.fillGradientRectangle(11, y/2+1, getTotalSize()-1, y-1, true);
				e.gc.drawRoundRectangle(10, y/2, getTotalSize(), y, 8,8);
				//End
				
				e.gc.drawImage(SLIDER, x, 0);
				e.gc.drawArc(x, 0, SLIDER.getImageData().width, SLIDER.getImageData().height, 0, 500);
			}
		});
		
		addMouseMoveListener(new MouseMoveListener() {
			
			@Override
			public void mouseMove(MouseEvent e) {
				if(e.x <0 || e.x > getTotalSize())
					return;
				
				if(down){
					x = e.x;
					if(x >= 0 && x <= getTotalSize()){
						setPosition(x);
						fireListeners();
						redraw();
					}
					
				}
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				down = true;
			}
			
			@Override
			public void mouseUp(MouseEvent e) {
				down = false;
			}
		});
		
		addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseScrolled(MouseEvent e) {
				if(e.count == -3){
					if(x >= 10)
						x-=10;
					else 
						x = 0;
				} else {
					if(x >= getTotalSize()-10)
						x=getTotalSize();
					else
						x+=10;
				}
				
				redraw();
				setPosition(x);
				fireListeners();
			}
		});
		
		setSize(getTotalSize(), SLIDER.getImageData().height+10);
	}
	
	private void fireListeners() {
		for (IOSSliderListener listener : listeners) {
			listener.fire(getPosition());
		}
	}

	public void addIOSSliderListener(IOSSliderListener listener){
		checkWidget();
		this.listeners.add(listener);
	}
	

	public int getTotalSize() {
		return totalSize;
	}
	
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}

}
