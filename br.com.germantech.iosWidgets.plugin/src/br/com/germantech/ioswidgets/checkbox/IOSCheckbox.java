package br.com.germantech.ioswidgets.checkbox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import br.com.germantech.rm.SWTResourceManager;

/**
 * iPhone checkbox-like for SWT
 * @author Luiz Eduardo Kowalski <@luizkowalski>
 *
 */
public class IOSCheckbox extends Canvas {
	
	private static Display DISPLAY = Display.getDefault();
	
	private static Color COLOR_TOP = SWTResourceManager.getColor(174, 174, 174);
	private static Color COLOR_BOTTOM = SWTResourceManager.getColor(250, 250, 250);
	
	private static Color COLOR_TOP_SELECTED = SWTResourceManager.getColor(43, 93, 154);
	private static Color COLOR_BOTTOM_SELECTED = SWTResourceManager.getColor(116, 161, 216);
	
	private static Color COLOR_WHITE = SWTResourceManager.getColor(SWT.COLOR_WHITE);
	private static Color COLOR_DARK_GRAY = SWTResourceManager.getColor(120,120,120);
	
	private static Font OS_FONT = SWTResourceManager.getFont(DISPLAY.getSystemFont().getFontData()[0]+"", 11, SWT.BOLD);
	
	private static Image SLIDER = new Image(Display.getDefault(), IOSCheckbox.class.getResourceAsStream("slider.png"));
	
//	private static Cursor CURSOR_NO = new Cursor(DISPLAY, SWT.CURSOR_NO);
//	private static Cursor CURSOR_OK= new Cursor(DISPLAY, SWT.CURSOR_ARROW);
	
	private static int SLIDER_WIDTH = SLIDER.getImageData().width;
	private static int HEIGHT = 26;
	
	private static int ARC = 6;
	
	private boolean selected = false;
	
	/**
	 * Default constructor with values "Sim" and "Não" for selected and unselected values, respectively
	 * @param parent
	 */
	public IOSCheckbox(final Composite parent) {
		this(parent, "Sim", "Não");
	}

	/**
	 * Instantiates a new {@link IOSCheckbox} component, defaults unselected
	 * @param parent the parent composite
	 * @param textSelected the default {@link String} when checkbox is selected
	 * @param textUnselected the default {@link String} when checkbox is unselected
	 */
	public IOSCheckbox(final Composite parent, final String textSelected, final String textUnselected) {
		super(parent, SWT.NONE);
		
		addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				String biggestString = textSelected.length() > textUnselected.length() ? textSelected : textUnselected;
				
				int x = computeStringSize(parent, biggestString);
				int xOff = computeStringSize(parent, textUnselected);
				int status = x+16;
				int width = status+SLIDER_WIDTH;
				
				e.gc.setAntialias(SWT.ON);
				
				if(!selected){
					e.gc.setForeground(COLOR_TOP);
					e.gc.setBackground(COLOR_BOTTOM);
				
				} else {
					e.gc.setForeground(COLOR_TOP_SELECTED);
					e.gc.setBackground(COLOR_BOTTOM_SELECTED);
				}
				
				e.gc.fillGradientRectangle(0, 1,width, HEIGHT-1, true);
				e.gc.drawRoundRectangle(0, 0, width, HEIGHT, ARC, ARC);
				
				e.gc.setFont(OS_FONT);
				
				
				if(!selected){
					e.gc.setForeground(COLOR_DARK_GRAY);
					e.gc.drawText(textUnselected, width-xOff-8, 6, true);
					e.gc.drawImage(SLIDER, 0, 0);
				} else {
					int end = width - SLIDER_WIDTH + 1;
					e.gc.drawImage(SLIDER, end, 0);
					e.gc.setForeground(COLOR_WHITE);
					e.gc.drawText(textSelected, 8, 6, true);
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
	
	/**
	 * Computes a String size
	 */
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
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
