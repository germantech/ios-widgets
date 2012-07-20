package br.com.germantech.helpers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import br.com.germantech.ioswidgets.IWidgetConstants;

public class IOSHelper {
	
	public static int computeStringSize(Composite parent, String stringToCompute){
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

}
